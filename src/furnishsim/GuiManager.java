package furnishsim;

import javax.swing.*;

public class GuiManager extends JFrame
{
    Business gameState;

    public GuiManager(Business gameState)
    {
        this.gameState = gameState;
    }

    public void runSimulation()
    {
        System.out.println("FurnishSim has started!!!");
    }
}
