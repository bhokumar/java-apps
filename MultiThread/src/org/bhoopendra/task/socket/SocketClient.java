package org.bhoopendra.task.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Scanner sc = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1", 5500);
		System.out.println("Connected to server : "+socket.getInetAddress());
		DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
		System.out.println("Enter a question to Server");
		dataOutputStream.writeUTF(sc.nextLine());
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		System.out.println("Server replies : "+dataInputStream.readUTF());
		socket.close();
		sc.close();
	}
}
