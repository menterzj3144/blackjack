package gamblers;

public class Player extends Gambler {
    private int money;
    private int bet;

    public Player(int money) {
        super();
        this.money = money;
        bet = 0;
    }

    public void raiseBet() {
        bet += 1;
        System.out.println(bet);
    }

    public void lowerBet() {
        bet -= 1;
        System.out.println(bet);
    }

    public int getBet() {
        return bet;
    }

    public void clearBet() {
        bet = 0;
    }
}
