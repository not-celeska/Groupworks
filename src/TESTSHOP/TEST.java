package TESTSHOP;

import javax.swing.*;
import java.awt.*;

public class TEST extends JFrame implements Runnable
{
    public static JFrame window = new JFrame();
    public static JPanel board = new JPanel();
    public static JLabel text = new JLabel();
    public static JButton button = new JButton();
    public static void main(String[] args)
    {
        TEST test = new TEST(); // Create an instance of TESTSHOP.TEST
        Thread thread = new Thread(test); // Create a new thread with the TESTSHOP.TEST instance
        thread.start(); // Start the thread

        // font
        text.setFont(new Font("Monospaced", Font.BOLD, 28));

        // window
        window.setSize(880, 550);
        window.setLayout(null);
        board.add(text);
        window.add(board);


        // visibility
        window.setVisible(true);
    }

    public static void startProgram()
    {

    }

    public static void setupUI()
    {

    }


    @Override
    public void run()
    {

        while(true)
        {

            text.setText("Dimensions: " + window.getWidth() + " x " + window.getHeight());
        }
    }
}