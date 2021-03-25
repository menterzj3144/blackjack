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
     * Sets the bet value to zero
     */
    public void clearBet() {
        bet = 0;
    }

    /**
     * 
     * @param num
     */
    public void addMoney(double num) {
        money += num;
    }

    /**
     *
     * @return
     */
    public double getMoney() {
        return money;
    }

    /**
     *
     * @param s
     */
    public void setState(String s) {
        state = s;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @return
     */
    public double getBettingInterval() {
        return intervalList[interval];
    }
}
