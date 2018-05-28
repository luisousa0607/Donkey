package org.academiadecodigo.bootcamp.Collision;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public int getY(){
        return (int)this.y;
    }

    public int getX(){
        return (int)this.x;
    }

    public boolean compare(Point a){
        return this.x == a.getX() && this.y == a.getY();
    }

}
