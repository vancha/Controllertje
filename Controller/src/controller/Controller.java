/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author E alse
 */
public class Controller {

    private boolean isPlaying = false;
    private Timer simulatieTimer;
    private Calendar cal;
    private ControllerWindow controllerWindow;
    private SocketServer socketServer;
    private int i = 0;
    private List<Container> containers;

    public Controller(ControllerWindow controllerWindow) {
        this.controllerWindow = controllerWindow;

        // Setting a default port number.
        int portNumber = 9991;


        // initializing the Socket Server
        socketServer = new SocketServer(portNumber);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socketServer.start();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.start();


    }

    public void start() {
        
        containers = controllerWindow.getContainerList();
        if (!isPlaying) {
            cal = Calendar.getInstance();
            cal.setTime(controllerWindow.getTime());
            isPlaying = true;
        }


        this.simulatieTimer = new Timer();
        this.simulatieTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                timerExecuter();
            }
        }, 0, 100);

    }

    // voert onderstaande methode iedere seconde uit (om aan te passen kijk bij start())
    public void timerExecuter() {

        if (i < 1) {

                socketServer.sendMessage("test");
//                socketServer.sendMessage("CONTAINER::");
//                socketServer.sendObject(containers.get(i));
            

            i++;
        }



        cal.add(Calendar.SECOND, 1);
        controllerWindow.setTime(cal);

    }
}
