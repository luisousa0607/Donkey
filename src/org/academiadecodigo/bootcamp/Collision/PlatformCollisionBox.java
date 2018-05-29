package org.academiadecodigo.bootcamp.Collision;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Line;

import java.awt.*;

public class PlatformCollisionBox {

    private Point[] top;
    private double m;
    private double b;

    public PlatformCollisionBox(int x, int y, int width, int height, double m) {

        this.m = m;
        this.b = y - m*x;
        this.top = new Point[width];
        this.createTopBox(x, y, width);
    }

    public void createBox(int x ,int y ,int width, int height, double m){
        this.m = m;
        this.b = y - m*x;
        createTopBox(x,y,width);
    }

    public void createTopBox(int x, int y, int width) {

        for (int i = 0; i < this.top.length; i++) {

            this.top[i] = new Point(x + i, (int)((x+i)*m + b) );
        }

    }

    public Point[] getTop() {
        return this.top;
    }

    public double getM(){
        return this.m;
    }

    public double getB(){
        return this.b;
    }

}
