package gamblers;

/**
 * Represents a player
 */
public class Player extends Gambler {
    /**
     * Amount of money the player has
     */
    private int money;

    /**
     * Amount of money being bet
     */
    private int bet;

    /**
     * Creates a new player
     * @param money int amount of money the player has
     */
    public Player(int money) {
        super();
        this.money = money;
        bet = 0;
    }

    /**
     * Raises the bet by 1
     */
    public void raiseBet() {
        bet += 1;
        System.out.println(bet);
    }

    /**
     * Lowers the bet by 1
     */
    public void lowerBet() {
        bet -= 1;
        System.out.println(bet);
    }

    /**
     * Returns the value of the bet
     * @return int value of bet
     */
    public int getBet() {
        return bet;
    }

    /**
     * Sets the bet value to zero
     */
    public void clearBet() {
        bet = 0;
    }
}
