package gamblers;

import card.Card;

import java.util.ArrayList;

/**
 * Represents a player's hand of cards
 */
public class Hand {
    /**
     * The cards in the hand
     */
    private ArrayList<Card> cards;

    /**
     * Creates a new hand
     */
    Hand() {
        cards = new ArrayList<>();
    }

    /**
     * Returns the cards in the hand
     * @return ArrayList of cards in the hand
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    /**
     * Returns total sum of the value of the cards in the hand
     * @return sum of the hand's value
     */
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

    /**
     * Adds a card to the hand
     * @param card the card to be added
     */
    public void addCard(Card card) {
        cards.add(card);
    }

    /**
     * Clears the player's hand
     */
    public void clear() {
        cards.clear();
    }

    /**
     * Returns true if the hand is empty
     * @return true if player's hand is empty
     */
    public boolean isEmpty() {
        return ! (cards.size() > 1);
    }
}
