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
        this.createTopBox(x, y, width);
    }

    private void createTopBox(int x, int y, int width) {

        this.top = new Point[width];

        for (int i = 0; i < this.top.length; i++) {

            this.top[i] = new Point(x + i, (int)((x+i)*m + b) );
        }



        Line line = new Line(x, y, x + this.top.length, this.top[width - 1].getY());
        line.setColor(Color.RED);
        line.draw();
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
