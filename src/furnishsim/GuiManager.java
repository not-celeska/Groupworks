package furnishsim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class GuiManager {
    Business gameState;
    JFrame gameWindow;
    JLabel businessData;

    // autoTicker
    Timer autoTickerTimer;
    boolean autoTickerActive = false;

    // INFORMATION LABELS
    JLabel companyName;
    JLabel moneyInfo;
    JLabel popularityInfo; // tweaked version of customerAttraction
    JLabel blueprintsUnlockedInfo;
    JLabel numPostersInfo;
    JLabel numWoodInfo;
    JLabel numNailInfo;
    JLabel numScrewInfo;
    JLabel numHardwoodInfo;

    // IMAGES
    ImageIcon boughtIcon = new ImageIcon("furnishResources/BOUGHT.png");

    public GuiManager(Business gameState) {
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

        // MEDIUM

        // SMALLER PANELS
        JPanel buyAndAdvertise = new JPanel(); // buy & advertise
        JPanel buyingPanel = createBuyingOptionsPanel();
        JPanel makePanel = createMakePanel();
        JPanel blueprintPanel = createBlueprintPanel();
        JPanel infoPanel = createInfoPanel();

        // Add the  screen to the game window
        gamePanel.add(buyAndAdvertise);
        gamePanel.add(buyingPanel);
        gamePanel.add(makePanel);
        gamePanel.add(blueprintPanel);
        gamePanel.add(infoPanel);

        // creates the auto ticker
        createAutoTicker();

        // Display the game window
        gameWindow.setVisible(true);
        updateGUI();
    }

    private JPanel createInfoPanel() {
        JPanel infoPanel = new JPanel(); // information
        infoPanel.setBackground(Color.lightGray);

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

        numNailInfo = new JLabel();
        infoPanel.add(numNailInfo);

        numScrewInfo = new JLabel();
        infoPanel.add(numScrewInfo);

        numHardwoodInfo = new JLabel();
        infoPanel.add(numHardwoodInfo);

        // LAYOUT

        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));

        // RETURN

        return infoPanel;
    }

    private JPanel createMakePanel() {
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
                        gameState.buyBlueprint(furniture);
                        if (furniture.hasBlueprint()) {
                            System.out.println("bought blueprint for " + furniture.getFurnitureName().toLowerCase());
                            buyBlueprintButton.setEnabled(false);
                        } else {
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

    private JPanel createBuyingOptionsPanel() {
        JPanel buyingOptionPanel = new JPanel();

        // label
        JLabel title = new JLabel("OPTIONS: ");
        buyingOptionPanel.add(title);

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

        // AUTO TICKER

        JButton autoTickerButton = new JButton("AUTO TICKER");
        autoTickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoTickerActive = !(autoTickerActive);
                System.out.println("autoTicker is now: " + autoTickerActive);
                // on and off icon

                updateGUI();
            }
        });


        // TODO add 1 or 10 per button through
        // BUY WOOD BUTTON
        JButton buyWoodButton = new JButton();
        buyWoodButton.setPreferredSize(new Dimension(48, 48));
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyResource(1, gameState.WOOD);
                System.out.println("bought 1 wood!");
                updateGUI();
            }
        });


        // BUY NAILS BUTTOn
        JButton buyNailButton = new JButton();
        buyNailButton.setPreferredSize(new Dimension(48, 48));
        buyNailButton.setIcon(new ImageIcon("furnishResources/NAIL.png"));
        buyNailButton.setRolloverIcon(new ImageIcon("furnishResources/NAIL_HOVER.png"));
        buyNailButton.setPressedIcon(new ImageIcon("furnishResources/NAIL_PRESSED.png"));
        buyNailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyResource(1, gameState.NAILS);
                System.out.println("bought 1 nail!");
                updateGUI();
            }
        });

        // BUY SCREWS BUTTON
        JButton buyScrewsButton = new JButton();
        buyScrewsButton.setPreferredSize(new Dimension(48, 48));
        buyScrewsButton.setIcon(new ImageIcon("furnishResources/SCREWS.png"));
        buyScrewsButton.setRolloverIcon(new ImageIcon("furnishResources/SCREWS_HOVER.png"));
        buyScrewsButton.setPressedIcon(new ImageIcon("furnishResources/SCREWS_PRESSED.png"));
        buyScrewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyResource(1, gameState.SCREWS);
                System.out.println("bought 1 screw!");
                updateGUI();
            }
        });

        // hardwood
        JButton buyHardwoodButton = new JButton();
        buyHardwoodButton.setPreferredSize(new Dimension(48, 48));
        buyHardwoodButton.setIcon(new ImageIcon("furnishResources/HARDWOOD.png"));
        buyHardwoodButton.setRolloverIcon(new ImageIcon("furnishResources/HARDWOOD_HOVER.png"));
        buyHardwoodButton.setPressedIcon(new ImageIcon("furnishResources/HARDWOOD_PRESSED.png"));
        buyHardwoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameState.buyResource(1, gameState.HARDBOARD);
                System.out.println("bought 1 hardwood!");
                updateGUI();
            }
        });


        // store
        JButton buyStoreButton = new JButton();
        buyStoreButton.setPreferredSize(new Dimension(144, 48));
        buyStoreButton.setIcon(new ImageIcon("furnishResources/STORE.png"));
        buyStoreButton.setRolloverIcon(new ImageIcon("furnishResources/STORE_HOVER.png"));
        buyStoreButton.setPressedIcon(new ImageIcon("furnishResources/STORE_PRESSED.png"));
        buyStoreButton.setDisabledIcon(new ImageIcon("furnishResources/STORE_BOUGHT.png"));
        buyStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gameState.buyStore();
                if (gameState.isBoughtStore()) {
                    System.out.println("BOUGHT STORE! CONGRATS!");
                } else {
                    System.out.println("FAILED TO BUY STORE.");
                }
                updateGUI();
            }
        });


        // poster

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
        buyingOptionPanel.add(buyPosterButton);


        // ADDING TO SCREEN & WINDOW
        buyingOptionPanel.add(autoTickerButton);
        buyingOptionPanel.add(tickButton);
        buyingOptionPanel.add(buyNailButton);
        buyingOptionPanel.add(buyScrewsButton);
        buyingOptionPanel.add(buyWoodButton);
        buyingOptionPanel.add(buyHardwoodButton);
        buyingOptionPanel.add(buyStoreButton);

        return buyingOptionPanel;
    }

    public void createAutoTicker()
    {
        autoTickerTimer = new Timer();

        autoTickerTimer.scheduleAtFixedRate(new TimerTask()
        {
            @Override
            public void run() {
                if (autoTickerActive)
                {
                    gameState.tick();
                    updateGUI();
                }
            }
        }, 2000, 2000);
    }


    public void updateGUI() {
        // LABELS
        businessData.setText("---"/*gameState.toString()*/);
        companyName.setText(gameState.getCompanyName());
        moneyInfo.setText("MONEY: " + gameState.getMoney() + "$");
        popularityInfo.setText("POPULARITY: " + Math.round(gameState.getCustomerAttraction() * 100) + "%");
        blueprintsUnlockedInfo.setText("BLUEPRINTS UNLOCKED: " + gameState.getBlueprintsUnlocked());
        numPostersInfo.setText("# OF POSTERS: " + gameState.getNumPosters());
        numWoodInfo.setText("WOOD: " + gameState.getResources()[gameState.WOOD]);
        numNailInfo.setText("NAIL: " + gameState.getResources()[gameState.NAILS]);
        numScrewInfo.setText("SCREW: " + gameState.getResources()[gameState.SCREWS]);
        numHardwoodInfo.setText("HARDWOOD: " + gameState.getResources()[gameState.HARDBOARD]);

/*
        images (stage)
        log
         */


        // this should update the guis for when something is bought, reset the text, etc.
    }
}