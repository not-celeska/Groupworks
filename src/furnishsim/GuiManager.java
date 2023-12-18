package furnishsim;

import javax.swing.*;

public class GuiManager
{
    Business gameState;
    JFrame gameWindow;

    public GuiManager(Business gameState)
    {
        this.gameState = gameState;
    }

    public void runSimulation()
    {
        gameWindow = new JFrame();
        JPanel infoScreen = new JPanel();
        JLabel businessData = new JLabel(gameState.toString());
        JButton tickButton = new JButton("TICK");
        infoScreen.add(businessData);
        infoScreen.add(tickButton);
        gameWindow.add(infoScreen);

        System.out.println("FurnishSim has started!!!");
        gameWindow.setSize(700, 150);
        gameWindow.setResizable(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

    }
}
