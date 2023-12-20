package TESTSHOP;

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

        /*
         * BLUEPRINTS
         */

        // Stool
        JButton buyStoolButton = new JButton();
        buyStoolButton.setPreferredSize(new Dimension(48, 48));
        buyStoolButton.setIcon(new ImageIcon("furnishResources/STOOL.png"));
        buyStoolButton.setRolloverIcon(new ImageIcon("furnishResources/STOOL_HOVER.png"));
        buyStoolButton.setPressedIcon(new ImageIcon("furnishResources/STOOL_PRESSED.png"));
        buyStoolButton.setBounds(35, 97, 48, 48);
        backgroundPanel.add(buyStoolButton);

        // Chair
        JButton buyChairButton = new JButton();
        buyChairButton.setPreferredSize(new Dimension(48, 48));
        buyChairButton.setIcon(new ImageIcon("furnishResources/CHAIR.png"));
        buyChairButton.setRolloverIcon(new ImageIcon("furnishResources/CHAIR_HOVER.png"));
        buyChairButton.setPressedIcon(new ImageIcon("furnishResources/CHAIR_PRESSED.png"));
        buyChairButton.setBounds(35, 180, 48, 48);
        backgroundPanel.add(buyChairButton);

        // Table
        JButton buyTableButton = new JButton();
        buyTableButton.setPreferredSize(new Dimension(48, 48));
        buyTableButton.setIcon(new ImageIcon("furnishResources/TABLE.png"));
        buyTableButton.setRolloverIcon(new ImageIcon("furnishResources/TABLE_HOVER.png"));
        buyTableButton.setPressedIcon(new ImageIcon("furnishResources/TABLE_PRESSED.png"));
        buyTableButton.setBounds(35, 263, 48, 48);
        backgroundPanel.add(buyTableButton);

        // Wall Shelf
        JButton buyShelfButton = new JButton();
        buyShelfButton.setPreferredSize(new Dimension(48, 48));
        buyShelfButton.setIcon(new ImageIcon("furnishResources/SHELF.png"));
        buyShelfButton.setRolloverIcon(new ImageIcon("furnishResources/SHELF_HOVER.png"));
        buyShelfButton.setPressedIcon(new ImageIcon("furnishResources/SHELF_PRESSED.png"));
        buyShelfButton.setBounds(122, 263, 48, 48);
        backgroundPanel.add(buyShelfButton);

        // Mailbox
        JButton buyMailboxButton = new JButton();
        buyMailboxButton.setPreferredSize(new Dimension(48, 48));
        buyMailboxButton.setIcon(new ImageIcon("furnishResources/MAILBOX.png"));
        buyMailboxButton.setRolloverIcon(new ImageIcon("furnishResources/MAILBOX_HOVER.png"));
        buyMailboxButton.setPressedIcon(new ImageIcon("furnishResources/MAILBOX_PRESSED.png"));
        buyMailboxButton.setBounds(205, 263, 48, 48);
        backgroundPanel.add(buyMailboxButton);


        /*
         * MATERIALS
         */

        // wood
        JButton buyWoodButton = new JButton();
        buyWoodButton.setPreferredSize(new Dimension(48, 48));
        buyWoodButton.setIcon(new ImageIcon("furnishResources/WOOD.png"));
        buyWoodButton.setRolloverIcon(new ImageIcon("furnishResources/WOOD_HOVER.png"));
        buyWoodButton.setPressedIcon(new ImageIcon("furnishResources/WOOD_PRESSED.png"));
        buyWoodButton.setBounds(122, 97, 48, 48);
        backgroundPanel.add(buyWoodButton);

        // nails
        JButton buyNailsButton = new JButton();
        buyNailsButton.setPreferredSize(new Dimension(48, 48));
        buyNailsButton.setIcon(new ImageIcon("furnishResources/NAIL.png"));
        buyNailsButton.setRolloverIcon(new ImageIcon("furnishResources/NAIL_HOVER.png"));
        buyNailsButton.setPressedIcon(new ImageIcon("furnishResources/NAIL_PRESSED.png"));
        buyNailsButton.setBounds(205, 97, 48, 48);
        backgroundPanel.add(buyNailsButton);

        // hardboard
        JButton buyHardBoardButton = new JButton();
        buyHardBoardButton.setPreferredSize(new Dimension(48, 48));
        buyHardBoardButton.setIcon(new ImageIcon("furnishResources/HARDWOOD.png")); // cannot be bothered to change the filename
        buyHardBoardButton.setRolloverIcon(new ImageIcon("furnishResources/HARDWOOD_HOVER.png"));
        buyHardBoardButton.setPressedIcon(new ImageIcon("furnishResources/HARDWOOD_PRESSED.png"));
        buyHardBoardButton.setBounds(122, 180, 48, 48);
        backgroundPanel.add(buyHardBoardButton);

        // screws
        JButton buyScrewsButton = new JButton();
        buyScrewsButton.setPreferredSize(new Dimension(48, 48));
        buyScrewsButton.setIcon(new ImageIcon("furnishResources/SCREWS.png")); // cannot be bothered to change the filename
        buyScrewsButton.setRolloverIcon(new ImageIcon("furnishResources/SCREWS_HOVER.png"));
        buyScrewsButton.setPressedIcon(new ImageIcon("furnishResources/SCREWS_PRESSED.png"));
        buyScrewsButton.setBounds(205, 180, 48, 48);
        backgroundPanel.add(buyScrewsButton);

        JLabel money = new JLabel("150$");
        money.setBounds(54, 523, 100, 30); // x, y, width, height
        backgroundPanel.add(money);

        // Add the background panel to the JFrame
        window.add(backgroundPanel);
        window.setVisible(true);
    }
}
