package org.academiadecodigo.bootcamp.Collision;

import org.academiadecodigo.bootcamp.GameObjects.Barrel;
import org.academiadecodigo.bootcamp.GameObjects.Ladder;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class LadderCollisionBox implements Collidable {

    private Point[] bottom;
    private Rectangle box;

    public LadderCollisionBox(int x, int y, int width, int height) {

        this.box = new Rectangle(x, y, width, height );
        this.box.draw();

        this.bottom = new Point[2];
        bottom[0] = new Point(x, y + height );
        bottom[1] = new Point(x + width, y + height );
    }

    public int getWidth() {
        return this.box.getWidth();
    }

    public int getHeight() {
        return this.box.getHeight();
    }

    public int getX() {
        return this.box.getX();
    }

    public int getY() {
        return this.box.getY();
    }

}
