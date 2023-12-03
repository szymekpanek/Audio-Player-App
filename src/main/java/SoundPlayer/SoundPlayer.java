package SoundPlayer;
import GUI.GUI;
import db.AudioRepository;
import App.AudioPlayerApp;

import java.util.Scanner;

public class SoundPlayer {
    GUI mainGUI = new GUI();
    static AudioPlayerApp app = new AudioPlayerApp();
    static AudioRepository audioRepository = new AudioRepository();

    public static void playSound(String soundKey){


        while(app.run) {
            switch(showSoundPlayerMenu()) {
                case "L":
                    GUI.showAudioList(audioRepository.getSoundMap());
                    break;
                case "Q":
                    GUI.showMenuAndReadChoose();
                    break;
                default:
                    if (audioRepository.getSoundMap().containsKey(GUI.scanner)){
                        System.out.println("You choose " + audioRepository.getSoundMap().keySet() + "note");
                    }
                    else System.out.println("Wrong note");
                    break;
            }
        }
    }

    public static String showSoundPlayerMenu (){
        System.out.println("Hello in SoundPlayer");
        System.out.println("Type any note from note list to play");
        System.out.println("Type 'Q' if you want to exit to main menu");
        System.out.println("Type 'R' if you want to play this note again");
        System.out.println("Type 'L' if you want to see a list of notes");

        System.out.print("\n" + "Please type your response: ");
        return GUI.scanner.next();
    }
}
