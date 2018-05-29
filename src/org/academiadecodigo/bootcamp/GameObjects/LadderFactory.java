package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Collision.PlatformCollisionBox;
import org.academiadecodigo.bootcamp.Collision.Point;

public class LadderFactory {


    private Platform[] platforms;

    public LadderFactory(Platform[] platforms) {
        this.platforms = platforms;
    }

    public Ladder[] createLadders() {

        Ladder[] ladders = new Ladder[platforms.length-1];

        for(int i = 0; i < platforms.length-1; i++){
            int x = platforms[i].getX() + (int)(platforms[i].getWidth() * (Math.random()));
            int y = (int)((x * platforms[i+1].getBox().getM()) + platforms[i+1].getBox().getB());
            int height = calcHeightDifference(platforms[i], platforms[i+1], x);
            ladders[i] = new Ladder(x, y, height);

        }

        return ladders;
    }

    private int calcHeightDifference(Platform a, Platform b, int x){

        Point[] boxA = a.getBox().getTop();
        Point[] boxB = b.getBox().getTop();

        int aY = 0;
        int bY = 0;

        for(int i = 0; i < boxA.length; i++){
            if(boxA[i].getX() == x){
                aY = boxA[i].getY();
            }
        }

        for( Point point : boxB){
            if(point.getX() == x){
                bY = point.getY();
            }
        }

        System.out.println("A Y: " +  aY + " B Y: " + bY);



        return aY - bY;

    }

   // ((x+i)*m + b)
}
