package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Ladder implements Collidable {


    private Rectangle ladder;
    private int x;
    private int y;
    private int lenght;
    private static final int LADDER_WIDTH = 50;
    private CollisionBox box;

    public Ladder(int x, int y, int length) {

        this.x = x;
        this.y = y;
        this.lenght = length;
        this.ladder = new Rectangle(x, y, LADDER_WIDTH, length);
        this.ladder.draw();
        this.box = new CollisionBox(x,y,LADDER_WIDTH,length);

    }

    @Override
    public void createCollisionBox() {

        this.box = new CollisionBox(x,y,LADDER_WIDTH,lenght);

    }

    @Override
    public CollisionBox getBox() {
        return this.box;
    }
}
