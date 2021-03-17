package card;

import java.util.ArrayList;
import java.util.Random;

public class Shoe {

    private int numDecks;

    private ArrayList<Deck> decks;

    public Shoe(int numDecks) {
        this.numDecks = numDecks;
        this.decks = new ArrayList<>(numDecks);
        resetShoe();
    }

    public void resetShoe() {
        for (int i = 0; i < numDecks; i++) {
            decks.add(new Deck());
        }
    }

    public String toString() {
        String result = "";
        for (Deck deck : decks) {
            result += deck + "\n";
        }
        return result;
    }

    /**
     * Picks a random card from a random deck in the shoe
     */
    public Card pickCard() {
        if (isEmpty()) {
            System.out.println("Shuffle");
            resetShoe();
        }
        Random rand = new Random();
        int num = rand.nextInt(numDecks);
        Card card = decks.get(num).pickCard();
        if (decks.get(num).isEmpty()) {
            decks.remove(num);
        }
        return card;
    }

    private boolean isEmpty() {
        return decks.isEmpty();
    }

    public int getNumCards() {
        int i = 0;
        for (Deck deck : decks) {
            i += deck.getNumCards();
        }
        return i;
    }
}