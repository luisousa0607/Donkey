package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ladder implements Collidable {


    private Picture ladder;
    private int x;
    private int y;
    private int length;
    private static final int LADDER_WIDTH = 30;
    private CollisionBox box;

    public Ladder(int x, int y, int length) {

        this.x = x;
        this.y = y;
        this.length = length;
        this.ladder = new Picture(x, y, "resources/Accesories/Ladder.png");
        this.ladder.draw();
        this.box = new CollisionBox(x,y,LADDER_WIDTH,length);

    }

    @Override
    public void createCollisionBox() {

        this.box = new CollisionBox(x,y,LADDER_WIDTH, length);

    }

    @Override
    public CollisionBox getBox() {
        return this.box;
    }
}
