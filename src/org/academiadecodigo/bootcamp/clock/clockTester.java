package org.academiadecodigo.bootcamp.clock;

import org.academiadecodigo.bootcamp.Game;

public class clockTester {

    public static void main(String[] args) throws InterruptedException {

        (new Thread(new GameTimer())).start();



    }
}
