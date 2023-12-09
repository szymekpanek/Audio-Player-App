package Intervals;

import GUI.GUI;
import SoundPlayer.SoundPlayer;
import db.AudioRepository;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Intervals_Game {
    AudioRepository audio = new AudioRepository();
    SoundPlayer player = new SoundPlayer();

    Map<String, String> intervalsMap = new LinkedHashMap<>();

    public void Intervals_Map(){
        intervalsMap.put("U", "Unison");
        intervalsMap.put("m2", "Minor second");
        intervalsMap.put("M2", "Major second");
        intervalsMap.put("m3", "Minor third");
        intervalsMap.put("M3", "Major third");
        intervalsMap.put("P4", "Perfect fourth");
        intervalsMap.put("T", "Triton");
        intervalsMap.put("P5", "Perfect fifth");
        intervalsMap.put("m6", "Minor sixth");
        intervalsMap.put("M6", "Major sixth");
        intervalsMap.put("m7", "Minor seventh");
        intervalsMap.put("M7", "Major seventh");
        intervalsMap.put("8", "Octave");
    }

    public void showIntervalsMap() {
        intervalsMap.entrySet().stream()
                .map(entry -> entry.getKey() + " = " + entry.getValue())
                .forEach(System.out::println);
    }

    public String getRandomKey() {
        return intervalsMap.keySet()
                .stream()
                .skip(new Random().nextInt(intervalsMap.size()))
                .findFirst()
                .orElse(null);
    }

    public void Game() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        String randomKey = getRandomKey();
        String intervalDescription = intervalsMap.get(randomKey);
        System.out.println("Random Interval: " + intervalDescription);

        switch (randomKey){
            case "U":
                playInteval("C", "C");
                break;

            case "m2":
                playInteval("C", "C#");
                break;

            case "M2":
                playInteval("C", "D");
                break;

            case "m3":
                playInteval("C", "D#");
                break;

            case "M3":
                playInteval("C", "E");
                break;

            case "P4":
                playInteval("C", "F");
                break;

            case "T":
                playInteval("C", "F#");
                break;

            case "P5":
                playInteval("C", "G");
                break;

            case "m6":
                playInteval("C", "G#");
                break;

            case "M6":
                playInteval("C", "A");
                break;

            case "m7":
                playInteval("C", "BB");
                break;

            case "M7":
                playInteval("C", "B");
                break;

            case "8":
                playInteval("C", "C2");
                break;
        }
    }

    private void playInteval(String note1, String note2){
        try {
            // Odtwarzanie pierwszego dźwięku
            player.playSound(note1);

            // Planowanie odtworzenia drugiego dźwięku po 1 sekundzie
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
            scheduler.schedule(() -> {
                try {
                    player.playSound(note2);
                } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
                    e.printStackTrace();
                }
            }, 1300, TimeUnit.MILLISECONDS);

            // Zamykanie scheduler po zakończeniu odtwarzania
            scheduler.shutdown();
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Intervals_Game game = new Intervals_Game();
        game.Intervals_Map();
//        game.showIntervalsMap();


        game.Game();
    }
}
