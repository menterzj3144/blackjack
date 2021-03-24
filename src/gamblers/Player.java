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
    private double bet;

    /**
     * Interval of money being bet
     */
    private int interval;

    /**
     * Creates a new player
     * @param money int amount of money the player has
     */
    public Player(double money) {
        super();
        this.money = money;
        bet = 0;
        interval = 1;
    }

    /**
     * Raises the bet by 1
     */
    public void raiseBet() {
        if (money > 0) {
            bet += interval;
            money -= interval;
            System.out.println("Money: $" + money);
            System.out.println("Bet: $" + bet);
        } else {
            System.err.println("Not enough money");
        }
    }

    /**
     * Lowers the bet by 1
     */
    public void lowerBet() {
        if (bet > 0) {
            bet -= interval;
            money += interval;
            System.out.println("Money: $" + money);
            System.out.println("Bet: $" + bet);
        }
    }

    /**
     * Returns the value of the bet
     * @return int value of bet
     */
    public double getBet() {
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

    public void raiseInterval() {
        if (interval < money) {
            interval += 1;
            System.out.println("Betting interval: $" + interval);
        } else {
            System.err.println("Betting interval cannot be greater than total money");
        }
    }

    public void lowerInterval() {
        if (interval > 1) {
            interval -= 1;
            System.out.println("Betting interval: $" + interval);
        } else {
            System.err.println("Betting interval cannot be less than 1");
        }
    }
}
