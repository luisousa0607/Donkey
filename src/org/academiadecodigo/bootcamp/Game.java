package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.ScoreCounter.Score;
import org.academiadecodigo.bootcamp.keyboard.MarioKeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class Game {

    private Player player;

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

        this.barrels = new Barrel[MAX_BARRELS];


        this.platforms = new PlatformFactory().createPlatform();
        this.ladders = new LadderFactory(platforms).createLadders();
    }

    public void start() throws InterruptedException {
        //(new Thread(new GameTimer())).start();
        Integer counter = 60;
        Rectangle timerGFX = new Rectangle(10, 10, 50, 15);
        timerGFX.draw();
        Text text = new Text((timerGFX.getWidth() / 2) + 3, (timerGFX.getHeight() / 2) + 3, counter.toString());
        text.draw();
        long time = System.currentTimeMillis();
        Score.showScore();


        while (!gameOver) {

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

            checkCollision();

            for (Barrel b : this.barrels) {
                if (b != null) {
                    b.abovePlatform(platforms);

                    b.abovePlatform(platforms);
                }
            }

            if (player.getIsJumping()) {

                this.playerJump();

                this.playerFall();

            }

            this.moveBarrels();
            Thread.sleep(10);

        }


    }

    private void playerJump() throws InterruptedException {
        for (int i = 0; i < 40; i++) {
            checkCollision();
            this.player.jumpUp();
            if(!player.isOnLadder()) {
                for (Barrel b : this.barrels) {
                    if (b != null) {
                        if(player.getBox().checkJumpOver(b)){
                            System.out.println("jumped over and scored");
                            Score.increaseScore(player);
                            break;
                        }
                    }
                }
            }
            this.moveBarrels();
            Thread.sleep(10);
        }
    }

    private void playerFall() throws InterruptedException {

        while (!this.player.abovePlatform(platforms)) {
            this.player.fall();
            this.moveBarrels();
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

    private void checkCollision() {

        for (Barrel a : barrels) {
            if (a != null) {
                if (this.player.getBox().collides(a.getBox())) {
                    this.player.setColorRed();
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
                if (b.getFalling()) {
                    b.move(0, 1);
                } else {
                    b.move(1, 0);
                }
            }
        }
    }
}
