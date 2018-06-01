package org.academiadecodigo.bootcamp.lifeCounter;


import org.academiadecodigo.bootcamp.GameOver.GameOver;
import org.academiadecodigo.bootcamp.Sound.Bgm;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public  class Lives {

    private int lives;
    private Text livesText;

    public Lives(int lives) {
        this.lives=lives;
        getLives();
    }

    public void getLives() {
        livesText = new Text(403,10,"Lives: "+ lives);
        livesText.setColor(Color.WHITE);
        livesText.draw();
    }

    public void lostLife() {

            this.lives--;
            livesText.setText("Lives: "+this.lives);
            livesText.draw();
        Bgm.loseLife.play(true);

        if (lives == 0){
            GameOver.youLost();
        }
    }

    public void gainedLife(boolean gainedLife) {
            this.lives++;
            livesText.setText("Lives: "+this.lives);
            livesText.draw();
    }

}
