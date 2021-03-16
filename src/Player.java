import card.Card;

import java.util.ArrayList;

public class Player {
    public ArrayList<Card> hand;
    private int money;

    Player(int money) {
        hand = new ArrayList<>();
        this.money = money;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand() {
        hand.clear();
    }
}
