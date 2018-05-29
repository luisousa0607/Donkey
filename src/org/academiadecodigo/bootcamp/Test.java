package org.academiadecodigo.bootcamp;


import org.academiadecodigo.bootcamp.lifeCounter.Lives;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {


    public static void main(String[] args) {

        try {
            Game game = new Game();
            game.start();


        } catch (InterruptedException e) {
            System.out.println("This is an Interrupted Exception");
            e.printStackTrace();
        }
    }


}
