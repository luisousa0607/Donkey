package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.PlatformCollisionBox;
import org.academiadecodigo.simplegraphics.graphics.Line;


public class Platform {

    private double m;
    private PlatformCollisionBox box;
    private Line line;
    private int direction;
    private int x1;
    private int y1;



    public Platform(int x1, int y1, int x2, int y2) {
        this.x1=x1;
        this.y1=y1;
        this.line = new Line(x1, y1, x2, y2);
        this.m = ((((double) y1) - (double)y2) / ( (double)x1 - (double)x2));
        this.createCollisionBox();
        this.line.draw();

    }

    public void createCollisionBox() {

        this.box = new PlatformCollisionBox(x1, y1, this.line.getWidth(), this.line.getHeight(), this.m);

    }

    public PlatformCollisionBox getBox() {

         this.box.createBox(x1, y1, this.line.getWidth(), this.line.getHeight(), this.m);
         return this.box;
    }

    public void setM(int m) {
        this.m *= m;
    }

    public double getM() {
        return this.m;
    }

    public void setDirection(int direction){
        this.direction = direction;
    }

    public int getDirection(){
        return this.direction;
    }

    public int getX(){
        return this.line.getX();
    }

    public int getY(){
        return this.line.getY();
    }

    public int getWidth(){
        return this.line.getWidth();
    }
}
