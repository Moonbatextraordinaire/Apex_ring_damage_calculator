import java.util.Scanner;

/**
 * Apex ring damage calculator in funcction of syringes, medkits and gold shield.
 *
 * @author Tanguy Clavareau
 * @version 19/03/2022
 */
public class demo {
    public static void main(String[] args) {
        int damage = 0;
        int ring = 0;
        double timer = 0;
        double totalTime = 0;
        int choice = 0;

        Scanner sc = new Scanner(System.in);
        damage = setDamage(damage, ring, sc);
        choice = getChoice(choice, sc);

        if (choice == 1) {
            calculateForSyringes(damage, timer, totalTime);
        } else if (choice == 2){
            calculateForSynringesGoldShield(damage, timer, totalTime);
        }else {
            calculateForMedkits(damage, timer, totalTime);
        }
    }

    /**
     * Asks user to provide ring number. Sets damage based on user input. Checks user input is valid, if invalid loops
     * until a valid value is given.
     * @param damage The damage the player will receive, based on the ring parameter.
     * @param ring The ring number (value between 1-6), set by the user input sc.
     * @param sc Scanner for user input.
     * @return Int which will be the damage the player incurs
     */
    private static int setDamage(int damage, int ring, Scanner sc) {
        do {
            System.out.println("Please enter a ring number between 1-6");
            try {
                ring = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid value given for ring!");
                sc.nextLine();
            }
        } while(ring < 1 || ring > 6);

        switch (ring) {
            case (1) -> damage = 2;
            case (2) -> damage = 3;
            case (3) -> damage = 10;
            case (4), (5) -> damage = 20;
            case (6) -> damage = 25;
            default -> System.out.println("somehow something went wrong");
        }
        return damage;
    }

    /**
     * User selection to determine if player heals with syringes, syringes with gold shield or medkits.
     * Checks user input is valid, if invalid loops until a valid value is given.
     * @param choice Integer value between 1-3 that is used to determine which heals will be used. Set by user input "sc"
     * @param sc Scanner for user input
     * @return Int value between 1-3 that is used to determine which heals will be used.
     */
    private static int getChoice(int choice, Scanner sc) {
        do {
            System.out.println("Assuming infinite heals, which healing method do you want to calculate ring survivability for? \n" +
                               "1) Syringes\n" +
                               "2) Syringe with gold shield\n" +
                               "3) Medkits");
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Unexpected value...What have you typed in you silly moose!\n");
                sc.nextLine();
            } if (choice < 1 || choice > 3) {
                System.out.println("Selected value is not 1, 2 or 3\n");
            }
        } while (choice < 1 || choice > 3);
        return choice;
    }

    /**
     * Calculates if player survives damage incurred based on ring number (set by setDamage method) with a for loop.
     * @param damage The damage the player will incur each tick.
     * @param timer Amount of seconds needed for the player to heal. Is calculated as follows: 1.5 sec * x.
     *             Where "x" is determined by the healing medium (For syringe x =5, for medkit x = 8)
     * @param totalTime If the player dies, counts the total amount of time it would take for them to die
     */
    private static void calculateForSyringes(int damage, double timer, double totalTime) {
        for (int life = 100; life > 0; life -= damage) {
            timer += 1.5;
            totalTime += 1.5;
            if (timer == 7.5) {
                timer = 0;
                life += 25;
            }
            if (life > 100) {
                System.out.println("You'll survive! Go on and stay in that ring buddy");
                break;
            }
            if ((life - damage) <= 0) {
                System.out.println("Oh no! You would have died in this ring. If you would have constantly healed up, " +
                                   "It would have taken " + totalTime + " seconds for you to die");
                break;
            }
        }
    }
    /**
     * Calculates if player survives damage incurred based on ring number (set by setDamage method) with a for loop.
     * @param damage The damage the player will incur each tick.
     * @param timer Amount of seconds needed for the player to heal. Is calculated as follows: 1.5 sec * x.
     *             Where "x" is determined by the healing medium (For syringe x =5, for medkit x = 8)
     * @param totalTime If the player dies, counts the total amount of time it would take for them to die
     */
    private static void calculateForSynringesGoldShield(int damage, double timer, double totalTime) {
        for (int life = 100; life > 0; life -= damage) {
            timer += 1.5;
            totalTime += 1.5;
            if (timer == 7.5) {
                timer = 0;
                life += 50;
            }
            if (life > 100) {
                System.out.println("You'll survive! Go on and stay in that ring buddy");
                break;
            }
            if ((life - damage) <= 0) {
                System.out.println("Oh no! You would have died in this ring. If you would have constantly healed up, " +
                                   "It would have taken " + totalTime + " seconds for you to die");
                break;
            }
        }
    }
    /**
     * Calculates if player survives damage incurred based on ring number (set by setDamage method) with a for loop.
     * @param damage The damage the player will incur each tick.
     * @param timer Amount of seconds needed for the player to heal. Is calculated as follows: 1.5 sec * x.
     *             Where "x" is determined by the healing medium (For syringe x =5, for medkit x = 8)
     * @param totalTime If the player dies, counts the total amount of time it would take for them to die
     */
    private static void calculateForMedkits(int damage, double timer, double totalTime) {
        for (int life = 100; life > 0; life -= damage) {
            timer += 1.5;
            totalTime += 1.5;
            if (timer == (12)) {
                timer = 0;
                life = 100;
            }
            if (life > 100) {
                System.out.println("You'll survive! Go on and stay in that ring buddy");
                break;
            }
            if ((life - damage) <= 0) {
                System.out.println("Oh no! You would have died in this ring. If you would have constantly healed up, " +
                                   "It would have taken " + totalTime + " seconds for you to die");
                break;
            }
        }
    }
}
