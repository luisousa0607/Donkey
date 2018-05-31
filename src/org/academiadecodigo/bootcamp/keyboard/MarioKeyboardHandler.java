package org.academiadecodigo.bootcamp.keyboard;

import org.academiadecodigo.bootcamp.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MarioKeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {

    private Player player;
    private Keyboard keyboard;

    public MarioKeyboardHandler(Player player){
        this.player = player;
        this.setKeyboard();
    }

    public void keyPressed(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_RIGHT: {
                if (!this.player.isOnLadder() && !this.player.getIsJumping()) {
                    this.player.move(this.player.getSpeed(), 0);
                    this.player.setDirection(1);
                }
                break;
            }
            case KeyboardEvent.KEY_LEFT: {
                if (!this.player.isOnLadder() && !this.player.getIsJumping()) {
                    this.player.move(-this.player.getSpeed(), 0);
                    this.player.setDirection(-1);
                }
                break;
            }
            case KeyboardEvent.KEY_SPACE: {
                this.player.setJumping(true);
                break;
            }

            case KeyboardEvent.KEY_UP: {
                if (this.player.isOnLadder()) {
                    this.player.move(0, -1);

                }
                break;
            }

            case KeyboardEvent.KEY_DOWN:{
                if(this.player.isOnLadder()){
                    this.player.move(0,1);
                }
                break;
            }

        }
    }

    public void keyReleased(KeyboardEvent event) {

        switch (event.getKey()) {

            case KeyboardEvent.KEY_LEFT: {
            }

        }

    }

    public void setKeyboard() {

        this.keyboard = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(up);

        KeyboardEvent left_release = new KeyboardEvent();
        left_release.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        left_release.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left_release);

        KeyboardEvent climb = new KeyboardEvent();
        climb.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        climb.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(climb);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

    }

}
