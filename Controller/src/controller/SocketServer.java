/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E alse
 */
public class SocketServer {

    private ServerSocket serverSocket;
    private int port;
    private SocketClientHandler clientHandler;
    private List<SocketClientHandler> clientHandlers;

    public SocketServer(int port) {
        this.port = port;
        clientHandlers = new ArrayList();
    }

    public void start() throws IOException {
        System.out.println("Starting the socket server at port:" + port);
        serverSocket = new ServerSocket(port);

        Socket client = null;

        while (true) {
            System.out.println("Waiting for clients...");
            client = serverSocket.accept();
            System.out.println("The following client has connected:" + client.getInetAddress().getCanonicalHostName());
            //A client has connected to this server. Send welcome message

            Thread thread = new Thread(clientHandler = new SocketClientHandler(client));
            clientHandlers.add(new SocketClientHandler(client));
            thread.start();


        }
    }

    public void sendMessage(String message) {
        try {
            clientHandler.sendMessage(message + "\n");
        } catch (IOException ex) {
            System.out.println("kan geen string versturen /" + ex);
        } catch (InterruptedException ex) {
            System.out.println("kan geen string  versturen /" + ex);
        }
    }
}
