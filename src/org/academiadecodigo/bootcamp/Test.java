package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.Tests.TestGame;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Test {


    public static void main(String[] args) {


       Picture pic = new Picture(5, 5);

        pic.load("resources/barrel.jpg");

        pic.draw();

        TestGame game = new TestGame();

        try {

            game.start();

        } catch (InterruptedException e) {
            System.out.println("This is an Interrupted Exception");
            e.printStackTrace();
        }
    }


}
