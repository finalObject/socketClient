

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadHandlerClientThread implements Runnable {
	private Socket client;

	public ReadHandlerClientThread(Socket client) {
		this.client = client;
	}

	@Override
	public void run() {
		DataInputStream dis = null;
		try {
			while (true) {
				dis = new DataInputStream(client.getInputStream());
				String receive = dis.readUTF();
				System.out.print("\nserver:" + receive+"\nenter:");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (client != null) {
					client = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
