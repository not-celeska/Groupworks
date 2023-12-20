package furnishsim;

/*
EXAMPLE BUTTON:

...initialize button...
...settings (icons, size)...
... set function (copy/paste)...
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class COORDINATELAYOUT
{
    static Business gamestate = new Business();

    /*
     * TEXT AREAS
     */

    static JTextArea posterText = new JTextArea();

    static JLabel stools = new JLabel();
    static JLabel chairs = new JLabel();

    static JLabel tables = new JLabel();

    static JLabel shelves = new JLabel();

    static JLabel mailboxes = new JLabel();
    static JLabel money = new JLabel();
    static JLabel popularity = new JLabel();
    static JLabel blueprints = new JLabel();
    static JLabel posters = new JLabel();
    static JLabel wood = new JLabel();
    static JLabel nails = new JLabel();
    static JLabel screws = new JLabel();
    static JLabel hardboard = new JLabel();
    static JTextArea consoleText = new JTextArea();
    static JLabel backgroundImg = new JLabel();




    /*
     * STATIC JBUTTONS
     */

    static JButton[] blueprintButtons = new JButton[] {new JButton(), new JButton(), new JButton(), new JButton(), new JButton()};

    static JButton[] workshopButtons = new JButton[] {new JButton(), new JButton(), new JButton(), new JButton(), new JButton()};

    static JButton buyPosterButton = new JButton();
    static JButton buyStoreButton = new JButton();
    static JButton timesOneButton = new JButton();
    static JButton timesTenButton = new JButton();
    static JButton buyWoodButton = new JButton();
    static JButton buyNailsButton = new JButton();
    static JButton buyHardboardButton = new JButton();
    static JButton buyScrewsButton = new JButton();




    public static void main(String[] args)
    {
        new COORDINATELAYOUT().makeUI();
    }

    public static void makeUI()
    {
        JFrame window = new JFrame();
        window.setSize(865, 639);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Create a JPanel with custom paintComponent method to draw the background
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load the background image
                ImageIcon backgroundImage = new ImageIcon("Resources/GUI.png");
                Image img = backgroundImage.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };


        // Set the layout of the background panel to null for absolute positioning
        backgroundPanel.setLayout(null);

        updateGUI();

        /*
         * BLUEPRINTS
         */

        // Stool
        blueprintButtons[gamestate.STOOLS].setBounds(35, 97, 48, 48);
        backgroundPanel.add(blueprintButtons[gamestate.STOOLS]);

        // Chair
        blueprintButtons[gamestate.CHAIRS].setBounds(35, 180, 48, 48);
        backgroundPanel.add(blueprintButtons[gamestate.CHAIRS]);

        // Table
        blueprintButtons[gamestate.TABLES].setBounds(35, 263, 48, 48);
        backgroundPanel.add(blueprintButtons[gamestate.TABLES]);

        // Wall Shelf
        blueprintButtons[gamestate.SHELVES].setBounds(122, 263, 48, 48);
        backgroundPanel.add(blueprintButtons[gamestate.SHELVES]);

        // Mailbox
        blueprintButtons[gamestate.MAILBOXES].setBounds(205, 263, 48, 48);
        backgroundPanel.add(blueprintButtons[gamestate.MAILBOXES]);



        /*
         * MISC
         */

        // Poster
        buyPosterButton.setIcon(new ImageIcon("furnishResources/POSTER.png"));
        buyPosterButton.setRolloverIcon(new ImageIcon("furnishResources/POSTER_HOVER.png"));
        buyPosterButton.setPressedIcon(new ImageIcon("furnishResources/POSTER_PRESSED.png"));
        buyPosterButton.setBounds(36, 414, 64, 80);
        backgroundPanel.add(buyPosterButton);

        // Store
        buyStoreButton.setIcon(new ImageIcon("furnishResources/STORE.png"));
        buyStoreButton.setRolloverIcon(new ImageIcon("furnishResources/STORE_HOVER.png"));
        buyStoreButton.setPressedIcon(new ImageIcon("furnishResources/STORE_BOUGHT_2.png"));
        buyStoreButton.setDisabledIcon(new ImageIcon("furnishResources/STORE_BOUGHT.png"));
        buyStoreButton.setBounds(314, 36, 144, 48);
        backgroundPanel.add(buyStoreButton);

        // *1 button
        timesOneButton.setIcon(new ImageIcon("furnishResources/1.png"));
        timesOneButton.setRolloverIcon(new ImageIcon("furnishResources/1_HOVER.png"));
        timesOneButton.setPressedIcon(new ImageIcon("furnishResources/1_CLICK.png"));
        timesOneButton.setBounds(272, 97, 16, 48);
        backgroundPanel.add(timesOneButton);

        // *10 button
        timesTenButton.setIcon(new ImageIcon("furnishResources/10.png"));
        timesTenButton.setRolloverIcon(new ImageIcon("furnishResources/10_HOVER.png"));
        timesTenButton.setPressedIcon(new ImageIcon("furnishResources/10_CLICK.png"));
        timesTenButton.setBounds(272, 180, 16, 48);
        backgroundPanel.add(timesTenButton);


        /*
         * MATERIALS
         */

        // wood
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.setBounds(122, 97, 48, 48);
        backgroundPanel.add(buyWoodButton);

        // nails
        buyNailsButton.setIcon(new ImageIcon("furnishResources/NAIL.png"));
        buyNailsButton.setRolloverIcon(new ImageIcon("furnishResources/NAIL_HOVER.png"));
        buyNailsButton.setPressedIcon(new ImageIcon("furnishResources/NAIL_PRESSED.png"));
        buyNailsButton.setBounds(205, 97, 48, 48);
        backgroundPanel.add(buyNailsButton);

        // hardboard
        buyHardboardButton.setIcon(new ImageIcon("furnishResources/HARDWOOD.png")); // cannot be bothered to change the filename
        buyHardboardButton.setRolloverIcon(new ImageIcon("furnishResources/HARDWOOD_HOVER.png"));
        buyHardboardButton.setPressedIcon(new ImageIcon("furnishResources/HARDWOOD_PRESSED.png"));
        buyHardboardButton.setBounds(122, 180, 48, 48);
        backgroundPanel.add(buyHardboardButton);

        // screws
        buyScrewsButton.setIcon(new ImageIcon("furnishResources/SCREWS.png")); // cannot be bothered to change the filename
        buyScrewsButton.setRolloverIcon(new ImageIcon("furnishResources/SCREWS_HOVER.png"));
        buyScrewsButton.setPressedIcon(new ImageIcon("furnishResources/SCREWS_PRESSED.png"));
        buyScrewsButton.setBounds(205, 180, 48, 48);
        backgroundPanel.add(buyScrewsButton);

        /*
         * FURNITURE BUYING
         */

        // Stool
        workshopButtons[0].setBounds(327, 185, 48, 48);
        backgroundPanel.add(workshopButtons[0]);

        // Chair
        workshopButtons[1].setBounds(327, 268, 48, 48);
        backgroundPanel.add(workshopButtons[1]);

        // Table
        workshopButtons[2].setBounds(327, 351, 48, 48);
        backgroundPanel.add(workshopButtons[2]);

        // Wall Shelf
        workshopButtons[3].setBounds(327, 434, 48, 48);
        backgroundPanel.add(workshopButtons[3]);

        // Mailbox
        workshopButtons[4].setBounds(327, 517, 48, 48);
        backgroundPanel.add(workshopButtons[4]);

        /*
         * DRAW TEXT TO SCREEN
         */

        posterText.setBounds(122, 414, 100, 50); // x, y, width, height
        posterText.setEditable(false);
        posterText.setFont(new Font("Monospaced", Font.BOLD, 14));
        posterText.setForeground(Color.black);
        backgroundPanel.add(posterText);


        stools.setBounds(327, 230, 100, 30); // x, y, width, height
        backgroundPanel.add(stools);

        chairs.setBounds(327, 308, 100, 30); // x, y, width, height
        backgroundPanel.add(chairs);

        tables.setBounds(327, 405, 100, 30); // x, y, width, height
        backgroundPanel.add(tables);

        shelves.setBounds(327, 474, 100, 30); // x, y, width, height
        backgroundPanel.add(shelves);

        mailboxes.setBounds(327, 557, 100, 30); // x, y, width, height
        backgroundPanel.add(mailboxes);

        money.setBounds(54, 525, 75, 30); // x, y, width, height
        backgroundPanel.add(money);

        popularity.setBounds(90, 540, 100, 30); // x, y, width, height
        backgroundPanel.add(popularity);

        blueprints.setBounds(145, 555, 100, 30); // x, y, width, height
        backgroundPanel.add(blueprints);

        posters.setBounds(106, 570, 30, 30); // x, y, width, height
        backgroundPanel.add(posters);

        wood.setBounds(210, 525, 100, 30); // x, y, width, height
        backgroundPanel.add(wood);

        nails.setBounds(225, 540, 100, 30); // x, y, width, height
        backgroundPanel.add(nails);

        screws.setBounds(211, 555, 100, 30); // x, y, width, height
        backgroundPanel.add(screws);

        hardboard.setBounds(250, 570, 100, 30); // x, y, width, height
        backgroundPanel.add(hardboard);


        /*
         * GUI THAT COVERS THE CONSOLE
         */

        // background
        JLabel consoleCover = new JLabel();
        consoleCover.setIcon(new ImageIcon("furnishResources/CONSOLE_COVER.png"));
        consoleCover.setBounds(483, 274, 366, 51);
        backgroundPanel.add(consoleCover);

        backgroundImg.setBounds(483, 0, 366, 274);

        backgroundPanel.add(backgroundImg);

        JButton tickButton = new JButton("TICK");
        tickButton.setBounds(490, 289, 75, 20);
        backgroundPanel.add(tickButton);

        JButton autoTickerToggle = new JButton("AUTO");
        autoTickerToggle.setBounds(767, 289, 75, 20);
        backgroundPanel.add(autoTickerToggle);

        /*
         * IMPORTANT: DRAW THE CONSOLE AFTER THIS
         */
        consoleText.setBackground(Color.white);
        consoleText.setFont(new Font("Monospaced", Font.BOLD, 14));
        consoleText.setForeground(Color.black);
        consoleText.setEditable(false);
        consoleText.setBounds(483, 325, 377, 275);
        backgroundPanel.add(consoleText);

