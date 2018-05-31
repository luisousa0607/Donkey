package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.LadderCollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ladder {


    private Picture ladder;
    private int x;
    private int y;
    private int length;
    private static final int LADDER_WIDTH = 20;
    private LadderCollisionBox box;

    public Ladder(int x, int y, int length) {

        this.x = x;
        this.y = y;
        this.length = length;

        this.ladder = new Picture(x+3, (y-12)+length/2, "resources/Accesories/Ladder.png");

        //this.ladder = new Rectangle(this.x, this.y, LADDER_WIDTH, length);

        this.ladder.draw();
        this.box = new LadderCollisionBox(this.x, this.y, LADDER_WIDTH, length);
        this.ladder.grow(2,length/2-12);
        translateIMG(x,y);


        //this.translateIMG(x,y);
        //this.ladder.draw();

    }


    public void translateIMG(int var1, int var3) {
        this.x = var1;
        this.y = var3;
        Canvas.getInstance().repaint();

    }


    public void createCollisionBox() {

        this.box = new LadderCollisionBox(x, y, LADDER_WIDTH, length);

    }

    public LadderCollisionBox getBox() {
        return this.box;
    }
}
