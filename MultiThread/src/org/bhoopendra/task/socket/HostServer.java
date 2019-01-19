package org.bhoopendra.task.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HostServer {

	private void solveQuestion(Socket socket) throws IOException{
		System.out.println("Just Connected to Client : "+socket.getInetAddress());
		DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
		String question = dataInputStream.readUTF();
		System.out.println("client : "+socket.getInetAddress()+" is asking question : "+question);
		System.out.println("server will reply....");
		String answer = "";
		if(question.equals("who is 45th president of us")){
			answer = "Donald Trump";
		}else if(question.equals("indian pm")){
			answer = "Narendra Modi";
		}else if(question.equals("best footballer")){
			answer = "messi";
		}else if(question.equals("best batsman")){
			answer = "Virat kohli";
		}else{
			answer = "server does not know answer of this question";
		}
		DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
		outputStream.writeUTF(answer);
		socket.close();
	}
	public static void main(String[] args) throws IOException {
		QuestionAnswerServerSocket answerServer = new QuestionAnswerServerSocket();
		ServerSocket serverSocket = answerServer.getServerSocket();
		HostServer hostServer = new HostServer();
		Runnable worker = new Runnable() {
			@Override
			public void run() {
				try {
					Socket socket = serverSocket.accept();
					hostServer.solveQuestion(socket);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++){
			executorService.execute(worker);
		}
		

	}

}
