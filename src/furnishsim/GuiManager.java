package furnishsim;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiManager
{
    Business gameState;
    JFrame gameWindow;
    JLabel businessData;

    public GuiManager(Business gameState)
    {
        this.gameState = gameState;
    }

    public void runSimulation() {
        gameWindow = new JFrame();

        // BASIC SETTINGS
        gameWindow.setSize(850, 600);
        gameWindow.setResizable(true);
        gameWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameWindow.setLocationRelativeTo(null);

        // LAYOUT
        // will do this next

        // INFO SCREEN
        JPanel infoScreen = new JPanel();

        // BUSINESS TEXT
        businessData = new JLabel();
        updateGUI();

        // TICK BUTTON
        JButton tickButton = new JButton("TICK");
        tickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.tick();
                System.out.println("Tick was called!");
                updateGUI();
            }
        });

        // BUY WOOD BUTTONS
        JButton oneWood = new JButton("WOOD [1]");
        oneWood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyWood(1);
                System.out.println("bought 1 wood!");
                updateGUI();
            }
        });

        JButton tenWood = new JButton("WOOD [10]");
        tenWood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyWood(10); // boolean for red button
                System.out.println("bought 10 wood!");
                updateGUI();
            }
        });

        // ADDING TO SCREEN & WINDOW
        infoScreen.add(businessData);
        infoScreen.add(tickButton);
        infoScreen.add(oneWood);
        infoScreen.add(tenWood);

        // MAKE FURNITURE BUTTONS
        for (Furniture furniture : gameState.getFurnitures()) {
            JButton button = new JButton("MAKE " + furniture.getFurnitureName() + " [" + furniture.getWoodCost() + "]");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameState.makeFurniture(furniture);
                    System.out.println("made 1 " + furniture.getFurnitureName().toLowerCase());
                    updateGUI();
                }
            });
            infoScreen.add(button);
        }

        // make buy blueprint button
        for (Furniture furniture : gameState.getFurnitures()) {
            if (!furniture.hasBlueprint()) {
                JButton buyBlueprintButton = new JButton("BUY BLUEPRINT " + furniture.getFurnitureName() + " [" + furniture.getBlueprintCost() + "$]");
                buyBlueprintButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO: add identifier; "purchase unseccessful" through boolean; give feedback response
                        gameState.buyBlueprint(furniture);
                        System.out.println("bought blueprint for " + furniture.getFurnitureName().toLowerCase());
                        updateGUI();
                    }
                });
                // TODO unbuyable progression blueprints: use setEnabled(false)
                infoScreen.add(buyBlueprintButton);
            }
            // hide buy button if bought
        }

        JButton buyPosterButton = new JButton("BUY POSTER [" + (gameState.getNumberOfPosters() + 1) + "]");
        buyPosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.putUpPoster();
                System.out.println("Bought 1 poster! customer attraction now " + gameState.getCustomerAttraction());
                updateGUI();
            }
        });
        infoScreen.add(buyPosterButton);

        // Set layout to BoxLayout
        infoScreen.setLayout(new BoxLayout(infoScreen, BoxLayout.Y_AXIS));

        // Add the info screen to the game window
        gameWindow.add(infoScreen);

        // Display the game window
        gameWindow.setVisible(true);
    }


    public void updateGUI()
    {
        // LABELS
        businessData.setText(gameState.toString());

        /*
        labels <--
        buttons
        images
        log
         */



        // this should update the guis for when something is bought, reset the text, etc.
    }
}