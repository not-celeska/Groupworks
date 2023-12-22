import javax.swing.*;

// FURNITURE CLASS: Used for making furniture objects.
public class Furniture
{
    // BASIC INFORMATION
    private String furnitureName;
    private double blueprintCost;
    private int[] resourceCost;
    private double sellingPrice;

    // STATUS VARIABLE
    private boolean hasBlueprint;
    private int numInStock;

    // ICON IMAGES FOR BUTTONS
    private ImageIcon icon;
    private ImageIcon hoverIcon;
    private ImageIcon clickIcon;

    // ========================================

    public Furniture(String furnitureName, double blueprintCost, int[] resourceCost, double sellingPrice, boolean hasBlueprint, String iconFilepath, String hoverIconFilepath, String clickIconFilepath) {

        // LOGISTICS
        this.furnitureName = furnitureName;
        this.blueprintCost = blueprintCost;
        this.resourceCost = resourceCost;
        this.sellingPrice = sellingPrice;
        this.hasBlueprint = hasBlueprint;
        numInStock = 0;

        // VISUALS
        icon = new ImageIcon(iconFilepath);
        hoverIcon = new ImageIcon(hoverIconFilepath);
        clickIcon = new ImageIcon(clickIconFilepath);

    }

    // ========================================

    public String getFurnitureName() {
        return furnitureName;
    }

    public double getBlueprintCost() {
        return blueprintCost;
    }

    public int[] getResourceCost() {
        return resourceCost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public ImageIcon getHoverIcon() {
        return hoverIcon;
    }

    public ImageIcon getClickIcon() {
        return clickIcon;
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

    public void setNumInStock(int numInStock) {
        this.numInStock = numInStock;
    }

}