package furnishsim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // INFO SCREEN
        JPanel infoScreen = new JPanel();

        // BUSINESS TEXT
        JLabel businessData = new JLabel(gameState.toString());

        // TICK BUTTON
        JButton tickButton = new JButton("TICK");
        tickButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gameState.tick();
                System.out.println("Tick was called!");
                businessData.setText(gameState.toString());
            }
        });

        // BUY WOOD BUTTONS

        JButton oneWood = new JButton("WOOD [1]");
        oneWood.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gameState.buyWood(1);
                System.out.println("bought 1 wood!");
                businessData.setText(gameState.toString());
            }
        });

        JButton tenWood = new JButton("WOOD [10]");
        tenWood.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                gameState.buyWood(10); // boolean for red button
                System.out.println("bought 10 wood!");
                businessData.setText(gameState.toString());
            }
        });


        // ADDING TO SCREEN & WINDOW
        infoScreen.add(businessData);
        infoScreen.add(tickButton);
        infoScreen.add(oneWood);
        infoScreen.add(tenWood);
        gameWindow.add(infoScreen);

        System.out.println("FurnishSim has started!!!");
        gameWindow.setSize(700, 150);
        gameWindow.setResizable(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocationRelativeTo(null);
        gameWindow.setVisible(true);

    }
}