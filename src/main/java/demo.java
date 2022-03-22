import logic.Heals;
import logic.Player;
import logic.Ring;

import java.util.Scanner;

/**
 * Apex ring damage calculator in function of syringes, medkits and gold shield.
 *
 * @author Tanguy Clavareau
 * @version 19/03/2022
 */

public class demo {
    public static void main(String[] args) {
        Player player1 = new Player();
        Scanner sc = new Scanner(System.in);

        int ringNumber = getRingNumber(sc);
        Ring ring = new Ring(ringNumber);

        goldShieldChoice(sc, player1);
        Heals heal = healSelection(sc);

        float timer = 0;
        float totalTimer = 0;
        if (heal == Heals.SYRINGE) {
            for (; player1.getLife() > 0; player1.setLife(ring.getDamage())) {
                timer += 1.5;
                totalTimer += 1.5;
                if (timer == 7.5) {
                    timer = 0;
                    player1.healPlayer(heal);
                }
                if (player1.getLife() > 100) {
                    System.out.println("You'll survive! Go on and stay in that ring buddy");
                    break;
                }
                if (player1.getLife() - ring.getDamage() <= 0) {
                    System.out.println("Oh no! You would have died in this ring. If you would have constantly healed up, " +
                                       "It would have taken " + totalTimer + " seconds for you to die");
                    break;
                }
            }
        } else {
            for (; player1.getLife() > 0; player1.setLife(ring.getDamage())) {
                timer += 1.5;
                totalTimer += 1.5;
                if (timer == 12) {
                    timer = 0;
                    player1.healPlayer(heal);
                }
                if (player1.getLife() > 100) {
                    System.out.println("You'll survive! Go on and stay in that ring buddy");
                    break;
                }
                if (player1.getLife() - ring.getDamage() <= 0) {
                    System.out.println("Oh no! You would have died in this ring. If you would have constantly healed up, " +
                                       "It would have taken " + totalTimer + " seconds for you to die");
                    break;
                }
            }
        }
    }

    private static Heals healSelection(Scanner sc) {
        Heals heal = null;
        int healChoice = 0;
        do {
            System.out.println("How are you going to heal?\n\n1) Syringes\n2) Medkits");
            try {
                healChoice = sc.nextInt();
                if (healChoice == 1) {
                    heal = Heals.SYRINGE;
                } else if (healChoice == 2) {
                    heal = Heals.MEDKIT;
                } else {
                    System.out.println("Value given is not 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("That's not a number!");
                sc.nextLine();
            }
        } while (healChoice < 1 || healChoice > 2);
        return heal;
    }

    private static void goldShieldChoice(Scanner sc, Player player1) {
        int goldShieldChoice = 0;
        do {
            System.out.println("Does the player have a gold shield?\n\n1) Yes\n2) No");
            try {
                goldShieldChoice = sc.nextInt();
                if (goldShieldChoice == 1) {
                    player1.setGoldShield(goldShieldChoice);
                } else if (goldShieldChoice == 2) {
                    player1.setGoldShield(goldShieldChoice);
                } else {
                    System.out.println("Value given is not 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("That's not a number!");
                sc.nextLine();
            }
        } while (goldShieldChoice < 1 || goldShieldChoice > 2);
    }

    private static int getRingNumber(Scanner sc) {
        int ringNumber = 0;
        do {
            System.out.println("Please enter a ring number between 1-6");
            try {
                ringNumber = sc.nextInt();
                if (ringNumber < 1 || ringNumber > 6) {
                    System.out.println("Provided value is not between 1 and 6");
                }
            } catch (Exception e) {
                System.out.println("That's not a number!");
                sc.nextLine();
            }
        } while(ringNumber < 1 || ringNumber > 6);
        return ringNumber;
    }
}
