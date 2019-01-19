package org.bhoopendra.task.socket;

import java.io.IOException;
import java.net.ServerSocket;

public class QuestionAnswerServerSocket {
	private ServerSocket serverSocket;

	public ServerSocket getServerSocket() {
		return serverSocket;
	}

	public QuestionAnswerServerSocket() throws IOException {
		serverSocket = new ServerSocket(5500);
	}
}
