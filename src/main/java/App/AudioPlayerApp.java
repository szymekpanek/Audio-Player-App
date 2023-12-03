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

        while(run) {
            switch(GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.showAudioList(audioRepository.getSoundMap());
                    break;
                case "2":
                    SoundPlayer.showSoundPlayerMenu();
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
