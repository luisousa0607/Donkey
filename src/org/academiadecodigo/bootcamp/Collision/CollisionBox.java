package org.academiadecodigo.bootcamp.Collision;

import org.academiadecodigo.bootcamp.GameObjects.*;


public class CollisionBox {
    private Point[] top;
    private Point[] left;
    private Point[] right;
    private Point[] bottom;

    public CollisionBox(int x, int y, int width, int height) {

        this.createTopBox(x, y, width);
        this.createLeftBox(x, y, height);
        this.createBottomBox(x, y, width, height);
        this.createRightBox(x, y, width, height);
    }

    private void createTopBox(int x, int y, int width) {

        this.top = new Point[width];

        for (int i = 0; i < this.top.length; i++) {
            this.top[i] = new Point(x + i, y);
        }
    }

    private void createBottomBox(int x, int y, int width, int height) {

        this.bottom = new Point[width];

        for (int i = 0; i < this.bottom.length; i++) {
            this.bottom[i] = new Point(x + i, y + height);
        }
    }

    private void createLeftBox(int x, int y, int height) {

        this.left = new Point[height];

        for (int i = 0; i < this.left.length; i++) {
            this.left[i] = new Point(x, y + i);
        }
    }

    private void createRightBox(int x, int y, int width, int height) {

        this.right = new Point[height];

        for (int i = 0; i < this.right.length; i++) {
            this.right[i] = new Point(x + width, y + i);
        }
    }

    public Point[] getTop() {
        return this.top;
    }

    public Point[] getLeft() {
        return this.left;
    }

    public Point[] getBottom() {
        return this.bottom;
    }

    public Point[] getRight() {
        return this.right;
    }

    public boolean hasCollided(Collidable e) {

        e.createCollisionBox();

        CollisionBox gameObjectBox = e.getBox();

        if (collides(this.getRight(), gameObjectBox.getLeft()) ||
                collides(this.getTop(), gameObjectBox.getBottom()) ||
                collides(this.getLeft(), gameObjectBox.getRight()) ||
                collides(this.getBottom(), gameObjectBox.getTop())) {
            return true;
        }

        return false;
    }

    public boolean collides(Point[] l1, Point[] l2) {
        for (Point a : l1) {
            for (Point b : l2) {
                if (a.compare(b)) {
                    return true;
                }
            }
        }
        return false;
    }

}
