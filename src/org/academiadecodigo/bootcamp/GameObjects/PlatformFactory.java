package org.academiadecodigo.bootcamp.GameObjects;

import org.academiadecodigo.bootcamp.Player;

public class PlatformFactory {

    private static final int MAX_PLATFORMS = 6;
    private int playerWidth = Player.getPlayerwidth();
    private int jumpHeight = Player.getPlayerwidth() -10;
    private static int platformHeightDifference;
    private int playerHeight = playerWidth;

    public Platform[] createPlatform() {


        this.platformHeightDifference = (Field.getHEIGHT()-playerHeight - Field.getPadding() - MAX_PLATFORMS*(jumpHeight))/
                (MAX_PLATFORMS-1);

        Platform[] platforms = new Platform[MAX_PLATFORMS];

        platforms[0]=new Platform(
                Field.getPadding() + playerWidth,
                Field.getHEIGHT(),
                Field.getWIDTH() - playerWidth,
                Field.getHEIGHT()
        );

        for (int i = 1; i < platforms.length-1 ; i++) {

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
                Field.getWIDTH() - playerWidth- 50,
                Field.getHEIGHT()-jumpHeight*(MAX_PLATFORMS)-platformHeightDifference*(MAX_PLATFORMS-1)
        );


        return platforms;
    }

    public static int getHeightDifference(){
        return platformHeightDifference;
    }
}
