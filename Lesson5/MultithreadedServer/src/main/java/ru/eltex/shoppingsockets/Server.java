package ru.eltex.shoppingsockets;

import java.io.IOException;
import java.net.*;

public class Server {

    static final int UDP_PORT = 19000;
    static final int TCP_PORT = 8080;
    static DatagramSocket udpServerSocket = null;
    static ServerSocket tcpServerSocket = null;

    public static void main(String args[]) {
        try {
            udpServerSocket = new DatagramSocket(UDP_PORT);
            tcpServerSocket = new ServerSocket(TCP_PORT);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            try {
                udpServerSocket.receive(receivePacket);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());

            if (!sentence.equals("Hello")) {
                continue;
            }
            InetAddress IPAddress = receivePacket.getAddress();
            System.out.println("Client " + IPAddress + " has connected");

            int port = receivePacket.getPort();
            String sendStr = String.valueOf(TCP_PORT);
            sendData = sendStr.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            try {
                udpServerSocket.send(sendPacket);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

            Socket socket = null;
            try {
                socket = tcpServerSocket.accept();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                continue;
            }
            Runnable r1 = new ServerThread(socket, IPAddress, port);
            Thread t1 = new Thread(r1);
            t1.start();
        }
    }
}
