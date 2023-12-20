package TESTSHOP;

import javax.swing.*;
import java.awt.*;

public class COORDINATELAYOUT
{

    static Font textFont = new Font("Serif", Font.BOLD, 14);

    public static void main(String[] args)
    {
        new COORDINATELAYOUT().makeUI();
    }

    public void makeUI()
    {
        JFrame window = new JFrame();
        window.setSize(850, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        // Create a JPanel with custom paintComponent method to draw the background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("Resources/GUI.png");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Set the layout of the background panel to null for absolute positioning
        backgroundPanel.setLayout(null);

        // Create and position other components on top of the background panel
        JButton stoolIcon = new JButton();
//        stoolIcon.setIcon();
        stoolIcon.setBounds(35, 97, 48, 48); // x, y, width, height
        backgroundPanel.add(stoolIcon);

        JButton chairButton = new JButton("C");
        chairButton.setBounds(35, 180, 48, 48); // x, y, width, height
        backgroundPanel.add(chairButton);

        JButton tableBut = new JButton("C");
        tableBut.setBounds(35, 263, 48, 48); // x, y, width, height
        backgroundPanel.add(tableBut);

        JLabel money = new JLabel("150$");
        money.setFont(textFont);
        money.setBounds(54, 523, 100, 30); // x, y, width, height
        backgroundPanel.add(money);

        // Add the background panel to the JFrame
        window.add(backgroundPanel);
        window.setVisible(true);
    }
}
