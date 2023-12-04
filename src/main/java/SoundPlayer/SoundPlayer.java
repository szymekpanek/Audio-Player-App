package SoundPlayer;

import App.AudioPlayerApp;
import db.AudioRepository;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;


public class SoundPlayer {
    AudioRepository audioRp = new AudioRepository();

    public void playSound (String note) throws LineUnavailableException, UnsupportedAudioFileException, IOException {

        if (audioRp.getSoundMap().containsKey(note)) {
            File soundFileName = new File(audioRp.getSoundFileName(note));
            System.out.println("Odtwarzam dźwięk: " + soundFileName);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFileName);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } else System.out.println("Wrong note");
    }
}
