

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static final int PORT = 6666;

	public static void main(String[] args) {
		Server server = new Server();
		server.init();
	}

	public void init() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			serverSocket.getInetAddress();
			System.out.println("server ip:"+InetAddress.getLocalHost().getHostAddress());
			while (true) {
				Socket client = serverSocket.accept();
				System.out.println("client ip:"+client.getInetAddress());
				new Thread(new ReadHandlerServerThread(client)).start();
				new Thread(new WriteHandlerServerThread(client)).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}



