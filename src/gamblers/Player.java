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


    private double[] intervalList;


    private String state;

    /**
     * Creates a new player
     * @param money int amount of money the player has
     */
    public Player(double money) {
        super();
        this.money = money;
        bet = 0;
        interval = 0;
        intervalList = new double[]{1, 5, 10, 50, 100, 500, 1000};
        state = "";
    }

    /**
     * Raises the bet by 1
     */
    public void raiseBet() {
        if (money > 0) {
            if (intervalList[interval] > money) {
                bet += money;
                money -= money;
            } else {
                bet += intervalList[interval];
                money -= intervalList[interval];
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
            bet -= intervalList[interval];
            money += intervalList[interval];
        }
    }

    /**
     * Raises the betting interval
     */
    public void raiseInterval() {
        if (interval < intervalList.length - 1) {
            interval++;
        }
    }

    /**
     * Lowers the betting interval
     */
    public void lowerInterval() {
        if (interval > 0) {
            interval--;
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
     * Doubles the player's bet if they have enough money
     * @return true if can double bet, false if not
     */
    public boolean doubleBet() {
        if (bet <= money) {
            bet = bet * 2;
            money -= bet;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sets the bet value to zero
     */
    public void clearBet() {
        bet = 0;
    }

    /**
     * Adds money to the player
     * @param num the amount to add
     */
    public void addMoney(double num) {
        money += num;
    }

    /**
     * Returns the amount of money the player has
     * @return the money the player has
     */
    public double getMoney() {
        return money;
    }

    /**
     * Sets state of the hand
     * @param s the state to be set
     */
    public void setState(String s) {
        state = s;
    }

    /**
     * Returns state of the hand
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * Returns the betting interval
     * @return betting interval
     */
    public double getBettingInterval() {
        return intervalList[interval];
    }
}
