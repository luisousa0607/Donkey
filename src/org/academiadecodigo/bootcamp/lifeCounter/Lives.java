package org.academiadecodigo.bootcamp.lifeCounter;

public abstract class Lives {

    private int lives;
    private boolean lostLife = false;
    private boolean gainedLife = false;

    public Lives(int lives) {
        this.lives=lives;
        this.lostLife = false;
        this.gainedLife = false;
    }
}
