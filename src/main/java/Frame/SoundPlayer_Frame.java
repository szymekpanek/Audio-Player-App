package Frame;

import SoundPlayer.SoundPlayer;
import db.AudioRepository;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Map;

public class SoundPlayer_Frame {
    private JFrame frame;
    public SoundPlayer soundPlayer;

    public SoundPlayer_Frame() {
        initializeFrame();
        buildUI();
    }

    private void initializeFrame() {
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(750, 750);
        frame.setResizable(false);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildUI() {
        frame.add(createTitleLabel(), BorderLayout.NORTH);
        frame.add(createSongButtons(), BorderLayout.CENTER);
    }

    private JLabel createTitleLabel() {
        JLabel label = new JLabel();
        label.setText("Sound Player");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setVisible(true);
        return label;
    }

    private JPanel createSongButtons() {
        AudioRepository audioRepository = new AudioRepository();
        Map<String, String> soundMap = audioRepository.getSoundMap();

        JPanel songPanel = new JPanel(new GridLayout(soundMap.size(), 1, 0, 20));
        songPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (Map.Entry<String, String> entry : soundMap.entrySet()) {
            String songName = entry.getKey();
            JButton songButton = makeSongButton(songName);
            songPanel.add(songButton);
        }

        return songPanel;
    }

    private JButton makeSongButton(String songName) {
        JButton button = new JButton(songName);
        // Dodaj tutaj ActionListener, jeśli chcesz obsługiwać kliknięcia przycisków
        // button.addActionListener(e -> handleButtonClick(songName));

        button.addActionListener(e -> handleButtonClick(songName));
        return button;
    }


     private void handleButtonClick(String songName) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
         soundPlayer.playSound(songName);
     }

    public static void main(String[] args) {
        new SoundPlayer_Frame();
    }
}
