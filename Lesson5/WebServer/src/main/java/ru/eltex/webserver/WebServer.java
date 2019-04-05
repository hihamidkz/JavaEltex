package ru.eltex.webserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class WebServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		
		while (true) {
			Socket client = server.accept();
			System.out.println("Client accepted");
			new Thread(new ServerThread(client)).start();
		}
	}
}
