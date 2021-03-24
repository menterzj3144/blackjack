package gamblers;

/**
 * Represents a player
 */
public class Player extends Gambler {
    /**
     * Amount of money the player has
     */
    private double money;

    /**
     * Amount of money being bet
     */
    private int bet;

    /**
     * Creates a new player
     * @param money int amount of money the player has
     */
    public Player(double money) {
        super();
        this.money = money;
        bet = 0;
    }

    /**
     * Raises the bet by 1
     */
    public void raiseBet() {
        if (money > 0) {
            bet += 1;
            money -= 1;
            System.out.println("Money: $" + money);
            System.out.println("Bet: $" + bet);
        } else {
            System.out.println("Not enough money");
        }
    }

    /**
     * Lowers the bet by 1
     */
    public void lowerBet() {
        if (bet > 0) {
            bet -= 1;
            money += 1;
            System.out.println("Money: $" + money);
            System.out.println("Bet: $" + bet);
        }
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
        System.out.println("$" + money);
    }

    public void addMoney(double num) {
        money += num;
    }
}
