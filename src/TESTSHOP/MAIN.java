package TESTSHOP;

import javax.swing.*;
import static TESTSHOP.WINDOWMANAGER.createWindow;

public class MAIN
{
    public static void main(String[] args)
    {
        JFrame frame = createWindow();
        frame.setVisible(true);

        Thread thread = new Thread(new WINDOWMANAGER());
        thread.start();
    }
}
