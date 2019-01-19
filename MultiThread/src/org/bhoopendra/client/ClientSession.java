package org.bhoopendra.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class ClientSession {

	SelectionKey selectionKey;
	SocketChannel socketChannel;
	ByteBuffer byteBuffer;
	
	public ClientSession(SelectionKey selectionKey, SocketChannel socketChannel) throws IOException {
		super();
		this.selectionKey = selectionKey;
		this.socketChannel = (SocketChannel)socketChannel.configureBlocking(false);
		byteBuffer = ByteBuffer.allocateDirect(64);
		}

	void disconnect(){
		if(selectionKey!=null){
			selectionKey.cancel();
		}
		if(socketChannel==null){
			return;
		}
		try {
			System.out.println("Bye Bye "+(InetSocketAddress)socketChannel.getRemoteAddress());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	void read(){
		try{
			int amount_read=-1;
			amount_read =socketChannel.read((ByteBuffer)byteBuffer.clear());
			if(amount_read==-1){
				disconnect();
			}
			if(amount_read<1){
				return;
			}
			System.out.println("Sending out back "+byteBuffer.position()+" bytes");
			byteBuffer.flip();
			socketChannel.write(byteBuffer);
		}
		catch (Throwable t) {
			disconnect();
			t.printStackTrace();
		}
	}
}
