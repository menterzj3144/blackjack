package gamblers;

public class Dealer extends Gambler {

    public Dealer() {
        super();
    }

    public boolean mustHit() {
        return hand.getTotal() < 17;
    }
}
