package org.academiadecodigo.bootcamp.GameObjects;


import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Barrel extends GameObject implements Movable, Collidable {

    private static final int BARREL_RADIUS = 15;
    private static final int BARREL_SIZE = 20;
    private Ellipse barrel;
    private CollisionBox box;
    private boolean isFalling;
    private int direction;

    public Barrel() {
        this.barrel = new Ellipse(50, 100, BARREL_SIZE, BARREL_SIZE);
        this.box = new CollisionBox(50, 400, BARREL_RADIUS, BARREL_RADIUS);
        this.barrel.draw();
        this.isFalling = true;
        this.direction = 0;
    }

    public void move(int x, int y) {

        this.barrel.translate(x * direction, y);
    }

    public void createCollisionBox() {

        this.box = new CollisionBox(this.barrel.getX(), this.barrel.getY(), this.barrel.getWidth(), this.barrel.getHeight());

    }

    public CollisionBox getBox() {

        return this.box;
    }

    public void abovePlatform(Platform[] platforms) {

        this.createCollisionBox();

        for (Platform p : platforms) {
            p.createCollisionBox();
            PlatformCollisionBox platform = p.getBox();
            if (this.getBox().collides(this.box.getBottom(), platform.getTop())) {
                this.isFalling = false;
                this.setDirection(p.getDirection());
                return;
            }

        }

        this.setDirection(0);
        this.isFalling = true;

    }

    public boolean getFalling() {
        return this.isFalling;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getY(){
        return this.barrel.getY();
    }

}
