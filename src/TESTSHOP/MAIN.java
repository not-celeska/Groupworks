package TESTSHOP;

import javax.swing.*;
import static TESTSHOP.WINDOWMANAGER.createWindow;

// sigma ohio

public class MAIN
{
    public static void main(String[] args)
    {
        JFrame frame = createWindow();
        System.out.println("Started the program; window opened.");
        frame.setVisible(true);

        Thread thread = new Thread(new WINDOWMANAGER());
        thread.start();
    }
}
