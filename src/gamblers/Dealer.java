package gamblers;

/**
 * Represents a dealer
 */
public class Dealer extends Gambler {

    /**
     * Creates a new dealer
     */
    public Dealer() {
        super();
    }

    /**
     * Must hit returns true if the dealer has to hit
     * @return true if hand's total is < 17
     */
    public boolean mustHit() {
        return hand.getTotal() < 17;
    }
}
