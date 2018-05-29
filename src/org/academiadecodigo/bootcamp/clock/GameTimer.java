package org.academiadecodigo.bootcamp.clock;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer implements Runnable {
    private static int remaining;
    private static Timer timer;
   // private static String remain = Integer.toString(getRemaining());
    private static Rectangle timerGFX = new Rectangle(10,10,50,15);
    private static Text remainText;

    public static void newClock(int seconds){

        int delay = 3000;
        int period = 1000;
        timer = new Timer();
        remaining = seconds;

        remainText = new Text((timerGFX.getWidth()/2)+2, (timerGFX.getHeight()/2)+3,Integer.toString(getRemaining()));

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
                setInterval();
                showTimer();
            }
        }, delay, period);

    }
    private static final int setInterval() {
        if (remaining == 1)
            timer.cancel();
        return --remaining;
    }

    public static Integer getRemaining()
    {
        return remaining;
    }

    public static void showTimer(){
        remainText.setText(getRemaining().toString());
        //remainText.draw();
    }

    public static void hideTimer(){
    }

    public static void updateTimer() throws InterruptedException {
        hideTimer();
        //Thread.sleep(1000);
        showTimer();

    }


    @Override
    public void run() {

        GameTimer.newClock(20);
        timerGFX.draw();
        GameTimer.showTimer();

        /*while(GameTimer.getRemaining()>0){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(GameTimer.getRemaining());
            try {
                GameTimer.updateTimer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }*/

    }
}



