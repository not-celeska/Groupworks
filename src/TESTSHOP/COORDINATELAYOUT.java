package TESTSHOP;

/*
EXAMPLE BUTTON:

...initialize button...
...settings (icons, size)...
... set function (copy/paste)...
 */


import javax.swing.*;
import java.awt.*;

public class COORDINATELAYOUT
{
    public static void main(String[] args)
    {
        new COORDINATELAYOUT().makeUI();
    }

    public void makeUI()
    {
        JFrame window = new JFrame();
        window.setSize(850, 600);
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

        /*
         * BLUEPRINTS
         */

        // Stool
        JButton buyStoolButton = new JButton();
        buyStoolButton.setIcon(new ImageIcon("furnishResources/STOOL.png"));
        buyStoolButton.setRolloverIcon(new ImageIcon("furnishResources/STOOL_HOVER.png"));
        buyStoolButton.setPressedIcon(new ImageIcon("furnishResources/STOOL_PRESSED.png"));
        buyStoolButton.setBounds(35, 97, 48, 48);
        backgroundPanel.add(buyStoolButton);

        // Chair
        JButton buyChairButton = new JButton();
        buyChairButton.setIcon(new ImageIcon("furnishResources/CHAIR.png"));
        buyChairButton.setRolloverIcon(new ImageIcon("furnishResources/CHAIR_HOVER.png"));
        buyChairButton.setPressedIcon(new ImageIcon("furnishResources/CHAIR_PRESSED.png"));
        buyChairButton.setBounds(35, 180, 48, 48);
        backgroundPanel.add(buyChairButton);

        // Table
        JButton buyTableButton = new JButton();
        buyTableButton.setIcon(new ImageIcon("furnishResources/TABLE.png"));
        buyTableButton.setRolloverIcon(new ImageIcon("furnishResources/TABLE_HOVER.png"));
        buyTableButton.setPressedIcon(new ImageIcon("furnishResources/TABLE_PRESSED.png"));
        buyTableButton.setBounds(35, 263, 48, 48);
        backgroundPanel.add(buyTableButton);

        // Wall Shelf
        JButton buyShelfButton = new JButton();
        buyShelfButton.setIcon(new ImageIcon("furnishResources/SHELF.png"));
        buyShelfButton.setRolloverIcon(new ImageIcon("furnishResources/SHELF_HOVER.png"));
        buyShelfButton.setPressedIcon(new ImageIcon("furnishResources/SHELF_PRESSED.png"));
        buyShelfButton.setBounds(122, 263, 48, 48);
        backgroundPanel.add(buyShelfButton);

        // Mailbox
        JButton buyMailboxButton = new JButton();
        buyMailboxButton.setIcon(new ImageIcon("furnishResources/MAILBOX.png"));
        buyMailboxButton.setRolloverIcon(new ImageIcon("furnishResources/MAILBOX_HOVER.png"));
        buyMailboxButton.setPressedIcon(new ImageIcon("furnishResources/MAILBOX_PRESSED.png"));
        buyMailboxButton.setBounds(205, 263, 48, 48);
        backgroundPanel.add(buyMailboxButton);



        /*
         * MISC
         */

        // Poster
        JButton buyPosterButton = new JButton();
        buyPosterButton.setIcon(new ImageIcon("furnishResources/POSTER.png"));
        buyPosterButton.setRolloverIcon(new ImageIcon("furnishResources/POSTER_HOVER.png"));
        buyPosterButton.setPressedIcon(new ImageIcon("furnishResources/POSTER_PRESSED.png"));
        buyPosterButton.setBounds(35, 414, 64, 80);
        backgroundPanel.add(buyPosterButton);

        // Store
        JButton buyStoreButton = new JButton();
        buyStoreButton.setIcon(new ImageIcon("furnishResources/STORE.png"));
        buyStoreButton.setRolloverIcon(new ImageIcon("furnishResources/STORE_HOVER.png"));
        buyStoreButton.setPressedIcon(new ImageIcon("furnishResources/STORE_BOUGHT_2.png"));
        buyStoreButton.setBounds(314, 36, 144, 48);
        backgroundPanel.add(buyStoreButton);

        // *1 button
        JButton timesOneButton = new JButton();
        timesOneButton.setIcon(new ImageIcon("furnishResources/1.png"));
        timesOneButton.setRolloverIcon(new ImageIcon("furnishResources/1_HOVER.png"));
        timesOneButton.setPressedIcon(new ImageIcon("furnishResources/1_CLICK.png"));
        timesOneButton.setBounds(272, 97, 16, 48);
        backgroundPanel.add(timesOneButton);

        // *10 button
        JButton timesTenButton = new JButton();
        timesTenButton.setIcon(new ImageIcon("furnishResources/10.png"));
        timesTenButton.setRolloverIcon(new ImageIcon("furnishResources/10_HOVER.png"));
        timesTenButton.setPressedIcon(new ImageIcon("furnishResources/10_CLICK.png"));
        timesTenButton.setBounds(272, 180, 16, 48);
        backgroundPanel.add(timesTenButton);


        /*
         * MATERIALS
         */

        // wood
        JButton buyWoodButton = new JButton();
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.setBounds(122, 97, 48, 48);
        backgroundPanel.add(buyWoodButton);

        // nails
        JButton buyNailsButton = new JButton();
        buyNailsButton.setIcon(new ImageIcon("furnishResources/NAIL.png"));
        buyNailsButton.setRolloverIcon(new ImageIcon("furnishResources/NAIL_HOVER.png"));
        buyNailsButton.setPressedIcon(new ImageIcon("furnishResources/NAIL_PRESSED.png"));
        buyNailsButton.setBounds(205, 97, 48, 48);
        backgroundPanel.add(buyNailsButton);

        // hardboard
        JButton buyHardBoardButton = new JButton();
        buyHardBoardButton.setIcon(new ImageIcon("furnishResources/HARDWOOD.png")); // cannot be bothered to change the filename
        buyHardBoardButton.setRolloverIcon(new ImageIcon("furnishResources/HARDWOOD_HOVER.png"));
        buyHardBoardButton.setPressedIcon(new ImageIcon("furnishResources/HARDWOOD_PRESSED.png"));
        buyHardBoardButton.setBounds(122, 180, 48, 48);
        backgroundPanel.add(buyHardBoardButton);

        // screws
        JButton buyScrewsButton = new JButton();
        buyScrewsButton.setIcon(new ImageIcon("furnishResources/SCREWS.png")); // cannot be bothered to change the filename
        buyScrewsButton.setRolloverIcon(new ImageIcon("furnishResources/SCREWS_HOVER.png"));
        buyScrewsButton.setPressedIcon(new ImageIcon("furnishResources/SCREWS_PRESSED.png"));
        buyScrewsButton.setBounds(205, 180, 48, 48);
        backgroundPanel.add(buyScrewsButton);

        /*
         * FURNITURE BUYING
         */

        // Stool
        JButton buyStoolButton2 = new JButton();
        buyStoolButton2.setIcon(new ImageIcon("furnishResources/STOOL.png"));
        buyStoolButton2.setRolloverIcon(new ImageIcon("furnishResources/STOOL_HOVER.png"));
        buyStoolButton2.setPressedIcon(new ImageIcon("furnishResources/STOOL_PRESSED.png"));
        buyStoolButton2.setBounds(327, 185, 48, 48);
        backgroundPanel.add(buyStoolButton2);

        // Chair
        JButton buyChairButton2 = new JButton();
        buyChairButton2.setPreferredSize(new Dimension(48, 48));
        buyChairButton2.setIcon(new ImageIcon("furnishResources/CHAIR.png"));
        buyChairButton2.setRolloverIcon(new ImageIcon("furnishResources/CHAIR_HOVER.png"));
        buyChairButton2.setPressedIcon(new ImageIcon("furnishResources/CHAIR_PRESSED.png"));
        buyChairButton2.setBounds(327, 268, 48, 48);
        backgroundPanel.add(buyChairButton2);

        // Table
        JButton buyTableButton2 = new JButton();
        buyTableButton2.setIcon(new ImageIcon("furnishResources/TABLE.png"));
        buyTableButton2.setRolloverIcon(new ImageIcon("furnishResources/TABLE_HOVER.png"));
        buyTableButton2.setPressedIcon(new ImageIcon("furnishResources/TABLE_PRESSED.png"));
        buyTableButton2.setBounds(327, 351, 48, 48);
        backgroundPanel.add(buyTableButton2);

        // Wall Shelf
        JButton buyShelfButton2 = new JButton();
        buyShelfButton2.setIcon(new ImageIcon("furnishResources/SHELF.png"));
        buyShelfButton2.setRolloverIcon(new ImageIcon("furnishResources/SHELF_HOVER.png"));
        buyShelfButton2.setPressedIcon(new ImageIcon("furnishResources/SHELF_PRESSED.png"));
        buyShelfButton2.setBounds(327, 434, 48, 48);
        backgroundPanel.add(buyShelfButton2);

        // Mailbox
        JButton buyMailboxButton2 = new JButton();
        buyMailboxButton2.setIcon(new ImageIcon("furnishResources/MAILBOX.png"));
        buyMailboxButton2.setRolloverIcon(new ImageIcon("furnishResources/MAILBOX_HOVER.png"));
        buyMailboxButton2.setPressedIcon(new ImageIcon("furnishResources/MAILBOX_PRESSED.png"));
        buyMailboxButton2.setBounds(327, 517, 48, 48);
        backgroundPanel.add(buyMailboxButton2);


        JLabel money = new JLabel("$XX.XX");
        money.setBounds(54, 525, 100, 30); // x, y, width, height
        backgroundPanel.add(money);

        JLabel popularity = new JLabel("X.XX");
        popularity.setBounds(85, 540, 100, 30); // x, y, width, height
        backgroundPanel.add(popularity);

        JLabel blueprints = new JLabel("X");
        blueprints.setBounds(145, 555, 100, 30); // x, y, width, height
        backgroundPanel.add(blueprints);

        JLabel posters = new JLabel("XX");
        posters.setBounds(106, 570, 100, 30); // x, y, width, height
        backgroundPanel.add(posters);

        JLabel wood = new JLabel("XXX");
        wood.setBounds(210, 525, 100, 30); // x, y, width, height
        backgroundPanel.add(wood);

        JLabel nails = new JLabel("XXX");
        nails.setBounds(225, 540, 100, 30); // x, y, width, height
        backgroundPanel.add(nails);

        JLabel screws = new JLabel("XXX");
        screws.setBounds(211, 555, 100, 30); // x, y, width, height
        backgroundPanel.add(screws);

        JLabel hardboard = new JLabel("XXX");
        hardboard.setBounds(250, 570, 100, 30); // x, y, width, height
        backgroundPanel.add(hardboard);


        /*
         * MISC TEXT
         */

        JLabel poster = new JLabel("Funny poster dialog");
        poster.setBounds(122, 414, 100, 30); // x, y, width, height
        backgroundPanel.add(poster);

        JLabel stools = new JLabel("XXX Owned");
        stools.setBounds(327, 230, 100, 30); // x, y, width, height
        backgroundPanel.add(stools);

        JLabel chairs = new JLabel("XXX Owned");
        chairs.setBounds(327, 308, 100, 30); // x, y, width, height
        backgroundPanel.add(chairs);

        JLabel tables = new JLabel("XXX Owned");
        tables.setBounds(327, 405, 100, 30); // x, y, width, height
        backgroundPanel.add(tables);

        JLabel shelves = new JLabel("XXX Owned");
        shelves.setBounds(327, 474, 100, 30); // x, y, width, height
        backgroundPanel.add(shelves);

        JLabel mailboxes = new JLabel("XXX Owned");
        mailboxes.setBounds(327, 557, 100, 30); // x, y, width, height
        backgroundPanel.add(mailboxes);

        /*
         * GUI THAT COVERS THE CONSOLE
         */

        // background
        JLabel consoleCover = new JLabel();
        consoleCover.setIcon(new ImageIcon("furnishResources/CONSOLE_COVER.png"));
        consoleCover.setBounds(483, 274, 366, 51);
        backgroundPanel.add(consoleCover);

        JLabel backgroundImg = new JLabel();
        backgroundImg.setIcon(new ImageIcon("furnishResources/WORKSHOP.png"));
        backgroundImg.setBounds(483, 0, 366, 274);

        JLabel backgroundImg2 = new JLabel();
        backgroundImg2.setIcon(new ImageIcon("furnishResources/STOREBG.png"));
        backgroundImg2.setBounds(483, 0, 366, 274);

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
        JTextArea consoleText = new JTextArea();
        consoleText.setBackground(Color.black);
        consoleText.setFont(new Font("Monospaced", Font.BOLD, 14));
        consoleText.setForeground(Color.green);
        consoleText.append("Updates will go here");
        consoleText.setEditable(false);
        consoleText.setBounds(483, 325, 377, 275);
        backgroundPanel.add(consoleText);

//         consoleCover.setBounds(483, 274, 366, 51);


        // Add the background panel to the JFrame
        window.add(backgroundPanel);
        window.setVisible(true);
    }
}
