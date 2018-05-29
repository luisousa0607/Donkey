package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.bootcamp.keyboard.MarioKeyboardHandler;

public class TestGame {

    private TestPlayer player;

    private Barrel[] barrels;
    private Ladder[] ladders;
    private Platform[] platforms;

    private static final int MAX_BARRELS = 1;
    private static final int JUMP_HEIGHT = -20;

    TestKeyboard handler;

    public TestGame() {

        Field field = new Field();
        this.player = new TestPlayer(10, field.getWIDTH() - 80,3);
        this.handler = new TestKeyboard(this.player);

        this.barrels = createBarrels();


        this.platforms = new PlatformFactory().createPlatform();
        this.ladders = new LadderFactory(platforms).createLadders();
    }

    public void start() throws InterruptedException {

        while (true) {

            checkCollision();

            for (Barrel b : this.barrels) {
                b.createCollisionBox();
                b.abovePlatform(platforms);
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
        for (int i = 0; i < 20; i++) {
            checkCollision();
            this.player.jumpUp();
            this.moveBarrels();
            Thread.sleep(10);
        }
    }

    private void playerFall() throws InterruptedException {

        for (int i = 0; i > JUMP_HEIGHT; i--) {
            checkCollision();
            if (this.player.abovePlatform(platforms)) {
                this.player.setJumping(false);
                break;
            }
            this.player.fall();
            this.moveBarrels();
            Thread.sleep(10);
        }

        this.player.setJumping(false);
    }

    private Barrel[] createBarrels() {

        Barrel[] barrels = new Barrel[MAX_BARRELS];

        for (int i = 0; i < barrels.length; i++) {
            barrels[i] = new Barrel();
        }

        return barrels;
    }

    private void checkCollision() {

        for (Barrel a : barrels) {
            if (this.player.getBox().hasCollided(a)) {
                this.player.setColorRed();
            }
            if (a.getY() == Field.getHEIGHT()) {
                a.move(0, -Field.getHEIGHT());
            }
        }

        for (Ladder l : ladders) {
            if (!this.player.getBox().hasCollided(l)) {
                this.player.setOnLadder(false);
            } else {
                this.player.setOnLadder(true);
                System.out.println("ONLADDER");
            }

        }
    }

    private void moveBarrels() {
        for (Barrel b : this.barrels) {

            if (b.getFalling()) {
                b.move(0, 1);
            } else {
                b.move(1, 0);
            }
        }
    }
}
