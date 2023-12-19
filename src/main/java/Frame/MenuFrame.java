package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame {

    private JFrame menuFrame;

    public MenuFrame() {
        initializeMenuFrame();
        buildUI();
    }

    private void initializeMenuFrame() {
        menuFrame = new JFrame();
        menuFrame.setSize(750, 750);
        menuFrame.setResizable(false);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.getContentPane().setBackground(Color.DARK_GRAY);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void buildUI() {
        addTitleLabel();
        addMenuButtons();
        menuFrame.setVisible(true);
    }

    private void addTitleLabel() {
        JLabel titleLabel = new JLabel("Audio Player App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        int marginSize = (int) (menuFrame.getWidth() * 0.3);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, marginSize, 0, marginSize));

        menuFrame.add(titleLabel, BorderLayout.NORTH);
    }

    private void addMenuButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        addMenuButton(buttonPanel, "Intervals Game", "Intervals Game button clicked");
        addMenuButton(buttonPanel, "Sound Player", "Sound Player button clicked");

        int marginSize = (int) (menuFrame.getWidth() * 0.3);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, marginSize, 0, marginSize));

        menuFrame.add(buttonPanel, BorderLayout.CENTER);
    }

    private void addMenuButton(JPanel panel, String buttonText, final String message) {
        JButton menuButton = new JButton(buttonText);

        menuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleButtonClick(buttonText);
            }
        });

        panel.add(menuButton);
    }

    private void handleButtonClick(String buttonText) {
        if ("Sound Player".equals(buttonText)) {
            openSoundPlayerFrame();
        } else if ("Intervals Game".equals(buttonText)) {
            openIntervalsFrame();
        }
    }

    private void openSoundPlayerFrame() {
        SoundPlayer_Frame soundPlayerFrame = new SoundPlayer_Frame();
    }

    private void openIntervalsFrame() {
        Intervals_Frame intervalsFrame = new Intervals_Frame();
    }

    public static void main(String[] args) {
        new MenuFrame();
    }
}
