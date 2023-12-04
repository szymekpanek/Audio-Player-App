package GUI;

import java.util.Map;
import java.util.Scanner;

public class GUI {
    public final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("""

                Welcome to Audio Player App
                """);
        System.out.println("1. List of audio files");
        System.out.println("2. Play audio");
        System.out.println("3. Exit");
        System.out.print("\n" + "Please type your response: ");
        return scanner.next();
    }

    public static String showSoundPlayerMenu (){
        System.out.println("Hello in SoundPlayer");
        System.out.println("Type any note from note list to play");
        System.out.println("Type 'Q' if you want to exit to main menu");
        System.out.println("Type 'R' if you want to play this note again");
        System.out.println("Type 'L' if you want to see a list of notes");

        System.out.print("\n" + "Please type your response: ");
        return scanner.next();
    }

    public static void showAudioList (Map soundMap){
        System.out.println(soundMap.keySet());
    }


}

