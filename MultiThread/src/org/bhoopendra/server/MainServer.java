package org.bhoopendra.server;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.axway.client.ClientSession;

public class MainServer {

	public static void main(String[] args) throws Throwable {
		new MainServer(new InetSocketAddress("localhost", 1337));
	}

	ServerSocketChannel serverChannel;
	Selector selector;

	public MainServer(InetSocketAddress listenAddress) throws Throwable {
		serverChannel = ServerSocketChannel.open();
		serverChannel.configureBlocking(false);
		serverChannel.register(selector = Selector.open(), SelectionKey.OP_ACCEPT);
		serverChannel.bind(listenAddress);
		Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				try {
					loop();
				} catch (Throwable e) {
					e.printStackTrace();
				}
				
			}
		},0,500,TimeUnit.MICROSECONDS);
			
	}

	static HashMap<SelectionKey, ClientSession> clientMap = new HashMap<>();
	void loop() throws Throwable {
		selector.selectNow();
		for(SelectionKey key : selector.selectedKeys()){
			try{
			if(!key.isValid()) continue;
			if(key.isAcceptable()){
				SocketChannel acceptedChannel = serverChannel.accept();
				if(acceptedChannel == null){
				continue;
				}
				acceptedChannel.configureBlocking(false);
				SelectionKey readKey = acceptedChannel.register(selector, SelectionKey.OP_READ);
				clientMap.put(readKey, new ClientSession(readKey, acceptedChannel));
				System.out.println("New Client IP : "+acceptedChannel.getRemoteAddress()+", Total Clients"+MainServer.clientMap.size());
			}
			if(key.isReadable()){
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		}
		selector.keys().clear();
	}
}
