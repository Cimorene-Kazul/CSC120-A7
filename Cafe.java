/* This is a stub for the Cafe class */
public class Cafe extends Building implements CafeRequirements{
    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors){
        this(name, address, nFloors, 0,0,0,0);
    }

    public Cafe(String name, String address, int nFloors, int startingCoffeeOunces, int startingSugarPackets, int startingCreams, int startingCups) {
        // call the superclass constructor
        super(name, address, nFloors);
        // set the amounts of the ingredients
        this.nCoffeeOunces = startingCoffeeOunces;
        this.nSugarPackets = startingSugarPackets;
        this.nCreams = startingCreams;
        this.nCups = startingCups;
        // notify their user of success
        System.out.println("You have built a cafe: ☕");
    }

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCups -= 1;
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;

        while (this.nCups<1&&this.nCoffeeOunces<1&&this.nSugarPackets<1&&this.nCreams<1){
            this.restock(200, 20,20, 20);
        }

        System.out.println("Enjoy your "+size+"oz coffee with "+nCreams+" splashes of cream and "+nSugarPackets+" packets of sugar.");
    }

    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCups += nCups;
        this.nCreams += nCreams;
        System.out.println("The Cafe has been restocked!");
    }
    
    public static void main(String[] args) {
        new Cafe("CC", "101 Smith Street", 3);
    }
    
}
