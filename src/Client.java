

import java.net.Socket;

public class Client {  
	  
    public static final String IP = "10.26.60.52";// 
    public static final int PORT = 6666;//  
  
    public static void main(String[] args) {    
        handler();   
    }  
  
    private static void handler(){  
        try {  
            Socket client = new Socket(IP, PORT);   
            new Thread(new ReadHandlerClientThread(client)).start();  
            new Thread(new WriteHandlerClientThread(client)).start();  
        } catch (Exception e) {  
            System.out.println("fail to connect");
        }  
    }  
}    
  
