package Frame;

import Intervals.Intervals_Game;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_App implements ActionListener {
    JButton button;
    Intervals_Game intervalsGame; // Dodanie referencji do klasy Intervals_Game

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Window_App().createAndShowGUI();
        });
    }

    public void createAndShowGUI() {
        // title label
        JLabel label = new JLabel();
        label.setText("Intervals App");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setVisible(true);

        // title panel
        JPanel title_panel = new JPanel();
        title_panel.setBackground(Color.DARK_GRAY);
        title_panel.setBounds(0, 0, 750, 100);
        title_panel.add(label);


        // button answer panel
        JPanel ans_panel = new JPanel();
        ans_panel.setBackground(Color.WHITE);
        ans_panel.setBounds(0,400,750,100);
        ans_panel.setLayout(new FlowLayout());
        ans_panel.add(new JButton("U"));
        ans_panel.add(new JButton("Minor 2"));
        ans_panel.add(new JButton("Major 2"));
        ans_panel.add(new JButton("Minor 3"));
        ans_panel.add(new JButton("Major 3"));
        ans_panel.add(new JButton("Perf 4"));
        ans_panel.add(new JButton("Triton"));
        ans_panel.add(new JButton("Perf 5"));
        ans_panel.add(new JButton("Minor 6"));
        ans_panel.add(new JButton("Major 6"));
        ans_panel.add(new JButton("Minor 7"));
        ans_panel.add(new JButton("Major 7"));
        ans_panel.add(new JButton("Octave"));


        // frame
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(750, 750);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Button
        button = new JButton("Play interval: ");
        button.setBounds(0, 300, 100, 50);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVisible(true);
        button.addActionListener(this);




        frame.add(title_panel);
        frame.add(ans_panel);
        frame.add(button);

        // Utwórz instancję klasy Intervals_Game
        intervalsGame = new Intervals_Game();
        intervalsGame.Intervals_Map();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            try {
                intervalsGame.Game();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
