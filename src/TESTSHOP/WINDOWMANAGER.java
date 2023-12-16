package TESTSHOP;

import javax.swing.*;
import java.awt.*;

public class WINDOWMANAGER extends JFrame implements Runnable
{
    public static JFrame window = new JFrame();
    public static JPanel board = new JPanel();

    @Override
    public void run()
    {
        while (true)
        {
            // updates the game
            update();

            // 60 fps limiter
//            try
//            {
//                Thread.sleep((1000 / 60));
//            } catch (InterruptedException e)
//            {
//                throw new RuntimeException(e);
//            }
        }
    }

    static JFrame createWindow()
    {
        window.setLocationRelativeTo(null);
        window.setName("FurnishSim [20 / 12 / 2023]");

        window.setSize(850, 600);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        JLabel title = new JLabel("FurnishSim");
        title.setFont(new Font("Tahoma", Font.BOLD, 80));
        title.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
        title.setAlignmentY(Component.CENTER_ALIGNMENT); // Center align vertically


        JLabel welcomeLabel = new JLabel("Welcome to..");
        welcomeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center align horizontally
        welcomeLabel.setAlignmentY(Component.CENTER_ALIGNMENT); // Center align vertically
        board.setLayout(new BoxLayout(board, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical centering
        board.add(Box.createVerticalGlue()); // Add glue to center the "Welcome to" text vertically
        board.add(welcomeLabel); // Add the "Welcome to" text to the panel
        board.add(title); // Add the title to the panel
        board.add(Box.createVerticalGlue()); // Add glue to center the title vertically
        window.add(board, BorderLayout.CENTER); // Add the panel to the center of the window

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0)); // Center align the buttons with spacing
        Dimension buttonSize = new Dimension(100, 100); // Adjust the size as needed

        // INFO BUTTON
        JButton infoButton = new JButton();
        infoButton.setBackground(Color.WHITE);
        infoButton.setPreferredSize(buttonSize);
        infoButton.setIcon(new ImageIcon("Resources/INFO.png"));
        infoButton.setName("infoButton");  // Set the name of the button
        infoButton.addActionListener(new BUTTONACTIONHANDLER());


        // PLAY BUTTON
        JButton playButton = new JButton();
        playButton.setBackground(Color.WHITE);
        playButton.setPreferredSize(new Dimension(150, 150));
        playButton.setIcon(new ImageIcon("Resources/PLAY.png"));
        playButton.setName("playButton");  // Set the name of the button
        playButton.addActionListener(new BUTTONACTIONHANDLER());

        // EXIT BUTTON
        JButton exitButton = new JButton();
        exitButton.setBackground(Color.WHITE);
        exitButton.setPreferredSize(buttonSize);
        exitButton.setIcon(new ImageIcon("Resources/EXIT.png"));
        exitButton.setName("exitButton");  // Set the name of the button
        exitButton.addActionListener(new BUTTONACTIONHANDLER());

        buttonPanel.add(infoButton);
        buttonPanel.add(playButton);
        buttonPanel.add(exitButton);
        board.add(buttonPanel); // Add the button panel to the panel
        board.add(Box.createVerticalGlue()); // Add glue to center the buttons vertically
        window.add(board, BorderLayout.CENTER); // Add the panel to the center of the window

        return window;
    }

    static void update()
    {
        // ticks, values will be updated here
//        counter ++;
    }
}
