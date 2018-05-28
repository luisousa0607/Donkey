package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player implements Movable {


    private Rectangle mario;
    private Keyboard keyboard;
    private static final int SPEED = 10;
    private boolean isJumping;
    private int m;
    private boolean Collided;
    private CollisionBox box;
    private boolean onLadder;

    public Player(int x, int y) {

        this.m = 0;
        this.isJumping = false;
        this.onLadder = false;
        this.Collided = false;
        this.mario = new Rectangle(x, y, 50, 50);
        this.mario.draw();
        this.box = new CollisionBox(x, y, this.mario.getWidth(), this.mario.getHeight());

    }

    public void move(int x, int y) {
        this.mario.translate(x, y);
    }


    public void jumpUp() throws InterruptedException {

        this.move(0, -1);

    }

    public void fall() {

        this.move(0, 1);

    }

    public int getM() {
        return this.m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setJumping(boolean value) {
        this.isJumping = value;
    }

    public boolean getIsJumping() {
        return this.isJumping;
    }

    public boolean abovePlatform(Platform[] platforms) {

        this.createCollisionBox();

        for (Platform p : platforms) {
            p.createCollisionBox();
            PlatformCollisionBox platform = p.getBox();
            if (this.box.collides(this.box.getBottom(), platform.getTop())) {
                this.setM((int) p.getM());
                return true;
            }
        }
        return false;
    }


    public void createCollisionBox() {

        this.box = new CollisionBox(this.mario.getX(), this.mario.getY(), this.mario.getWidth(), this.mario.getHeight());
    }

    public void setColorRed() {

        this.mario.setColor(Color.RED);
        this.mario.fill();
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

    public CollisionBox getBox(){
        return this.box;
    }


}
