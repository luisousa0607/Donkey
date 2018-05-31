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

        /*if(isGameOver){

            Rectangle gameOverGFX = new Rectangle(0, 0, 500,500);
            gameOverGFX.setColor(Color.WHITE);
            gameOverGFX.fill();
            Text gameOverText = new Text(255,255,"This Game is over you butter fingers");
            gameOverText.draw();
            Bgm.bgm.stop();
            Bgm.lost.play(true);

        }*/
    }

    public static void youLost () {
        /*Rectangle gameOverGFX = new Rectangle(0, 0, 500, 500);
        gameOverGFX.setColor(Color.WHITE);
        gameOverGFX.fill();
        Text gameOverText = new Text(255, 255, "This Game is over you butter fingers");
        gameOverText.draw();
        Bgm.bgm.stop();
        Bgm.lost.play(true);
        isGameOver = true;*/
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
