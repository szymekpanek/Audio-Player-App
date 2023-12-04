package App;

import SoundPlayer.SoundPlayer;
import db.AudioRepository;
import GUI.GUI;
import java.io.IOException;

public class AudioPlayerApp {
    public boolean run;

    public static void main(String[] args) throws IOException {
        AudioRepository audioRepository = new AudioRepository();
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
                                if (audioRepository.getSoundMap().containsKey(userInput)) {
                                    String soundFileName = audioRepository.getSoundFileName(userInput);
                                    System.out.println("Odtwarzam dźwięk: " + soundFileName);
                                    // Dodaj kod do odtwarzania dźwięku na podstawie soundFileName
                                } else {
                                    System.out.println("Wrong choose !!");
                                }
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
