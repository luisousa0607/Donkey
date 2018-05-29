package org.academiadecodigo.bootcamp.ScoreCounter;

//import org.academiadecodigo.bootcamp.Tests_temporary.PlayerTestScore;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.bootcamp.lifeCounter.Lives;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Score {
    private static int score = 0;
    private static Rectangle scoreGFX = new Rectangle(150,10,150,15);
    private static Text scoreText = new Text(scoreGFX.getX()+5,10,"Score: "+ score);


    public static void showScore(){
        scoreGFX.draw();
        scoreText.draw();
    }

    public static void increaseScore(Player player){

        score += 100;
        if (score % 1500==0) {
            //player.gainedLife(true);
        }
        System.out.println("score changed to =" + score);
        scoreText.setText("Score: "+ score);
        showScore();

    }

    public void setScore(int score) {
        this.score = score;
    }

    /*public void checkJumpedOverObject(PlayerTestScore player){
        if(!player.isOnLadder()){

        }

    }*/







}