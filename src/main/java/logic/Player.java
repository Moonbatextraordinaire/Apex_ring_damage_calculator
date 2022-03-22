package logic;

/**
 * Apex ring damage calculator : Player
 *
 * @author Tanguy Clavareau
 * @version 22/03/2022
 */
public class Player {
    private int life;
    private boolean goldShield;

    public Player() {
        life = 100;
        goldShield = false;
    }

    public void setLife(int damage) {
        this.life = life - damage;
    }

    public int getLife() {
        return life;
    }

    public void setGoldShield(int choice) {
        if (choice == 1) {
            goldShield = true;
        } else if (choice == 2) {
            goldShield = false;
        } else {
            throw new IllegalArgumentException("Non existent value");
        }
    }
    public void healPlayer(Heals heal){
        if (heal == Heals.SYRINGE && !goldShield){
            this.life += 25;
        } else if (heal == Heals.SYRINGE){
            this.life += 50;
        } else if (heal == Heals.MEDKIT){
            this. life += 100;
        }
    }
}
