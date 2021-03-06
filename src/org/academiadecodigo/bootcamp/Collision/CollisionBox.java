package org.academiadecodigo.bootcamp.Collision;

import org.academiadecodigo.bootcamp.GameObjects.*;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;


public class CollisionBox implements Collidable {

    private Rectangle box;
    private Point[] bottom;
    private int minBufferScore = 0;
    private int maxBufferScore = 20;


    public CollisionBox(int x, int y, int width, int height) {

        this.box = new Rectangle(x, y, width, height);
        this.bottom = new Point[2];
        bottom[0] = new Point(x, y + height);
        bottom[1] = new Point(x + width, y + height);
    }

    public void setBox(double x, double y) {

        this.box.translate(x, y);

        bottom[0].setPosition((int) x, (int) y);
        bottom[1].setPosition((int) x, (int) y);

    }


    public boolean collides(Collidable otherBox) {

        if (this.getX() >= otherBox.getX() && this.getX() <= otherBox.getX() + otherBox.getWidth()
                && this.getY() >= otherBox.getY() && this.getY() <= otherBox.getY() + otherBox.getHeight()) {
            return true;
        }

        if (this.getX() + this.getWidth() >= otherBox.getX() && this.getX() + this.getWidth() <= otherBox.getX() + otherBox.getWidth()
                && this.getY() >= otherBox.getY() && this.getY() <= otherBox.getY() + otherBox.getHeight()) {
            return true;
        }

        if (this.getX() >= otherBox.getX() && this.getX() <= otherBox.getX() + otherBox.getWidth()
                && this.getY() + this.getHeight() >= otherBox.getY() && this.getY() + this.getHeight() <= otherBox.getY() + otherBox.getHeight()) {
            return true;
        }

        return (this.getX() + this.getWidth() >= otherBox.getX() && this.getX() + this.getWidth() <= otherBox.getX() + otherBox.getWidth()
                && this.getY() + this.getHeight() >= otherBox.getY() && this.getY() + this.getHeight() <= otherBox.getY() + otherBox.getHeight());

    }

    public boolean abovePlatform(Point[] platform) {
        for (Point a : bottom) {
            for (Point b : platform) {
                if (a.compare(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Rectangle getBox() {
        return this.box;
    }

    public int getWidth() {
        return this.box.getWidth();
    }

    public int getHeight() {
        return this.box.getHeight();
    }

    public int getX() {
        return this.box.getX();
    }

    public int getY() {
        return this.box.getY();
    }

    public boolean checkJumpOver(Barrel object) {

        for (int i = 0; i < bottom.length; i++) {

            if (bottom[i].getX() > object.getBox().getX()
                    &&
                    bottom[i].getX() < object.getBox().getX() + object.getBox().getWidth()) {

                if (bottom[i].getY() < object.getBox().getY() - minBufferScore
                        &&
                        bottom[i].getY() > object.getBox().getY() - maxBufferScore) {
                    return true;
                }
            }
        }
        return false;
    }

}
