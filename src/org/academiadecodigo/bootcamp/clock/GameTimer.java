package org.academiadecodigo.bootcamp.clock;

import org.academiadecodigo.bootcamp.GameOver.GameOver;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import java.util.Timer;

public class GameTimer {
    private static int remaining;
    private static Timer timer;
    private Text text;
    private Integer counter = 60;
    //private static Rectangle timerGFX = new Rectangle(10,10,50,15);

    public GameTimer(){
        //timerGFX=new Rectangle(10,10,50,15);
        //timerGFX.setColor(Color.WHITE);
        //timerGFX.fill();
        //text = new Text((timerGFX.getWidth() / 2) + 3, (timerGFX.getHeight() / 2) + 3, counter.toString());
        text = new Text(10,10,"Time Remaining: " + counter.toString());
        text.setColor(Color.WHITE);
        text.draw();
        showTime();

    }

    public void showTime(){
        counter--;
            text.setText("Time Remaining: "+ counter.toString());
            text.draw();
        if (counter == 0) {

            GameOver.youLost();
        }
    }
}



