package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.PlatformCollisionBox;
import org.academiadecodigo.bootcamp.GameObjects.Field;
import org.academiadecodigo.bootcamp.GameObjects.Platform;
import org.academiadecodigo.bootcamp.ScoreCounter.Score;
import org.academiadecodigo.bootcamp.lifeCounter.Lives;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.bootcamp.Interface.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Movable {

    private Picture mario;
    private static final int SPEED = 7;
    private boolean isJumping;
    private double m;
    private CollisionBox box;
    private boolean onLadder;
    private int direction;
    private static final int PLAYERWIDTH = 25;
    private boolean willScore;
    private boolean hasCollided;
    private Lives life;
    private boolean walking;
    private boolean climbAnim;

    public Player(int x, int y, int lives) {

        this.m = 0;
        this.isJumping = false;
        this.onLadder = false;
        this.mario = new Picture(x, y, "resources/Mario/Mario2.png");
        this.mario.draw();
        this.box = new CollisionBox(x, y, this.mario.getWidth(), this.mario.getHeight());
        this.direction = 1;
        this.life = new Lives(lives);
        this.walking = false;
        this.climbAnim = false;

    }

    public void move(int x, int y) {

        if (this.isOnLadder() && !this.isJumping) {
            this.mario.translate(x, y * SPEED);
            this.box.setBox(x, y * SPEED);
            return;
        }

        if (this.isJumping) {
            if (!Field.canMove(direction, this.getBox().getX() + x)) {
                this.mario.translate(0, y);
                this.box.setBox(0, y);
                return;
            } else {
                this.mario.translate(x, y);
                this.box.setBox(x, y);
                return;
            }
        }

        if (Field.canMove(direction, this.getBox().getX() + x) ) {
            if (m > 0) {

                this.mario.translate(x, -y * direction);
                this.box.setBox(x, -y * direction);
                return;
            } else if (m < 0) {

                this.mario.translate(x, y * direction);
                this.box.setBox(x, y * direction);
                return;
            } else {
                this.mario.translate(x, y);
                this.box.setBox(x, y);
            }
        }
        this.setOnLadder(false);
    }

    public void jumpUp() {
        this.move(direction, -1);
    }

    public void fall() {
        if (isJumping)
            this.move(direction, 1);
        else
            this.move(0, 1);
    }

    public void setM(double m) {
        this.m = m;
    }

    public void setJumping(boolean value) {
        this.isJumping = value;
    }

    public boolean getIsJumping() {
        return this.isJumping;
    }

    public boolean abovePlatform(Platform[] platforms) {

        for (Platform p : platforms) {
            PlatformCollisionBox platform = p.getBox();
            if (this.box.abovePlatform(platform.getTop())) {
                this.setM((-p.getM()));
                return true;
            }
        }
        return false;
    }

    public void setOnLadder(boolean onLadder) {
        this.onLadder = onLadder;
    }

    public boolean isOnLadder() {
        return this.onLadder;
    }

    public int getSpeed() {
        return SPEED;
    }

    public CollisionBox getBox() {
        return this.box;
    }

    public static int getPlayerwidth() {
        return PLAYERWIDTH;
    }

    public void setDirection(int direction) {

        if (direction > 0) {
            if (walking) {
                this.mario.load("resources/Mario/Mario2.png");
                this.walking = false;
            } else {
                this.mario.load("resources/Mario/Mario4.png");
                this.walking = true;
            }
        } else if (walking) {
            this.mario.load("resources/Mario/Mario1.png");
            this.walking = false;
        } else {
            this.mario.load("resources/Mario/Mario3.png");
            this.walking = true;
        }
        this.direction = direction;
    }

    public void setWillScore(boolean b) {
        willScore = b;
    }

    public boolean shouldScore() {
        return willScore;
    }

    public void setHasCollided(boolean b) {
        hasCollided = b;
    }

    public boolean hasCollided() {
        return hasCollided;
    }

    public void lostLives() {
        life.lostLife();
    }

    public int getDirection() {
        return this.direction;
    }

    public void gainedLives() {
        life.gainedLife(true);
    }

    public void setPicture(String picture) {
        mario.load(picture);
    }

    public void climbingAnimation() {
        if (this.climbAnim) {
            this.setPicture("resources/Mario/Mario5.png");
            this.climbAnim = false;
        } else {
            this.setPicture("resources/Mario/Mario6.png");
            this.climbAnim = true;
        }
    }

}
