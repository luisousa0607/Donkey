package org.academiadecodigo.bootcamp.GameOver;

import org.academiadecodigo.bootcamp.GameObjects.Field;
import org.academiadecodigo.bootcamp.Sound.Bgm;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameOver {

    private static boolean isGameOver = false;

    public static void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public static void youLost () {
        isGameOver = true;

        Rectangle youWinGFX = new Rectangle(0, 0, 100,25);

        youWinGFX.translate(Field.getWIDTH()/2 - youWinGFX.getWidth()/2,
                    Field.getHEIGHT()/2 - youWinGFX.getHeight()/2);

        youWinGFX.setColor(Color.YELLOW);
        youWinGFX.fill();
        Text gameOverText = new Text(0,0,"YOU LOST");

        gameOverText.translate(
                    Field.getWIDTH() / 2 - gameOverText.getWidth() / 2,
                    Field.getHEIGHT() / 2 - gameOverText.getHeight() / 2
        );

         Bgm.bgm.stop();
         Bgm.lost.play(true);

        gameOverText.draw();
    }

   public static boolean isItGameOver() {
        return isGameOver;
    }
}
