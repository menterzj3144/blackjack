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

            if (bet < 50) {
                interval = 1;
            } else if (bet < 100) {
                interval = 5;
            } else if (bet < 500) {
                interval = 10;
            } else if (bet < 1000) {
                interval = 25;
            } else if (bet < 2500) {
                interval = 50;
            } else if (bet < 5000) {
                interval = 100;
            } else {
                interval = 500;
            }

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

            if (bet <= 50) {
                interval = 1;
            } else if (bet <= 100) {
                interval = 5;
            } else if (bet <= 500) {
                interval = 10;
            } else if (bet <= 1000) {
                interval = 25;
            } else if (bet <= 2500) {
                interval = 50;
            } else if (bet <= 5000) {
                interval = 100;
            } else {
                interval = 500;
            }
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
}
