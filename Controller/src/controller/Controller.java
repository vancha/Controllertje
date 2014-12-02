/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author E alse
 */
public class Controller {

    private boolean isPlaying = false;
    private Timer simulatieTimer;
    private Calendar cal;
    ControllerWindow controllerWindow;

    public Controller(ControllerWindow controllerWindow) {
        this.controllerWindow = controllerWindow;
    }

    public void start() {
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

        cal.add(Calendar.SECOND, 1);
        controllerWindow.setTime(cal);

    }
    

}
