package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.PlatformCollisionBox;
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

public  class Player implements Movable  {


    private Rectangle mario;
    private Keyboard keyboard;
    private static final int SPEED = 10;
    private boolean isJumping;
    private double m;
    private boolean Collided;
    private CollisionBox box;
    private boolean onLadder;
    private static final int PLAYERWIDTH = 50;
    private boolean willScore;
    private boolean hasCollided;

    public Player(int x, int y, int lives) {

        this.m = 0;
        this.isJumping = false;
        this.onLadder = false;
        this.Collided = false;
        this.mario = new Rectangle(x, y, PLAYERWIDTH, PLAYERWIDTH);
        this.mario.draw();
        this.box = new CollisionBox(x, y, this.mario.getWidth(), this.mario.getHeight());

    }

    public void move(int x, int y) {
        this.mario.translate(x, y + m);
        this.box.setBox(x, y + m);
    }


    public void jumpUp() throws InterruptedException {

        this.move(0, -1);

    }

    public void fall() {

        this.move(0, 1);

    }

    public double getM() {
        return this.m;
    }

    public void setM(double m) {
        this.m = m*10;
    }

    public void setJumping(boolean value) {
        this.isJumping = value;
    }

    public boolean getIsJumping() {
        return this.isJumping;
    }

    public boolean abovePlatform(Platform[] platforms) {


        for (Platform p : platforms) {
            p.createCollisionBox();
            PlatformCollisionBox platform = p.getBox();
            if (this.box.abovePlatform(platform.getTop())) {
                this.setM(( -p.getM()));
                return true;
            }
        }
        return false;
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

    public CollisionBox getBox() { return this.box; }

    public static int getPlayerwidth(){ return PLAYERWIDTH;}

    public void setWillScore(boolean b){
        willScore = b;
    }

    public boolean isScoring (){

        return willScore;
    }

    public void setHasCollided (){
        hasCollided = true;
    }

    public boolean hasCollided(){

        return willScore;
    }

    public void increaseScore(Player player){

    }

}
