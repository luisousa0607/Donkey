package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {


    private Rectangle canvas;
    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    private static final int PADDING = 10;


    public Field() {

        this.canvas = new Rectangle(PADDING, PADDING, HEIGHT, WIDTH);

    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getPadding(){return PADDING;}

    public static int getWIDTH() {
        return WIDTH;
    }

}