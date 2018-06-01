package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Field {


    private Rectangle canvas;
    private static final int HEIGHT = 750;
    private static final int WIDTH = 900;
    private static final int PADDING = 10;


    public Field() {

        this.canvas = new Rectangle(PADDING, PADDING, WIDTH, HEIGHT);

        canvas.setColor(Color.BLACK);
        canvas.draw();
        canvas.fill();
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static int getPadding() {
        return PADDING;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static boolean canMove(int direction, int x) {

        switch (direction) {
            case 1:
                return x + Player.getPlayerwidth() < WIDTH;

            default:
                return x > PADDING;
        }

    }

}