package furnishsim;

import javax.swing.*;
import javax.swing.text.JTextComponent;
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

    // textArea
    JTextArea consoleText;
    JScrollPane consoleScrollPane;

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

//        JPanel consolePanel = new JPanel();
//        consolePanel.setMaximumSize(new Dimension( 500, 200));
        consoleText = new JTextArea();
        consoleText.setEditable(false);
//        consolePanel.add(consoleText);
        consoleText.setBackground(Color.pink);
//        consoleText.setBounds(300, 300, 400, 400);
//        consoleScrollPane = new JScrollPane(consoleText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
//                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        consolePanel.add(consoleScrollPane);



        // Add the  screen to the game window
        gamePanel.add(buyAndAdvertise);
        gamePanel.add(buyingPanel);
        gamePanel.add(makePanel);
        gamePanel.add(blueprintPanel);
        gamePanel.add(consoleText);
        gamePanel.add(infoPanel);

        // creates the auto ticker
        createAutoTicker();

        // Display the game window
        gameWindow.setVisible(true);
        writeInConsole(" > Simulation is ONLINE!\n" +
                           "       -   This is where you will see things that happen! Have fun!");
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
                    // TODO if successful
                    writeInConsole("[MADE] 1 " + furniture.getFurnitureName().toUpperCase());
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
                            writeInConsole("[BLUEPRINT] BOUGHT " + furniture.getFurnitureName().toUpperCase() + " SUCCESSFULLY");
                            buyBlueprintButton.setEnabled(false);
                        } else {
                            writeInConsole("[BLUEPRINT] FAILED TO BUY " + furniture.getFurnitureName().toUpperCase());
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
                gameState.setTicksActive(gameState.getTicksActive() + 1);
                consoleText.setText(" # NEW TICK [" + gameState.getTicksActive() + "]");
                consoleText.append(gameState.tick());
                updateGUI();
            }
        });

        // AUTO TICKER

        JButton autoTickerButton = new JButton("AUTO TICKER");
        autoTickerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autoTickerActive = !(autoTickerActive);

                String onOff;

                if (autoTickerActive)
                {
                    onOff = "| ENABLED |";
                    autoTickerButton.setBackground(Color.green);
                }
                else
                {
                    onOff = "| DISABLED |";
                    autoTickerButton.setBackground(Color.red);

                }

                writeInConsole("\n[AUTOTICKER] " + onOff);

                // TODO on and off icon

                updateGUI();
            }
        });


        // TODO add 1 or 10 per button through <-- just make bulk
        // BUY WOOD BUTTON
        JButton buyWoodButton = new JButton();
        buyWoodButton.setPreferredSize(new Dimension(48, 48));
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gameState.getResources()[gameState.WOOD];
                gameState.buyResource(1, gameState.WOOD);
                if (gameState.getResources()[gameState.WOOD] != wereThisMany)
                {
                    writeInConsole("[PURCHASE] BOUGHT 1 WOOD");

                }
                else
                {
                    writeInConsole("[PURCHASE] WOOD PURCHASE FAILED");
                }

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
                int wereThisMany = gameState.getResources()[gameState.NAILS];
                gameState.buyResource(1, gameState.NAILS);
                if (gameState.getResources()[gameState.NAILS] != wereThisMany)
                {
                    writeInConsole("[PURCHASE] BOUGHT 1 NAIL");

                }
                else
                {
                    writeInConsole("[PURCHASE] NAIL PURCHASE FAILED");
                }
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
                int wereThisMany = gameState.getResources()[gameState.SCREWS];
                gameState.buyResource(1, gameState.SCREWS);
                if (gameState.getResources()[gameState.SCREWS] != wereThisMany)
                {
                    writeInConsole("[PURCHASE] BOUGHT 1 SCREW"); // TODO should be in bulk

                }
                else
                {
                    writeInConsole("[PURCHASE] SCREW PURCHASE FAILED");
                }

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
                int wereThisMany = gameState.getResources()[gameState.HARDBOARD];
                gameState.buyResource(1, gameState.HARDBOARD);
                if (gameState.getResources()[gameState.HARDBOARD] != wereThisMany)
                {
                    writeInConsole("[PURCHASE] BOUGHT 1 HARDBOARD");

                }
                else
                {
                    writeInConsole("[PURCHASE] HARDWOOD PURCHASE FAILED");
                }
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
                    writeInConsole("[STORE-PURCHASE] BOUGHT STORE SUCCESSFULLY." +
                                "\n  > CONGRATS PLAYER, YOU WON!");
                } else {
                    writeInConsole("[STORE-PURCHASE] FAILED TO BUY STORE");
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
                int wereThisMany = gameState.getNumPosters();
                gameState.putUpPoster();
                if (gameState.getNumPosters() != wereThisMany)
                {
                    writeInConsole("[ADVERTISEMENT] PUT UP ONE POSTER");

                }
                else
                {
                    writeInConsole("[ADVERTISEMENT] POSTER HANGING UNSUCCESSFUL");
                }
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
                    // also happens in the plain tick
                    gameState.setTicksActive(gameState.getTicksActive() + 1);
                    consoleText.setText("> (AUTO) NEW TICK [" + gameState.getTicksActive() + "]\n");
                    consoleText.append(gameState.tick());

                    updateGUI();
                }
            }
        }, 2000, 2000);
    }

    public void writeInConsole(String message) {
        consoleText.append("\n" + message);
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