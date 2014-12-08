/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author E alse
 */
public class SocketClientHandler implements Runnable {

    private Socket client;
    private ObjectOutputStream outputStream;

    public SocketClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        System.out.println("Thread started with name:" + Thread.currentThread().getName());
    }

    public void sendMessage(String s) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.write(s);
        writer.flush();
    }
    //    comments below are needed for reading response of client ( we dont need this at the moment) 
//     try {
////	readResponse();
//       } catch (IOException e) {
//	 e.printStackTrace();
//       } catch (InterruptedException e) {
//         e.printStackTrace();
//       }
//   public void readResponse() throws IOException, InterruptedException {
//	String userInput;
//	BufferedReader stdIn = new BufferedReader(new InputStreamReader(client.getInputStream()));
//	while ((userInput = stdIn.readLine()) != null) {
//		if(userInput.equals("TIME?")){
//			System.out.println("REQUEST TO SEND TIME RECEIVED. SENDING CURRENT TIME");
//			sendMessage("test2\n");
//			break;
//		}
//		System.out.println(userInput);
//	}
//	}
}
