package ru.eltex.shoppingsockets;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.eltex.shoppingcustomer.*;
import ru.eltex.shoppingitems.*;
import ru.eltex.shoppingprocessing.*;
import ru.eltex.shoppingserializing.ShoppingCartTypeAdapter;

import java.io.IOException;
import java.io.OutputStream;
import java.net.*;
import java.util.Date;

public class Client {
    static final int BUF_SIZE = 1024;
    static final int UDP_PORT = 19000;
    static final int DEMO_TIMEOUT = 10000;
    static int tcpPort;
    static GsonBuilder builder = new GsonBuilder();
    static Gson gson;
    static String hostname;

    public static void main(String args[]) throws IOException, InterruptedException {
        DrinkType type = null;
        if (args[1].equals("coffee")) {
            type = DrinkType.Coffee;
        } else if (args[1].equals("tea")) {
            type = DrinkType.Tea;
        } else {
            System.out.println("Unknown argument " + args[1]);
            System.exit(1);
        }

        if (args.length < 3) {
            hostname = "localhost";
        } else {
            hostname = args[2];
        }

        builder.registerTypeAdapter(ShoppingCart.class, new ShoppingCartTypeAdapter());
        gson = builder.create();

        int count = Integer.parseInt(args[0]);

        Credentials data = new Credentials("Firstname", "Lastname", "No", "mail@mail.ru");
        Orders<Order> orders = new Orders<>();

        Runnable r1 = new Generator(count, type, data, orders);
        Thread t1 = new Thread(r1);
        t1.start();

        final int TIMEOUT = 60000;
        DatagramSocket clientSocket = new DatagramSocket();
        clientSocket.setSoTimeout(TIMEOUT);

        InetAddress IPAddress = InetAddress.getByName(hostname);
        byte[] sendData = new byte[BUF_SIZE];
        byte[] receiveData = new byte[BUF_SIZE];
        String sentence = "Hello";
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, UDP_PORT);
        clientSocket.send(sendPacket);

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        try {
            clientSocket.receive(receivePacket);
        } catch (SocketTimeoutException e) {
            System.out.println("Server response timed out");
            System.exit(2);
        }
        String recvStr = new String(receivePacket.getData(), 0, receivePacket.getLength());
        tcpPort = Integer.parseInt(recvStr);
        InetAddress serverAddress = receivePacket.getAddress();
        Thread.sleep(1000);

        OutputStream out = null;

        Socket socket = null;
        try {
            socket = new Socket(serverAddress, tcpPort);
            out = socket.getOutputStream();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(3);
        }

        while (true) {
            Order order = ((Generator) r1).getOrder();
            String line = gson.toJson(order);

            out.write(line.getBytes());
            out.flush();

            DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);

            try {
                clientSocket.receive(recvPacket);
            } catch (SocketTimeoutException e) {
                System.out.println("Time limit for order status exceeded");
                break;
            }

            String recvString = new String(recvPacket.getData(), 0, recvPacket.getLength());
            Order newOrder = gson.fromJson(recvString, Order.class);
            System.out.println("Order processed at " + new Date());
            newOrder.showOrder();

            Thread.sleep(DEMO_TIMEOUT);
        }
        clientSocket.close();
        socket.close();
    }
}
