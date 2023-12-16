package TESTSHOP;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BUTTONACTIONHANDLER implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton button = (JButton) e.getSource();
        if (button.getName().equals("infoButton"))
        {
            // Add code here to handle the action when the infoButton is clicked
            System.out.println("Info button clicked");
        }
        else if (button.getName().equals("playButton"))
        {
            // Add code here to handle the action when the playButton is clicked
            System.out.println("Play button clicked");
        }
        else if (button.getName().equals("exitButton"))
        {
            // Add code here to handle the action when the exitButton is clicked
            System.out.println("Exit button clicked");
            System.exit(0); // exits game
        }
    }
}
