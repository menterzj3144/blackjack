package gamblers;

import card.Card;

/**
 * Represents a gambler (dealer or player)
 */
public abstract class Gambler {

    /**
     * The cards in the gambler's hand
     */
    protected Hand hand;

    /**
     * Creates a new gambler
     */
    Gambler() {
        hand = new Hand();
    }

    /**
     * Adds a card to the gambler's hand
     * @param card Card that is dealt
     */
    public void hit(Card card) {
        hand.addCard(card);
    }

    /**
     * Returns the gambler's hand
     * @return Hand of the gambler
     */
    public Hand getHand() {
        return hand;
    }

    /**
     * Returns true if the hand's total is > 21
     * @return boolean result of hand.getTotal() > 21
     */
    public boolean isBust() {
        return hand.getTotal() > 21;
    }
}
