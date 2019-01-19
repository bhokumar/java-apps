package org.bhoopendra.task.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServer {
	public SocketServer() throws IOException {
		ServerSocket serverSocket = new ServerSocket(5500);
		Socket socket = serverSocket.accept();
		Scanner scanner = new Scanner(socket.getInputStream());
		int number = scanner.nextInt();
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.println(2*number);
	}
	public static void main(String[] args) throws IOException {
		new SocketServer();
	}

}
