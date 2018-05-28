package org.academiadecodigo.bootcamp.GameObjects;

public class PlatformFactory {

    private static final int MAX_PLATFORMS = 5;
    private int playerWidth = 50;
    private int jumpHeight = playerWidth -10;
    private static int platformHeightDifference;
    private int playerHeight = playerWidth;

    public Platform[] createPlatform() {


        this.platformHeightDifference = (Field.getHEIGHT()-playerHeight - Field.getPadding() - MAX_PLATFORMS*(jumpHeight))/
                (MAX_PLATFORMS-1);

        Platform[] platforms = new Platform[MAX_PLATFORMS];

        for (int i = 0; i < platforms.length-1 ; i++) {

            if (i % 2 == 0) {
               platforms[i] = new Platform(
                       Field.getPadding(),
                       Field.getHEIGHT()-(i+1)*(platformHeightDifference + jumpHeight),


                        Field.getWIDTH() - playerWidth,
                       Field.getHEIGHT()-jumpHeight*(i+1)-platformHeightDifference*i);
               //platforms[i].setM(-1);
               platforms[i].setDirection(1);

            }else {

                platforms[i] = new Platform(
                        Field.getPadding() + playerWidth,
                        Field.getHEIGHT()-jumpHeight*(i+1)-platformHeightDifference*i,
                        Field.getWIDTH(),
                        Field.getHEIGHT() - (i + 1) * (platformHeightDifference + jumpHeight));
               // platforms[i].setM(1);
                platforms[i].setDirection(-1);
            }

        }

        platforms[MAX_PLATFORMS-1]=new Platform(
                Field.getPadding() + playerWidth,
                Field.getHEIGHT()-jumpHeight*(MAX_PLATFORMS)-platformHeightDifference*(MAX_PLATFORMS-1),
                Field.getWIDTH() - playerWidth,
                Field.getHEIGHT()-jumpHeight*(MAX_PLATFORMS)-platformHeightDifference*(MAX_PLATFORMS-1)
        );


        return platforms;
    }

    public static int getHeightDifference(){
        return platformHeightDifference;
    }
}
