package ru.eltex.webserver;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class ServerThread implements Runnable {
	private Socket s;
	private InputStream is;
	private OutputStream os;

	public ServerThread(Socket s) throws IOException {
		this.s = s;
		this.is = s.getInputStream();
		this.os = s.getOutputStream();
	}
	
	@Override
	public void run() {
		try {
			readData();
			writeResponse();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void readData() {
		Scanner in = new Scanner(is);
		while (true) {
			String str = in.nextLine();
			if (str == null || str.trim().length() == 0) {
				break;
			}
			System.out.println(str);
		}
	}
	
	private void writeResponse() throws IOException {
		FileReader fr = null;
		fr = new FileReader("index.html");
		Scanner in = new Scanner(fr);
		
		String file = "";
		while (in.hasNextLine()) {
			file += in.nextLine();
		}
		
		String response = "HTTP/1.1 200 OK\nContent-Length: " + file.length() + "\n\n";
		String result = response + file;

		System.out.println("\n" + result);
		os.write(result.getBytes());
		os.flush();
		os.close();
	}
}
