package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.LadderCollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ladder {


    private Rectangle ladder;
    private int x;
    private int y;
    private int length;
    private static final int LADDER_WIDTH = 20;
    private LadderCollisionBox box;

    public Ladder(int x, int y, int length) {

        this.x = x;
        this.y = y;
        this.length = length;
        this.ladder = new Rectangle(x, y, LADDER_WIDTH, length);
        this.ladder.draw();
        this.box = new LadderCollisionBox(x, y, LADDER_WIDTH, length);

    }


    public void createCollisionBox() {

        this.box = new LadderCollisionBox(x, y, LADDER_WIDTH, length);

    }

    public LadderCollisionBox getBox() {
        return this.box;
    }
}
