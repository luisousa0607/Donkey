package org.academiadecodigo.bootcamp;


import javazoom.jl.decoder.JavaLayerException;
import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.GameOver.GameOver;
import org.academiadecodigo.bootcamp.ScoreCounter.Score;
import org.academiadecodigo.bootcamp.Sound.Bgm;
import org.academiadecodigo.bootcamp.keyboard.MarioKeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

import java.io.FileNotFoundException;

public class Game {

    private Player player;
    private Vilain vilain;
    private Barrel[] barrels;
    private Ladder[] ladders;
    private Platform[] platforms;
    int barrelCounter = 0;

    private static final int MAX_BARRELS = 10;
    private static final int JUMP_HEIGHT = -20;
    long timeCreation = System.currentTimeMillis();

    private boolean gameOver = false;

    MarioKeyboardHandler handler;



    public Game() throws InterruptedException {



        Field field = new Field();
        this.player = new Player(10, field.getWIDTH() - 280, 3);
        this.handler = new MarioKeyboardHandler(this.player);
        this.vilain = new Vilain(40,40);
        this.barrels = new Barrel[MAX_BARRELS];


        this.platforms = new PlatformFactory().createPlatform();
        this.ladders = new LadderFactory(platforms).createLadders();
    }

    public void start() throws InterruptedException, FileNotFoundException, JavaLayerException {






        Integer counter = 60;
        Rectangle timerGFX = new Rectangle(10, 10, 50, 15);
        timerGFX.draw();
        Text text = new Text((timerGFX.getWidth() / 2) + 3, (timerGFX.getHeight() / 2) + 3, counter.toString());
        text.draw();
        long time = System.currentTimeMillis();
        Score.showScore();
        Bgm.bgm.start();













        while (!GameOver.isIsGameOver()) {



            if (System.currentTimeMillis() - time >= 1000) {
                counter--;
                text.setText(counter.toString());
                text.draw();
                time = System.currentTimeMillis();


                if (counter == 0 /*|| player.getLivesCounter() == 0*/) {

                    gameOver = true;
                }
            }

            createBarrels();


            if (!player.abovePlatform(platforms)) {
                playerFall();
            }

            if (player.getIsJumping()) {
                this.playerJump();
            }

            if (player.hasCollided()) {
                for(int i = 0; i < 20; i++){
                    this.moveBarrels();
                    Thread.sleep(10);
                }
                player.lostLives();
                System.out.println("lost 1 live");
                player.setHasCollided(false);
                player.setWillScore(false);
            } else if (player.shouldScore()) {
                Score.increaseScore(player);
                System.out.println("increasing score");
                player.setWillScore(false);
            }


            this.moveBarrels();
            checkCollision();
            Thread.sleep(10);

        }
    }

    // poderia ficar no player? o método jumpUp, fall
    private void playerJump() throws InterruptedException {
        for (int i = 0; i < 40; i++) {
            checkCollision();
            player.jumpUp();
            checkJumpedOver();
            moveBarrels();
            Thread.sleep(10);
        }
    }

    private void playerFall() throws InterruptedException {
        while (!player.abovePlatform(platforms)) {
            player.fall();
            moveBarrels();
            checkCollision();
            Thread.sleep(10);
        }

        this.player.setJumping(false);
    }

    private void createBarrels() throws InterruptedException {


        if (System.currentTimeMillis() - timeCreation >= 5000) {


            if (barrelCounter < barrels.length)
                barrels[barrelCounter++] = new Barrel();

            timeCreation = System.currentTimeMillis();
        }
    }

    private void checkCollision() throws InterruptedException {

        for (Barrel a : barrels) {
            if (a != null) {
                if (this.player.getBox().collides(a.getBox())) {
                    this.player.setColorRed();
                    player.setHasCollided(true);
                    System.out.println("collided");
                    break;

                }

                if (a.getY() == Field.getHEIGHT()) {
                    a.move(0, -Field.getHEIGHT());
                }
            }
        }


        for (Ladder l : ladders) {
            if (!this.player.getBox().collides(l.getBox())) {
                this.player.setOnLadder(false);
            } else this.player.setOnLadder(true);
        }
    }

    private void moveBarrels() {
        for (Barrel b : this.barrels) {

            if (b != null) {
                if (b.abovePlatform(platforms)) {
                    b.move(0, 1);
                } else {
                    b.move(1, 0);
                }

            }
        }
    }

    private void checkJumpedOver() throws InterruptedException {
        if (!player.isOnLadder()) {
            for (Barrel b : this.barrels) {
                if (b != null) {
                    if (player.getBox().checkJumpOver(b)) {
                        player.setWillScore(true);
                        System.out.println("shouldScore");
                        break;

                    }
                }
            }
        }

    }
}

