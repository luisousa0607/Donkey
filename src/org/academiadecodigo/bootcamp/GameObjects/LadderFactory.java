package org.academiadecodigo.bootcamp.GameObjects;

public class LadderFactory {


    private Platfor[] platforms;

    public LadderFactory(Platform[] platforms) {
        this.platforms = platforms;
    }

    public Ladder[] createLadders() {

        Ladder[] ladders = new Ladder[platforms.length];

        for(int i = 0; i < platforms.length; i++){
            int x = platforms[i].getX() + (int)(platforms[i].getWidth() * (Math.random()));
            int y = platforms[i].getY();
            int height = PlatformFactory.getHeightDifference();
            ladders[i] = new Ladder(x, y, height);
        }

        return ladders;
    }
}
