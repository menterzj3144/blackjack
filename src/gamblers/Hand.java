package gamblers;

import card.Card;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> cards;

    Hand() {
        cards = new ArrayList<>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getTotal() {
        int total = 0;

        for (Card card : cards) {
            total += card.getValue();
        }

        if (total > 21) {
            for (Card card : cards) {
                if (card.getType().equals("Ace")) {
                    total -= 10;

                    if (total <= 21) {
                        return total;
                    }
                }
            }
        }

        return total;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void clear() {
        cards.clear();
    }

    public boolean isEmpty() {

        return cards.isEmpty();

    }
}
