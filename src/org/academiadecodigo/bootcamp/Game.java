package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.GameOver.GameOver;
import org.academiadecodigo.bootcamp.GameOver.YouWin_GameOver;
import org.academiadecodigo.bootcamp.ScoreCounter.Score;
import org.academiadecodigo.bootcamp.Sound.Bgm;
import org.academiadecodigo.bootcamp.clock.GameTimer;
import org.academiadecodigo.bootcamp.keyboard.MarioKeyboardHandler;

import java.io.FileNotFoundException;

public class Game {

    private Player player;
    private Vilain vilain;
    private Prize prize;
    private Barrel[] barrels;
    private Ladder[] ladders;
    private Platform[] platforms;
    int barrelCounter = 0;

    private static final int MAX_BARRELS = 15;
    private static final int JUMP_HEIGHT = -20;
    long timeCreation = System.currentTimeMillis();


    MarioKeyboardHandler handler;


    public Game() throws InterruptedException {

        Field field = new Field();
        this.vilain = new Vilain();
        this.barrels = new Barrel[MAX_BARRELS];
        this.prize = new Prize();


        this.platforms = new PlatformFactory().createPlatform();
        this.ladders = new LadderFactory(platforms).createLadders();
        this.player = new Player(Field.getPadding(), Field.getHEIGHT() - Player.getPlayerwidth() - 20, 3);
        this.handler = new MarioKeyboardHandler(this.player);
    }

    public void start() throws InterruptedException, FileNotFoundException {

        GameTimer timer = new GameTimer();
        long time = System.currentTimeMillis();
        Score.showScore();
        Bgm.bgm.start();

        while (!GameOver.isItGameOver()) {

            if (System.currentTimeMillis() - time >= 1000) {
                timer.showTime();
                time = System.currentTimeMillis();
            }

            createBarrels();

            if (!player.abovePlatform(platforms) && !player.isOnLadder()) {

                playerFall();
            }

            if (player.getIsJumping()) {

                if (this.player.getDirection() > 0) {
                    this.player.setPicture("resources/Mario/Mario4.png");
                } else {
                    this.player.setPicture("resources/Mario/Mario3.png");
                }

                this.playerJump();
            }

            if (player.hasCollided()) {
                for (int i = 0; i < Barrel.getBarrelSize() + 15; i++) {
                    this.moveBarrels();
                    Thread.sleep(10);
                }
                player.lostLives();
                player.setHasCollided(false);
                player.setWillScore(false);
            } else if (player.shouldScore()) {
                Score.increaseScore(player);
                player.setWillScore(false);
            }

            checkCollision();
            this.moveBarrels();

            this.player.setOnLadder(false);
            checkLadders();
            Thread.sleep(10);

        }
    }

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


        if (System.currentTimeMillis() - timeCreation >= 3000) {

            if (barrelCounter < barrels.length)
                barrels[barrelCounter++] = new Barrel();

            timeCreation = System.currentTimeMillis();
        }
    }

    private void checkCollision() throws InterruptedException {

        for (Barrel a : barrels) {
            if (a != null) {
                if (this.player.getBox().collides(a.getBox())) {
                    player.setHasCollided(true);
                    break;

                }
                if (a.getY() == Field.getHEIGHT() - 50) {
                    a.move(-5, -Field.getHEIGHT());
                }
            }
        }
        if (this.player.getBox().collides(Prize.getBox())) {
            YouWin_GameOver.youWin(this.player);
        }
    }

    private void moveBarrels() throws InterruptedException {
        for (Barrel b : this.barrels) {

            if (b != null) {
                if (b.abovePlatform(platforms)) {
                    b.move(0, 1);
                } else {
                    b.move(1, 0);
                }

            }
        }

        this.checkCollision();
    }

    private void checkLadders() {
        for (Ladder l : ladders) {
            if (this.player.getBox().collides(l.getBox())) {
                this.player.setOnLadder(true);
            }
        }
    }

    private void checkJumpedOver() throws InterruptedException {
        if (!player.isOnLadder()) {
            for (Barrel b : this.barrels) {
                if (b != null) {
                    if (player.getBox().checkJumpOver(b)) {
                        player.setWillScore(true);
                        break;

                    }
                }
            }
        }

    }
}

