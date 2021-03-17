package gamblers;

import card.Card;

public abstract class Gambler {

    protected Hand hand;

    Gambler() {
        hand = new Hand();
    }

    public void hit(Card card) {
        hand.addCard(card);
    }

    public Hand getHand() {
        return hand;
    }

    public boolean isBust() {
        return hand.getTotal() > 21;
    }
}
