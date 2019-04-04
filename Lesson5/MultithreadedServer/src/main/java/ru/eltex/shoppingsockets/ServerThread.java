package ru.eltex.shoppingsockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.eltex.shoppingcustomer.Order;
import ru.eltex.shoppingcustomer.ShoppingCart;
import ru.eltex.shoppingprocessing.ACheckAwaiting;
import ru.eltex.shoppingprocessing.Orders;
import ru.eltex.shoppingserializing.ShoppingCartTypeAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class ServerThread extends Thread {
    private final int BUFSIZE = 10000;

    private Socket socket;
    private int udpPort;
    private InetAddress IPAddress;
    private Orders orders = new Orders();
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson;

    public ServerThread(Socket socket, InetAddress IPAddress, int udpPort)
    {
        this.socket = socket;
        this.udpPort = udpPort;
        this.IPAddress = IPAddress;
        builder.registerTypeAdapter(ShoppingCart.class, new ShoppingCartTypeAdapter());
        gson = builder.create();
    }

    @Override
    public void run() {
        final int TIMEOUT = 60000;

        try {
            socket.setSoTimeout(TIMEOUT);
        } catch (SocketException e) {
            System.out.println(e.getMessage());
            return;
        }

        InputStream in = null;
        DatagramSocket udpSocket = null;

        try {
            int myUdpPort = 1025 + (int)(Math.random() * 65535);
            in = socket.getInputStream();
            udpSocket = new DatagramSocket(myUdpPort);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return;
        }

        byte[] buf = new byte[BUFSIZE];
        int readBytes = 0;

        while (true) {
            try {
                readBytes = in.read(buf);
            } catch (SocketTimeoutException e) {
                System.out.println("Time limit for order expecting exceeded");
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;
            }

            if (readBytes == -1) {
                System.out.println("Client " + socket.getInetAddress() + " has broken the connection");
                break;
            }
            String line = new String(buf, 0, readBytes);
            System.out.println(line);
            Order order = gson.fromJson(line, Order.class);
            orders.purchase(order);
            Runnable aCheckAwaiting = new ACheckAwaiting();
            ((ACheckAwaiting) aCheckAwaiting).setOrders(orders);
            Thread t1 = new Thread(aCheckAwaiting);
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }

            byte[] sendBuf = new byte[100];
            String sendStr = gson.toJson(order);
            sendBuf = sendStr.getBytes();
            DatagramPacket sendData = new DatagramPacket(sendBuf, sendBuf.length, IPAddress, udpPort);
            try {
                udpSocket.send(sendData);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                break;
            }
            System.out.println("Order has sent to " + IPAddress);
        }
    }
}
