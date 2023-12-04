package db;

import java.util.HashMap;
import java.util.Map;

public class AudioRepository {
    private Map<String, String> soundMap = new HashMap<>();

    private void addSound(String note, String soundFileName) {
        soundMap.put(note, soundFileName);
    }
    public AudioRepository() {
        soundMap = new HashMap<>();

        addSound("C", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/c.wav");
        addSound("C#", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/c#.wav");
        addSound("D", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/d.wav");
        addSound("D#", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/d#.wav");
        addSound("E", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/e.wav");
        addSound("F", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/f.wav");
        addSound("F#", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/f#.wav");
        addSound("G", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/g.wav");
        addSound("G#", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/g#.wav");
        addSound("A", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/A.wav");
        addSound("BB", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/bb.wav");
        addSound("B", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/b.wav");
        addSound("C2", "/Users/osx/IdeaProjects/AudioPlayer/src/main/resources/wav_files/c2.wav");
    }

    public Map<String, String> getSoundMap() {
        return soundMap;
    }

    public String getSoundFileName(String note) {
        return soundMap.get(note);
    }

}
