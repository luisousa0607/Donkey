package org.academiadecodigo.bootcamp.clock;

import org.academiadecodigo.bootcamp.GameObjects.Field;
import org.academiadecodigo.bootcamp.GameOver.GameOver;
import org.academiadecodigo.bootcamp.Sound.Bgm;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameTimer {
    private Text text;
    private Integer counter = 60;

    public GameTimer(){
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
            GameOver.setGameOver(true);

            Rectangle youWinGFX = new Rectangle(0, 0, 100,25);
            youWinGFX.translate(Field.getWIDTH()/2 - youWinGFX.getWidth()/2,
                    Field.getHEIGHT()/2 - youWinGFX.getHeight()/2);
            youWinGFX.setColor(Color.YELLOW);
            youWinGFX.fill();
            Text gameOverText = new Text(0,0,"TIME'S UP");

            gameOverText.translate(
                    Field.getWIDTH() / 2 - gameOverText.getWidth() / 2,
                    Field.getHEIGHT() / 2 - gameOverText.getHeight() / 2
            );

            Bgm.bgm.stop();
            Bgm.lost.play(true);

            gameOverText.draw();

        }

    }
}



