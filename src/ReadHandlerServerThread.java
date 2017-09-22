

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReadHandlerServerThread implements Runnable{
	private Socket client;  
	  
    public ReadHandlerServerThread(Socket client) {  
        this.client = client;  
    }  
  
    @Override  
    public void run() {  
        DataInputStream dis = null;  
        try{  
            while(true){    
                dis = new DataInputStream(client.getInputStream());  
                String reciver = dis.readUTF();  
                System.out.print("\nclent:" + reciver+"\nenter:");   
            }  
        }catch(Exception e){  
            e.printStackTrace();  
        }finally{  
            try {  
                if(dis != null){  
                    dis.close();  
                }  
                if(client != null){  
                    client = null;  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
