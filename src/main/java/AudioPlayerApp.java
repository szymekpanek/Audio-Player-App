import db.AudioRepository;
import GUI.GUI;

public class AudioPlayerApp {
    public static void main(String[] args) {
        AudioRepository audioRepository = new AudioRepository();
        GUI menu = new GUI();

        boolean run = true;
        int counter = 0;

        while(run) {
            switch(GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.showAudioList(audioRepository.getSoundMap());
                    break;
                case "2":
                    System.out.println("Number 2 works");
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
