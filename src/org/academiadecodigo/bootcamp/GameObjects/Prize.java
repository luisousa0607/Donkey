package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.bootcamp.Interface.Collidable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Prize extends GameObject  {

    private static Picture prize;
    private int x;
    private int y;
    private int h;
    private int w;
    private static CollisionBox box;

    public Prize() {
        this.x = Field.getWIDTH()/2;
        this.y = Field.getPadding()+ 30;
        this.prize = new Picture (Field.getWIDTH()/2, Field.getPadding()+ 30, "resources/Accesories/beer.png");
        this.h = prize.getHeight();
        this.w = prize.getWidth();

        this.prize.draw();
        this.box = new CollisionBox(x,y,h,w);

    }

    public static CollisionBox getBox(){
        return box;
    }

    public static void delete(){
        prize.delete();
    }

}
