package org.academiadecodigo.bootcamp.lifeCounter;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public  class Lives {

    private int lives;
    private boolean lostLife = false;
    private boolean gainedLife = false;
    private Text livesText;

    public Lives(int lives) {
        this.lives=lives;
        this.lostLife = false;
        this.gainedLife = false;
    }

    public void getLives() {
        Rectangle livesGFX = new Rectangle(390,10,65,15);
        livesGFX.draw();
        livesText = new Text((livesGFX.getX()-20)+(livesGFX.getWidth()/2),10,"Lives: "+Integer.toString(this.lives));
        livesText.draw();
    }

    public void lostLife(boolean lostLife) {
        this.lostLife = lostLife;

        if(lostLife == true){
            this.lives--;
            livesText.setText("Lives: "+Integer.toString(this.lives));
            lostLife(false);
        }
    }

    public void gainedLife(boolean gainedLife) {
        this.gainedLife= gainedLife;

        if(gainedLife == true){
            this.lives++;
            livesText.setText("Lives: "+Integer.toString(this.lives));
            gainedLife(false);
        }
    }

    public int getLivesCounter(){
        return lives;

    }
}
