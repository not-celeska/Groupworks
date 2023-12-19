package furnishsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class GuiManager
{
    Business gameState;
    JFrame gameWindow;
    JLabel businessData;

    // INFORMATION LABELS
    JLabel companyName;
    JLabel moneyInfo;
    JLabel popularityInfo; // tweaked version of customerAttraction
    JLabel blueprintsUnlockedInfo;
    JLabel numPostersInfo;
    JLabel numWoodInfo;

    // IMAGES
    ImageIcon boughtIcon = new ImageIcon("furnishResources/BOUGHT.png");

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

//        gameWindow.setIconImage(); // LOGO
        gameWindow.setName("ISC3U - FURNISH_SIM");

        // BIG PANEL
        JPanel gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        gameWindow.add(gamePanel);

        // SMALLER PANELS
        JPanel optionPanel = new JPanel(); // buy & advertise
        JPanel buyingPanel = createBuyingPanel();
        JPanel makePanel = createMakePanel();
        JPanel blueprintPanel = createBlueprintPanel();
        JPanel infoPanel = createInfoPanel();

        // Add the  screen to the game window
        gamePanel.add(optionPanel);
        gamePanel.add(buyingPanel);
        gamePanel.add(makePanel);
        gamePanel.add(blueprintPanel);
        gamePanel.add(infoPanel);

        // Display the game window
        gameWindow.setVisible(true);
        updateGUI();
    }

    private JPanel createInfoPanel()
    {
        JPanel infoPanel = new JPanel(); // information
        infoPanel.setBackground(Color.BLUE);

        // LABELS

        businessData = new JLabel();
        infoPanel.add(businessData);

        companyName = new JLabel();
        infoPanel.add(companyName);

        moneyInfo = new JLabel();
        infoPanel.add(moneyInfo);

        popularityInfo = new JLabel();
        infoPanel.add(popularityInfo);

        blueprintsUnlockedInfo = new JLabel();
        infoPanel.add(blueprintsUnlockedInfo);

        numPostersInfo = new JLabel();
        infoPanel.add(numPostersInfo);

        numWoodInfo = new JLabel();
        infoPanel.add(numWoodInfo);

        // LAYOUT

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        // RETURN

        return infoPanel;
    }

    private JPanel createMakePanel()
    {
        JPanel makePanel = new JPanel();

        // HEADER / TEXT
        JLabel header = new JLabel("MAKE: ");
        makePanel.add(header);

        // BUTTONS
        for (Furniture furniture : gameState.getFurnitures()) {
            JButton button = new JButton(furniture.getFurnitureName().charAt(0) + "");
            button.setPreferredSize(new Dimension(48, 48));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gameState.makeFurniture(furniture);
                    System.out.println("made 1 " + furniture.getFurnitureName().toLowerCase());
                    updateGUI();
                }
            });
            makePanel.add(button);
        }

        // RETURN
        return makePanel;
    }

    private JPanel createBlueprintPanel() {
        JPanel blueprintPanel = new JPanel();

        // HEADER / TEXT
        JLabel header = new JLabel("BLUEPRINTS: ");
        blueprintPanel.add(header);

        // BUTTONS
        for (Furniture furniture : gameState.getFurnitures()) {
            if (!furniture.hasBlueprint()) {
                JButton buyBlueprintButton = new JButton();
                buyBlueprintButton.setPreferredSize(new Dimension(48, 48));
                buyBlueprintButton.setIcon(furniture.getIcon());
                buyBlueprintButton.setRolloverEnabled(true);
                buyBlueprintButton.setRolloverIcon(furniture.getHoverIcon());
                buyBlueprintButton.setPressedIcon(furniture.getClickIcon());
                buyBlueprintButton.setDisabledIcon(boughtIcon);
                buyBlueprintButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO: add purchase unsuccesful icon.
                        gameState.buyBlueprint(furniture);
                        if (furniture.hasBlueprint())
                        {
                            System.out.println("bought blueprint for " + furniture.getFurnitureName().toLowerCase());
                            buyBlueprintButton.setEnabled(false);
                        }
                        else
                        {
                            System.out.println("failed to purchase BLUEPRINT for: " + furniture.getFurnitureName().toUpperCase());
                        }
                        updateGUI();
                    }
                });
                blueprintPanel.add(buyBlueprintButton);
            }
        }

        // RETURN
        return blueprintPanel;

    }

    private JPanel createBuyingPanel()
    {
        JPanel buyingPanel = new JPanel();

        // label
        JLabel title = new JLabel("OPTIONS: ");
        buyingPanel.add(title);

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

        // BUY WOOD BUTTON
        JButton buyWoodButton = new JButton();
        buyWoodButton.setPreferredSize(new Dimension(48, 48));
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyWood(1);
                System.out.println("bought 1 wood!");
                updateGUI();
            }
        });


        JButton buyPosterButton = new JButton();
        buyPosterButton.setPreferredSize(new Dimension(64, 80));
        buyPosterButton.setIcon(new ImageIcon("furnishResources/POSTER.png"));
        buyPosterButton.setRolloverIcon(new ImageIcon("furnishResources/POSTER_HOVER.png"));
        buyPosterButton.setPressedIcon(new ImageIcon("furnishResources/POSTER_PRESSED.png"));
        buyPosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.putUpPoster();
                System.out.println("Bought 1 poster! customer attraction now " + gameState.getCustomerAttraction());
                updateGUI();
            }
        });
        buyingPanel.add(buyPosterButton);



        // ADDING TO SCREEN & WINDOW
        buyingPanel.add(tickButton);
        buyingPanel.add(buyWoodButton);

        return buyingPanel;
    }

    public void updateGUI()
    {
        // LABELS
        businessData.setText("---"/*gameState.toString()*/);
        companyName.setText(gameState.getCompanyName());
        moneyInfo.setText("MONEY: " + gameState.getMoney() + "$");
        popularityInfo.setText("POPULARITY: " + Math.round(gameState.getCustomerAttraction() * 100) + "%");
        blueprintsUnlockedInfo.setText("BLUEPRINTS UNLOCKED: " + gameState.getBlueprintsUnlocked());
        numPostersInfo.setText("# OF POSTERS: " + gameState.getNumPosters());
        numWoodInfo.setText("WOOD: " + gameState.getWood());

/*
        images (stage)
        log
         */



        // this should update the guis for when something is bought, reset the text, etc.
    }
}