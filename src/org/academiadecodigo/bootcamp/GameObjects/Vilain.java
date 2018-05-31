package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Vilain extends GameObject {

    private Picture vilain;
    private int x = 40;
    private int y = 30;
    private static int heigth;
    //private int h;
    //private int w;

        public Vilain() {
            this.vilain = new Picture(x, y, "resources/DonkeyKong/DonkeyKong1.png");
            this.vilain.draw();
            this.heigth = vilain.getHeight()+15;
        }

        public static int getHeight(){
            return heigth;
        }
}
