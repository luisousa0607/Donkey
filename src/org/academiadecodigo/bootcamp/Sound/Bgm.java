package org.academiadecodigo.bootcamp.Sound;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bgm implements Runnable{
    Player playMP3;
    FileInputStream fis;

    public Bgm(String source) throws FileNotFoundException, JavaLayerException {

                fis = new FileInputStream(source);
                playMP3 = new Player(fis);
    }

    @Override
    public void run() {
        try {
            playMP3.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public static Thread bgm = new Thread(new Runnable() {
        public void run()
        {
            try {
                Bgm bm = new Bgm("resources/Music/bgm.mp3");
                bm.run();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

        }});


    public static SoundPlayer lost = new SoundPlayer("/resources/Music/lost.wav");


    public static SoundPlayer overBarrel = new SoundPlayer("/resources/Music/overBarrel.wav");

    public static SoundPlayer win = new SoundPlayer("/resources/Music/win.wav");

}
