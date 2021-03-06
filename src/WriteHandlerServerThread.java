

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class WriteHandlerServerThread implements Runnable{
	 private Socket client;  
	  
	    public WriteHandlerServerThread(Socket client) {  
	        this.client = client;  
	    }  
	  
	    @Override  
	    public void run() {  
	        DataOutputStream dos = null;  
	        BufferedReader br = null;  
	        try{  
	            while(true){  
	                dos = new DataOutputStream(client.getOutputStream());    
	                System.out.print("enter:");    
	                br = new BufferedReader(new InputStreamReader(System.in));  
	                String send = br.readLine(); 
	                dos.writeUTF(send);    
	            }  
	        }catch(Exception e){  
	            e.printStackTrace();  
	        }finally{  
	            try {  
	                if(dos != null){  
	                    dos.close();  
	                }  
	                if(br != null){  
	                    br.close();  
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
