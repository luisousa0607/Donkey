package org.academiadecodigo.bootcamp;


import javazoom.jl.decoder.JavaLayerException;

import java.io.FileNotFoundException;

public class Test {


    public static void main(String[] args) {

        try {
            Game game = new Game();
            game.start();


        } catch (InterruptedException e) {
            System.out.println("This is an Interrupted Exception");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }


}
