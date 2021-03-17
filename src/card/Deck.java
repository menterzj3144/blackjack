package card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a deck
 */
public class Deck {

    /**
     * The cards within the deck
     */
    private ArrayList<Card> cards;

    /**
     * Creates a new deck
     */
    Deck() {
        cards = new ArrayList<>();
        resetDeck();
    }

    /**
     * Re-adds all cards to the deck
     */
    public void resetDeck() {
        String[] suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (String suit : suits) {
            Card a = new Card("Ace", 11, suit);
            cards.add(a);

            //Add cards 2-10 to the deck
            for (int j = 2; j <= 10; j++) {
                Card card = new Card(String.valueOf(j), j, suit);
                cards.add(card);
            }

            Card j = new Card("Jack", 10, suit);
            Card q = new Card("Queen", 10, suit);
            Card k = new Card("King", 10, suit);
            cards.add(j);
            cards.add(q);
            cards.add(k);
        }
    }

    /**
     * Prints all cards in the deck
     * @return String with all cards
     */
    public String toString() {
        String result = "";
        for (Card card : cards) {
            result += card + "\n";
        }
        return result;
    }

    /**
     * Picks a random card from the deck
     */
    public Card pickCard() {
        Random rand = new Random();
        int num = rand.nextInt(cards.size());
        Card card = cards.get(num);
        cards.remove(num);
        return card;
    }

    /**
     * Returns true if the deck is empty
     * @return the isEmpty value of the deck
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    /**
     * Returns the number of cards in the deck
     * @return number of cards in deck
     */
    public int getNumCards() {
        return cards.size();
    }
}