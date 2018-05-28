package org.academiadecodigo.bootcamp.clock;

public class clockTester {

    public static void main(String[] args) throws InterruptedException {
        GameTimer.newClock(20);
        while(GameTimer.getRemaining()>0){
            Thread.sleep(1000);
            System.out.println(GameTimer.getRemaining());
       }
    }
}
