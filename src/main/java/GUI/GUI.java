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



    public static void showGameOptions(){
        System.out.println("Welcome in intervals game");
        System.out.println("You will hear 2 notes - type interval between them");
        System.out.println("Type 'Q' if you want to exit to main menu");
        System.out.println("Type 'R' if you want to repeat interval");
        System.out.println("Type 'S' if you want to start the game again");
        System.out.println("Type 'L' if you want to see a list of intervals");
        System.out.println("Type which interval you hear:");
    }

    public static void showAudioList (Map soundMap){
        System.out.println(soundMap.keySet());
    }


}

