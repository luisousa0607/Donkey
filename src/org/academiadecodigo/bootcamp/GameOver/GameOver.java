package org.academiadecodigo.bootcamp.GameOver;

import org.academiadecodigo.bootcamp.GameObjects.Field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class GameOver {

    private static boolean isGameOver = false;


    public static boolean isGameOver() {
        return isGameOver;
    }

    public static void setGameOver(boolean gameOver) {
        isGameOver = gameOver;

        if(isGameOver){
            Rectangle gameOverGFX = new Rectangle(10, 10, 500,500);
            gameOverGFX.setColor(Color.WHITE);
            gameOverGFX.fill();
            //gameOverGFX.draw();
            Text gameOverText = new Text(255,255,"This Game is over you butter fingers");
            gameOverText.draw();

        }
    }


}
