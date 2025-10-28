import java.util.Scanner;  // Import library for Scanner

public class SuperheroRoster {
 
    public static void main(String[] args) {
        // Keyboard input
        Scanner input = new Scanner(System.in);

        // 1. Declare and initialize arrays for hero names, abilities, and power levels
        String[] heroNames = {"Spider-Man", "Iron Man", "Black Widow"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat"};
        int[] powerLevels = {85, 90, 80};
 
        // 2. Print each hero's details using a loop
        System.out.println("--- Superhero Roster ---");
        System.out.println("----------------");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Superhero Name: " + heroNames[i]);
            System.out.println("Superhero Ability: " + abilities[i]);
            System.out.println("Superhero Power Level: " + powerLevels[i]);
            System.out.println("---");
        }
 
        // 3. Call the searchHero method to find a specific hero by name
        String searchHeroString;
        System.out.print("\nType a name to search for a hero: ");
        searchHeroString = input.nextLine();   // Gets the whole line of text
        searchHero(heroNames, abilities, powerLevels, searchHeroString);
 
        // 4. Calculate and display the average power level by calling calculateAveragePower method
        double avgPowerLevel = calculateAveragePower(powerLevels);
        System.out.println("\nAverage power level: " + avgPowerLevel);

        // Create sample array of superheros
        Superhero[] heroList = new Superhero[3];

        System.out.println("\nInput your own superheroes!");

        for (int i = 0; i < heroList.length; i++) {
            System.out.println("---");
            System.out.println("Enter a NAME for hero #" + (i + 1) + " >> ");
            String heroListName = input.nextLine();

            System.out.println("Enter an ABILITY for hero #" + (i + 1) + " >> ");
            String heroListAbility = input.nextLine();

            System.out.println("Enter a POWER LEVEL for hero #" + (i + 1) + " >> ");
            int heroListPowerLevel = input.nextInt();
            input.nextLine();

            heroList[i] = new Superhero(heroListName, heroListAbility, heroListPowerLevel);
        }
        // Display created heroes
        System.out.println("\n --- Created Superheroes ---");
        for (Superhero hero : heroList) {
            hero.displayHero();
            System.out.println("---");
        }

    }

 
    // -----------------------------------

    // Method: searchHero
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        // Implement a loop to search for the hero by name
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("\nHero " + target + " has been found.");
                System.out.println("Name: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power level: " + powerLevels[i]);

                found = true;
                break;
            }
        }
        // If not found, display a message
        if (!found) {
            System.out.println("Hero " + target + " not found.");
        }

    }
 
    // Method: calculateAveragePower
    public static double calculateAveragePower(int[] powerLevels) {
        // Implement the calculation for average power level
        int sum = 0;
        for (int i = 0; i < powerLevels.length; i++) {
            sum += powerLevels[i];
        }

        // Return the calculated average
        return (double) sum / powerLevels.length;
    }
}
 
// --------------------------------------

class Superhero {
    // Fields for superhero attributes
    private String name;
    private String ability;
    private int powerLevel;

    // Constructor to create superhero
    public Superhero(String name, String ability, int powerLevel) {
        this.name = name;
        this.ability = ability;
        this.powerLevel = powerLevel;
    }

    // Display heroes
    public void displayHero() {
        System.out.println("Name: " + name);
        System.out.println("Ability: " + ability);
        System.out.println("Power level: " + powerLevel);
    }
}