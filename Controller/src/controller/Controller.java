/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

/**
 *
 * @author E alse
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                // Setting a default port number.
        int portNumber = 9991;
        
        try {
            // initializing the Socket Server
            SocketServer socketServer = new SocketServer(portNumber);
            socketServer.start();
            
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
