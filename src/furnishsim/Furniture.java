package furnishsim;

import javax.swing.*;

public class Furniture
{
    // BASIC INFORMATION
    private String furnitureName; // name of the furniture item: stool, chair, etc.
    private int blueprintCost;
    private int woodCost; // wood needed to build
    private int sellingPrice;

    // STATUS VARIABLE
    private boolean hasBlueprint;
    private int numInStock; // simulation wont sell if this is 0; adds 1 every time made.

    // ICON IMAGES FOR BUTTONS
    private ImageIcon dontHaveBlueprint; // disabledIcon
    private ImageIcon haveBlueprint;
    private ImageIcon makeFurniture;


    // ========================================

    public Furniture(String furnitureName, int blueprintCost, int woodCost, int sellingPrice, boolean hasBlueprint) {

        // LOGISTICS
        this.furnitureName = furnitureName;
        this.blueprintCost = blueprintCost;
        this.woodCost = woodCost;
        this.sellingPrice = sellingPrice;
        this.hasBlueprint = hasBlueprint;
        numInStock = 0;

        // VISUALS

    }

    // ========================================

    public String getFurnitureName() {
        return furnitureName;
    }

    public int getBlueprintCost() {
        return blueprintCost;
    }

    public int getWoodCost() {
        return woodCost;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public boolean hasBlueprint() {
        return hasBlueprint;
    }

    public void setHasBlueprint(boolean hasBlueprint)
    {
        this.hasBlueprint = hasBlueprint;
    }


    public int getNumInStock() {
        return numInStock;
    }

    // sell and buy method void

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }
}
