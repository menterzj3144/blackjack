package card;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /**
     * The cards within the deck
     */
    private ArrayList<Card> cards;

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

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int getNumCards() {
        return cards.size();
    }
}