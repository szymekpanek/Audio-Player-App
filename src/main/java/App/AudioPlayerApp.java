package App;

import SoundPlayer.SoundPlayer;
import db.AudioRepository;
import GUI.GUI;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class AudioPlayerApp {
    public boolean run;

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        AudioRepository audioRepository = new AudioRepository();
        SoundPlayer player = new SoundPlayer();
        boolean run = true;
        boolean flag = true;

        while (run) {
            switch (GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.showAudioList(audioRepository.getSoundMap());
                    break;

                case "2":
                    while (flag) {
                        String userInput = GUI.showSoundPlayerMenu().toUpperCase(); // Zakładam, że klucze są w wielkich literach

                        switch (userInput) {
                            case "L":
                                GUI.showAudioList(audioRepository.getSoundMap());
                                break;

                            case "Q":
                                flag = false;  // Zakończ pętlę wewnętrzną
                                break;

                            case "R":
                                System.out.println("Odtwarzam ostatni dźwięk.");
                                // Dodaj kod do odtwarzania ostatniego dźwięku
                                break;

                            default:
                                player.playSound(userInput);
                                break;
                        }
                    }
                    flag = true;
                    break;

                case "3":
                    System.out.println("Goodbye");
                    run = false;
                    break;

                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
