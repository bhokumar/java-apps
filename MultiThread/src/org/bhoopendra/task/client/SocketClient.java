package org.bhoopendra.task.client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1", 5500);
		Scanner sc1 = new Scanner(socket.getInputStream());
		System.out.println("Enter A number !");
		int number = sc.nextInt();
		System.out.println("printing number");
		PrintStream printStream = new PrintStream(socket.getOutputStream());
		printStream.print(number);
		int temp = sc1.nextInt();
		System.out.println(temp);
	}

}
