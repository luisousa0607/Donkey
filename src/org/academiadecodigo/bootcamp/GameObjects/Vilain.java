package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Collision.CollisionBox;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Vilain extends GameObject {

    private Picture vilain;
    private int x = 40;
    private int y = 40;
    //private int h;
    //private int w;

        public Vilain(int x, int y/*, int h, int w*/) {
            this.x = x;
            this.y = y;
            //this.h = h;
            this.vilain = new Picture(x, y, "resources/DonkeyKong/Francisco.png");
            this.vilain.grow(-15,-15);
            this.vilain.translate(-15,-88);
            this.vilain.draw();
        }

}
