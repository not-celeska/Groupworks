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
    final private int WOOD_PRICE = 2;
    private Furniture[] furnitures = {
            new Furniture("Stool", 0, 3, 10, true),
            new Furniture("Chair", 20, 10, 40, false)};
    private int ticksActive;
    private int customersInStore;
    private int enterPercentage; // <-- will change based off stage
    private int numberOfPosters;
    final private int POSTER_PRICE = 150; // TODO: price changes based off of numberOfPosters.

    public Business()
    {
        companyName = "Industrial Furniture Inc.";
        money = 1500;
        wood = 0;
        ticksActive = 0;
        profit = 0;
        enterPercentage = 70; // TODO will change based off stage
        customerAttraction = 1.0;
        numberOfPosters = 0;
    }

    public void tick()
    {
        // just update tick
        ticksActive++;
        runCustomerAI();
        

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
        if (money >= (WOOD_PRICE * quantity))
        {
            money -= (WOOD_PRICE * quantity);
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

    public void buyBlueprint(Furniture furniture)
    {
        if (money >= furniture.getBlueprintCost())
        {
            money -= furniture.getBlueprintCost();
            furniture.setHasBlueprint(true);
        }
    }

    public void putUpPoster()
    {
        if (money >= POSTER_PRICE)
        {
            money -= POSTER_PRICE;
            customerAttraction += Math.round(1000.0 * (5.0 / ((Math.pow(numberOfPosters, 2.0)) + 25.0))) / 1000.0;
            numberOfPosters++;
        }
    }


    public void runCustomerAI()
    {
        // customer ai
        double customerEnterPercentage = customerAttraction * enterPercentage; // [stage.getEnterPercentage] store popularity  ; TODO rename variable
        if (aiBehaviours.nextDouble(0.0, 100.0) <= customerEnterPercentage)
        {
            customersInStore++; // this is not 100% enterance rate; is reduced
            // TODO multiple people
        }

        // will have to deal with when customer = 0;
        if (customersInStore > 0) {
            for (int customer = 1; customer <= customersInStore; customer++) {
                // checks stock
                if (findTotalStock() == 0) {
                    System.out.println("Customer [" + customer + "] sees no items to buy --> left. Remaining customers: " + customersInStore);
                    customersInStore -= 1; // TODO try to fix this :)
                    customerAttraction -= 0.05;
                    break;
                }
                else
                {
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
        String businessData = companyName.toUpperCase() + " | " + "MONEY: " + money + "$ | WOOD: " + wood +
                " | TICKS SINCE START: " + ticksActive + " | TOTAL STOCK: " + findTotalStock() + " | CUSTOMERS IN STORE: " + customersInStore + " | TOTAL PROFITS: " + profit + " | CUSTOMER ATTRACTION: " + customerAttraction + " | ";

        // stock
        for (Furniture furniture : furnitures)
        {
            businessData += (furniture.getFurnitureName().toUpperCase() + ": " + furniture.getNumInStock() + " | ");
        }

        return businessData;
    }

    public int getNumberOfPosters()
    {
        return numberOfPosters;
    }


    public double getCustomerAttraction()
    {
        return customerAttraction;
    }
}

