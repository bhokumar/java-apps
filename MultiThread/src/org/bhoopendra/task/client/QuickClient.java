package org.bhoopendra.task.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuickClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 1337);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(55);
		outputStream.write(56);
		outputStream.write(57);
		outputStream.write(58);
		outputStream.write(59);
		outputStream.write(60);
		outputStream.write(61);
		outputStream.write(62);
		outputStream.flush();
		InputStream in = socket.getInputStream();
		int read = -1;
		while((read = in.read() )!=-1){
			System.out.println(read);
		}
	}

}
