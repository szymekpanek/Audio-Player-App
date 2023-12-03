package GUI;

import java.util.Map;
import java.util.Scanner;

public class GUI {
    private final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("\n" + "Welcome to Audio Player App" + "\n");
        System.out.println("1. List of audio files");
        System.out.println("2. Play audio");
        System.out.println("3. Exit");
        System.out.print("\n" + "Please type your response: ");
        return scanner.next();
    }

    public static void showAudioList (Map soundMap){
        System.out.println(soundMap.keySet());
    }

}

