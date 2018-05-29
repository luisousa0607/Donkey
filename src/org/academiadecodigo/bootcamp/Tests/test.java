package org.academiadecodigo.bootcamp.Tests;

import org.academiadecodigo.bootcamp.Collision.Point;
import org.academiadecodigo.bootcamp.GameObjects.Ladder;
import org.academiadecodigo.bootcamp.Player;

public class test {

    public static void main(String[] args) {
        TestPlayer player = new TestPlayer(0, 0, 1);

        Ladder ladder = new Ladder(0, 0, 10);

        System.out.println(player.getBox().hasCollided(ladder));

        System.out.println(player.getBox().collides(player.getBox().getTop(), ladder.getBox().getTop()));

    }
}
