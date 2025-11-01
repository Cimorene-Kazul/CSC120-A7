/**
 * This is the Cafe class. Cafe is a subclass of Building and impliments CafeRequirements.
 * A Cafe has the same locational information as any Building but also keeps track of inventory and models (not terribly realistically) the purchasing of drinks.
 */
public class Cafe extends Building implements CafeRequirements{
    // initialize attributes
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /**
     * Constructor for a Cafe with fewer inputs.
     * This prevents errors from being thrown if starting values are not given for ingredients. Instead, the Cafe starts with 0 ounces of coffee, sugar packets, creams, and cups.
     * @param name is a String that indicates the name of the cafe.
     * @param address is a String that indicates the cafe's address.
     * @param nFloors is a positive integer indicating the number of floors the cafe has.
     */
    public Cafe(String name, String address, int nFloors){
        // use the other constructor to make a Cafe with the given name, address, and nFloors, but also with 0 as the value of startingCoffeeOunces, startingSugarPackets, startingCreams, and startingCups.
        this(name, address, nFloors, 0,0,0,0);
    }

    /**
     * Constructor for a cafe with all attributes given.
     * @param name is a String that indicates the name of the cafe.
     * @param address is a String that indicates the cafe's address.
     * @param nFloors is a positive integer indicating the number of floors the cafe has.
     * @param startingCoffeeOunces is a nonnegative integer indicating the number of ounces of coffee the cafe starts with.
     * @param startingSugarPackets is a nonnegative integer indicating the number of sugar packets the cafe starts with.
     * @param startingCreams is a nonnegative integer indicating the number of splashes of cream the cafe starts with.
     * @param startingCups is a nonnegative integer indicating the number of cups the cafe starts with.
     */
    public Cafe(String name, String address, int nFloors, int startingCoffeeOunces, int startingSugarPackets, int startingCreams, int startingCups) {
        // call the superclass constructor
        super(name, address, nFloors);
        // throw an exception if the inputs are bad
        if (startingCoffeeOunces<0||startingSugarPackets<0||startingCreams<0||startingCups<0){
            throw new IllegalArgumentException("Quantities for starting supplies must be positive integers.");
        }
        // set the amounts of the ingredients
        this.nCoffeeOunces = startingCoffeeOunces;
        this.nSugarPackets = startingSugarPackets;
        this.nCreams = startingCreams;
        this.nCups = startingCups;
        // notify the user of success
        System.out.println("You have built a cafe: ☕");
    }

    /**
     * Sells a drink with given requirements from the Cafe, restocking if need be.
     * @param size is the integer number of ounces of coffee in the drink.
     * @param nSugarPackets is the integer number of packets of sugar in the drink.
     * @param nCreams is the integer number of splashes of cream in the drink,
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        // remove from inventory the used supplies 
        this.nCups -= 1; // any drink uses 1 cup
        this.nCoffeeOunces -= size; 
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        
        // if the cafe is out of supplies due to the purchase, restock.
        while (this.nCups<1&&this.nCoffeeOunces<1&&this.nSugarPackets<1&&this.nCreams<1){
            // get more supplies - 200 oz coffee, 20 sugar packets, 20 splashes cream, 20 cups seems reasonable
            this.restock(200, 20,20, 20);
        }
        // record the sale
        System.out.println("One "+size+"oz coffee with "+nCreams+" splashes of cream and "+nSugarPackets+" packets of sugar sold.");
    }

    /**
     * Restock the cafe by adding more materials to the supply stock.
     * @param nCoffeeOunces is the integer number of ounces of coffee added to stock.
     * @param nSugarPackets is the integer number of sugar packets added to stock.
     * @param nCreams is the integer number of splashes of cream added to stock.
     * @param nCups is the integer number of cups added to stock.
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        // amounts of supplies must be nonnegative
        if (nCoffeeOunces<0||nSugarPackets<0||nCreams<0||nCups<0){
            throw new IllegalArgumentException("Quantities for supplies must be positive integers.");
        }
        // add the new supplies to the total values availiable
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCups += nCups;
        this.nCreams += nCreams;
        // notify the user
        System.out.println("The Cafe has been restocked!");
    }
    
    // main method to test the class in 
    public static void main(String[] args) {
        new Cafe("CC", "101 Smith Street", 3); // test Cafe!
    }
    
}