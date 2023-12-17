package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame {

    public void menu() {
        JFrame menuFrame = new JFrame();
        menuFrame.setVisible(true);
        menuFrame.setSize(750, 750);
        menuFrame.setResizable(false);
        menuFrame.setLayout(new BorderLayout());
        menuFrame.getContentPane().setBackground(Color.DARK_GRAY);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Dodaj duży tytułowy label z większymi marginesami po lewej i prawej
        JLabel titleLabel = new JLabel("Audio Player App");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        int marginSize = (int) (menuFrame.getWidth() * 0.3);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, marginSize, 0, marginSize));

        menuFrame.add(titleLabel, BorderLayout.NORTH);

        // Dodaj przyciski z większym dystansem
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 0, 20));
        addMenuButton(buttonPanel, "Intervals Game", "Intervals Game button clicked");
        addMenuButton(buttonPanel, "Sound Player", "Sound Player button clicked");
        addMenuButton(buttonPanel, "List of songs", "List of songs button clicked");

        // Zastosuj margines dla panelu z przyciskami
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, marginSize, 0, marginSize));

        menuFrame.add(buttonPanel, BorderLayout.CENTER);
    }

    private void addMenuButton(JPanel panel, String buttonText, final String message) {
        JButton menuButton = new JButton(buttonText);

        menuButton.addActionListener(e -> JOptionPane.showMessageDialog(panel, message));

        panel.add(menuButton);
    }

    public static void main(String[] args) {
        MenuFrame menuFrame = new MenuFrame();
        menuFrame.menu();
    }
}
