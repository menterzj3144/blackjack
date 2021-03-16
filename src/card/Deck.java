package card;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    /**
     * The cards within the deck
     */
    private ArrayList<Card> deck;

    Deck() {
        deck = new ArrayList<>();
        resetDeck();
    }

    /**
     * Re-adds all cards to the deck
     */
    public void resetDeck() {
        String[] suits = new String[] {"Clubs", "Diamonds", "Hearts", "Spades"};
        for (int i = 0; i < suits.length; i++) {
            Card a = new Card("Ace", 11, suits[i]);
            deck.add(a);

            //Add cards 2-10 to the deck
            for (int j = 2; j <= 10; j++) {
                Card card = new Card(String.valueOf(j), j, suits[i]);
                deck.add(card);
            }

            Card j = new Card("Jack", 10, suits[i]);
            Card q = new Card("Queen", 10, suits[i]);
            Card k = new Card("King", 10, suits[i]);
            deck.add(j);
            deck.add(q);
            deck.add(k);
        }
    }

    /**
     * Prints all cards in the deck
     * @return String with all cards
     */
    public String toString() {
        String result = "";
        for (Card card : deck) {
            result += card + "\n";
        }
        return result;
    }

    /**
     * Picks a random card from the deck
     */
    public Card pickCard() {
        Random rand = new Random();
        int num = rand.nextInt(deck.size());
        Card card = deck.get(num);
        deck.remove(card);
        return card;
    }
}