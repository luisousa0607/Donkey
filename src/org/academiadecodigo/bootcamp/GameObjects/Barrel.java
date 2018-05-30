package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.PlatformCollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.bootcamp.Interface.Scorable;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Movable;

public class Barrel extends GameObject implements Movable, Scorable {

    private static final int BARREL_SIZE = 20;
    private Ellipse barrel;
    private CollisionBox box;
    private int direction;

    public Barrel() {

        this.barrel = new Ellipse(450, 10, BARREL_SIZE, BARREL_SIZE);
        this.box = new CollisionBox(450, 10, BARREL_SIZE, BARREL_SIZE);
        this.barrel.draw();
        this.direction = 0;
    }

    public void move(int x, int y) {

        this.barrel.translate(x * direction, y);
        this.box.setBox(x * direction,y);
    }


    public CollisionBox getBox() {

        return this.box;
    }

    public boolean abovePlatform(Platform[] platforms) {

        for (Platform p : platforms) {
            p.createCollisionBox();
            PlatformCollisionBox platform = p.getBox();
            if (this.getBox().abovePlatform(platform.getTop())) {
                this.setDirection(p.getDirection());
                return false;
            }

        }

        this.setDirection(0);
        return true;

    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getY(){
        return this.barrel.getY();
    }

    @Override
    public void translate(double v, double v1) {

    }
}
