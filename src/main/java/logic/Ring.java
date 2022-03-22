package logic;

/**
 * Apex ring damage calculator : Ring
 *
 * @author Tanguy Clavareau
 * @version 22/03/2022
 */
public class Ring {
    private int damage;
    private double totalTime;

    public Ring(int ringNumber) {
        if (ringNumber > 0 && ringNumber < 7) {
            this.damage = setDamage(ringNumber);
        } else {
            throw new IllegalArgumentException("Invalid value given for ring");
        }
    }
    public int setDamage(int ringNumber) {
        switch (ringNumber) {
            case (1) -> damage = 2;
            case (2) -> damage = 3;
            case (3) -> damage = 10;
            case (4), (5) -> damage = 20;
            case (6) -> damage = 25;
            default -> System.out.println("somehow something went wrong");
        }
        return damage;
    }
    public int getDamage() {
        return damage;
    }
}
