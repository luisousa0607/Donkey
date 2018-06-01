package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ladder {


    private Picture ladder;
    private int x;
    private int y;
    private int length;
    private static final int LADDER_WIDTH = 20;
    private CollisionBox box;

    public Ladder(int x, int y, int length) {

        this.x = x;
        this.y = y;
        this.length = length;

        this.ladder = new Picture(x+3, (y-12)+length/2, "resources/Accesories/Ladder.png");

        //this.ladder = new Rectangle(this.x, this.y, LADDER_WIDTH, length);

        this.ladder.draw();
        this.box = new CollisionBox(this.x + (LADDER_WIDTH/2), this.y , LADDER_WIDTH, length);
        this.ladder.grow(2,length/2-12);
        translateIMG(x,y);


    }


    public void translateIMG(int var1, int var3) {
        this.x = var1;
        this.y = var3;
        Canvas.getInstance().repaint();

    }


    public void createCollisionBox() {

        this.box = new CollisionBox(x, y, LADDER_WIDTH, length);


    }

    public CollisionBox getBox() {
        return this.box;
    }
}
