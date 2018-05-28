package org.academiadecodigo.bootcamp.clock;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
    private static int remaining;
    private static Timer timer;


    public static void newClock(int seconds){

        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        remaining = seconds;

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();

            }
        }, delay, period);

    }
    private static final int setInterval() {
        if (remaining == 1)
            timer.cancel();
        return --remaining;
    }

    public static int getRemaining(){
        return remaining;
    }
}