//         consoleCover.setBounds(483, 274, 366, 51);


        // Add the background panel to the JFrame
        window.add(backgroundPanel);
        window.setVisible(true);

        ButtonListeners();
    }

    public static void ButtonListeners() {
        /*
         * For loops for buying blueprints and building things
         */

        for (int i = 0; i < workshopButtons.length; i++) {
            Furniture furniture = gamestate.getFurnitures()[i];
            int furNum = i;

            workshopButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int wereThisMany = furniture.getNumInStock();
                    gamestate.makeFurniture(furniture);
                    if (furniture.getNumInStock() > wereThisMany) {
                        writeInConsole("[MADE] 1 " + furniture.getFurnitureName().toUpperCase());
                    } else {
                        writeInConsole("[MADE] " + furniture.getFurnitureName().toUpperCase() + ": BUILD UNSUCCESSFUL");
                    }

                    updateGUI();

                    gamestate.getFurnitures()[furNum].setNumInStock(furniture.getNumInStock());
                }
            });
        }
        for (int i = 0; i < blueprintButtons.length; i++) {
            Furniture furniture = gamestate.getFurnitures()[i];
            int furNum = i;

            blueprintButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gamestate.buyBlueprint(furniture);
                    if (furniture.hasBlueprint()) {
                        writeInConsole("[BLUEPRINT] BOUGHT " + furniture.getFurnitureName().toUpperCase() + " SUCCESSFULLY");
                    } else {
                        writeInConsole("[BLUEPRINT] FAILED TO BUY " + furniture.getFurnitureName().toUpperCase());
                    }
                    updateGUI();

                    gamestate.getFurnitures()[furNum] = furniture;
                }
            });
        }





        /*
         * Material Purchases
         */

        /*
         * MISC BUTTONS
         */
        buyPosterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gamestate.getNumPosters();
                gamestate.putUpPoster();
                if (gamestate.getNumPosters() != wereThisMany)
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
        buyStoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                gamestate.buyStore();
                if (gamestate.isBoughtStore()) {
                    buyStoreButton.setEnabled(false);
                    writeInConsole("[STORE-PURCHASE] BOUGHT STORE SUCCESSFULLY." +
                            "\n  > CONGRATS PLAYER, YOU WON!");
                } else {
                    writeInConsole("[STORE-PURCHASE] FAILED TO BUY STORE");
                }
                updateGUI();
            }
        });
        buyWoodButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gamestate.getResources()[gamestate.WOOD];
                gamestate.buyResource(1, gamestate.WOOD);
                if (gamestate.getResources()[gamestate.WOOD] != wereThisMany)
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
        buyNailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gamestate.getResources()[gamestate.NAILS];
                gamestate.buyResource(1, gamestate.NAILS);
                if (gamestate.getResources()[gamestate.NAILS] != wereThisMany)
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
        buyScrewsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gamestate.getResources()[gamestate.SCREWS];
                gamestate.buyResource(1, gamestate.SCREWS);
                if (gamestate.getResources()[gamestate.SCREWS] != wereThisMany)
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
        buyHardboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int wereThisMany = gamestate.getResources()[gamestate.HARDBOARD];
                gamestate.buyResource(1, gamestate.HARDBOARD);
                if (gamestate.getResources()[gamestate.HARDBOARD] != wereThisMany)
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
    }

    public static void updateGUI() {
        posterText.setText("$" + gamestate.getPosterCost() + ":\nPut up poster");
        stools.setText(String.valueOf(gamestate.getFurnitures()[gamestate.STOOLS].getNumInStock()) + " owned");
        chairs.setText(String.valueOf(gamestate.getFurnitures()[gamestate.CHAIRS].getNumInStock()) + " owned");
        tables.setText(String.valueOf(gamestate.getFurnitures()[gamestate.TABLES].getNumInStock()) + " owned");
        shelves.setText(String.valueOf(gamestate.getFurnitures()[gamestate.SHELVES].getNumInStock()) + " owned");
        mailboxes.setText(String.valueOf(gamestate.getFurnitures()[gamestate.MAILBOXES].getNumInStock()) + " owned");
        popularity.setText(String.valueOf(gamestate.getCustomerAttraction()));
        money.setText(String.valueOf("$" + gamestate.getMoney()));
        blueprints.setText(String.valueOf(gamestate.getBlueprintsUnlocked()));
        posters.setText(String.valueOf(gamestate.getNumPosters()));
        wood.setText(String.valueOf(gamestate.getResources()[gamestate.WOOD]));
        nails.setText(String.valueOf(gamestate.getResources()[gamestate.NAILS]));
        screws.setText(String.valueOf(gamestate.getResources()[gamestate.SCREWS]));
        hardboard.setText(String.valueOf(gamestate.getResources()[gamestate.HARDBOARD]));

        /*
         * ICON CHANGES (FOR BLUEPRINTS AND BUILDING)
         */
        for (int i = 0; i < blueprintButtons.length; i++) {
            Furniture furniture = gamestate.getFurnitures()[i];
            JButton button = blueprintButtons[i];

            if (furniture.hasBlueprint()) {
                button.setDisabledIcon(new ImageIcon("furnishResources/BOUGHT.png"));
                button.setEnabled(false);
            }
            else {
                button.setIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + ".png"));
                button.setRolloverIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + "_HOVER.png"));
                button.setPressedIcon(new ImageIcon("furnishResources/" + gamestate.getFurnitures()[i].getFurnitureName().toUpperCase() + "_PRESSED.png"));
            }
        }

        for (int i = 0; i < workshopButtons.length; i++) {
            JButton button = workshopButtons[i];
            Furniture furniture = gamestate.getFurnitures()[i];

            button.setIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + ".png"));
            button.setRolloverIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + "_HOVER.png"));
            button.setPressedIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + "_PRESSED.png"));

            if (! gamestate.getFurnitures()[i].hasBlueprint()) {
                button.setDisabledIcon(new ImageIcon("furnishResources/NO_BLUEPRINT.png"));
                button.setEnabled(false);
            }
            else {
                button.setEnabled(true);
                button.setIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + ".png"));
                button.setRolloverIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + "_HOVER.png"));
                button.setPressedIcon(new ImageIcon("furnishResources/" + furniture.getFurnitureName().toUpperCase() + "_PRESSED.png"));
            }
        }
        if (gamestate.isBoughtStore()) {
            backgroundImg.setIcon(new ImageIcon("furnishResources/STOREBG.png"));
        } else {
            backgroundImg.setIcon(new ImageIcon("furnishResources/WORKSHOP.png"));
        }








    }
    public static void writeInConsole(String msg) {
        consoleText.append(msg + "\n");
    }

}
