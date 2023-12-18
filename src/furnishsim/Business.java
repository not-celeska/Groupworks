package furnishsim;

/**
 * AKA GAME STATE
 */
public class Business
{
    private String companyName;
    private int money;
    private int wood;
    private int woodPrice = 2;
    private Furniture[] furnitures = {
            new Furniture("Stool", 0, 3, 10, true),
            new Furniture("Chair", 20, 10, 40, false)};
    private int ticksActive;


    public Business()
    {
        companyName = "Industrial Furniture Inc.";
        money = 50;
        wood = 0;
        ticksActive = 0;
    }

    public void tick()
    {
        ticksActive++;

        /*
        this will be called from gui; kind of like an "update" method
        updates values per tick like
        - customers entering
        - events (robberies, discounts, etc) <-- random events
        - sales
        - updates time spent?
         */
    }


    // ========================
    public void buyWood(int quantity)
    {
        // price = 2$
        if (money >= (woodPrice * quantity))
        {
            money -= (woodPrice * quantity);
            wood += quantity;
        }
    }



    public String toString()
    {
        return (companyName.toUpperCase() + " | " + "MONEY: " + money + "$ | WOOD: " + wood + " | TICKS SINCE START: " + ticksActive + " | ");
    }
}
