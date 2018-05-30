package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Prize extends GameObject implements Collidable {

    private Rectangle prize;
    private int x = 250;
    private int y = 40;
    private int h;
    private int w;
    private CollisionBox box;

    public Prize(int x, int y, int h, int w) {
        this.x = x;
        this.y = y;
        this.h = h;
        this.prize = new Rectangle(x, y, h, w);
        this.prize.draw();
        this.box = new CollisionBox(x,y,h,w);

    }

    @Override
    public void createCollisionBox() {

        this.box = new CollisionBox(x,y,h, w);

    }
    @Override
    public CollisionBox getBox() {
        return this.box;
    }

}
