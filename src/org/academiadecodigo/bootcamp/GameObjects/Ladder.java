package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.LadderCollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
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
        this.y = (y - 5) ;
        this.length = length;

        this.ladder = new Picture(x, y, "resources/Accesories/Ladder.png");

        //this.ladder = new Rectangle(this.x, this.y, LADDER_WIDTH, length);

        this.ladder.draw();
        this.box = new LadderCollisionBox(this.x, this.y, LADDER_WIDTH, length);

    }


    public void createCollisionBox() {

        this.box = new LadderCollisionBox(x, y, LADDER_WIDTH, length);

    }

    public LadderCollisionBox getBox() {
        return this.box;
    }
}
