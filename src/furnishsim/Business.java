package furnishsim;

import java.util.Random;

/**
 * AKA GAME STATE
 */
public class Business
{
    
    // RANDOM CHANCE MAKER ===
    private Random aiBehaviours = new Random();
    // =======================
    
    
    private String companyName;
    private double customerAttraction;
    private int money;
    private int profit; // TODO: -40 AT THE START.
    private int wood;
    final private int woodPrice = 2;
    private Furniture[] furnitures = {
            new Furniture("Stool", 0, 3, 10, true),
            new Furniture("Chair", 20, 10, 40, false)};
    private int ticksActive;
    private int customersInStore;

    public Business()
    {
        companyName = "Industrial Furniture Inc.";
        money = 40;
        wood = 0;
        ticksActive = 0;
        profit = 0;
        customerAttraction = 1.0;
    }

    public void tick()
    {
        // just update tick
        ticksActive++;
        
        // customer ai
        customersInStore++; // this is 100% enterance rate; will be reduced

        // will have to deal with when customer = 0;
        if (customersInStore > 0) {
            for (int customer = 1; customer <= customersInStore; customer++) {
               // checks stock
                if (findTotalStock() == 0) {
                    System.out.println("Customer [" + customer + "] unhappy --> left. Remaining customers: " + customersInStore);
                    customersInStore--;
                    customerAttraction -= 0.05;
                    break;
                } else {
                    // 30%
                    if (aiBehaviours.nextInt(1, 100) <= 30) {
                        // checks availibility in order; might randomize for realism later through random indexing [5-15min]
                        for (Furniture furniture : furnitures) {
                            if (furniture.getNumInStock() > 0) {
                                money += furniture.getSellingPrice();
                                profit += furniture.getSellingPrice();
                                furniture.setNumInStock(furniture.getNumInStock() - 1);
                                System.out.println(furniture.getFurnitureName() + " was bought! [ +" + furniture.getSellingPrice() + "$ | " + "- 1 unit ]");
                                customersInStore--;
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Customer [" + customer + "] just walking around.");
                    }
                }
            }
        }
        else
        {
            System.out.println("No customers in the store yet..");
        }
        

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

    public void makeFurniture(Furniture furniture)
    {
        if ((furniture.hasBlueprint()) && (wood >= furniture.getWoodCost()))
        {
            wood -= furniture.getWoodCost();
            furniture.setNumInStock(furniture.getNumInStock() + 1);
        }
    }


    public Furniture[] getFurnitures() {
        return furnitures;
    }

    public int findTotalStock()
    {
        int totalStock = 0;

        for (Furniture furniture : furnitures)
        {
            totalStock += furniture.getNumInStock();
        }

        return totalStock;
    }

    public String toString()
    {
        // all basic info
        String businessData = companyName.toUpperCase() + " | " + "MONEY: " + money + "$ | WOOD: " + wood + " | TICKS SINCE START: " + ticksActive + " | TOTAL STOCK: " + findTotalStock() + " | CUSTOMERS IN STORE: " + customersInStore + " | TOTAL PROFITS: " + profit + " | ";

        // stock
        for (Furniture furniture : furnitures)
        {
            businessData += (furniture.getFurnitureName().toUpperCase() + ": " + furniture.getNumInStock() + " | ");
        }

        return businessData;
    }
}
