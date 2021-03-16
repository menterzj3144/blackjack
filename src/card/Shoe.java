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
        Random rand = new Random();
        int num = rand.nextInt(numDecks);
        Card card = decks.get(num).pickCard();
        return card;
    }

}