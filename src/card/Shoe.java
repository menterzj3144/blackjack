package card;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a card shoe
 */
public class Shoe {

    /**
     * The number of decks in the shoe
     */
    private int numDecks;

    /**
     * ArrayList of decks in the shoe
     */
    private ArrayList<Deck> decks;

    /**
     * Creates a new shoe
     * @param numDecks integer number of decks in shoe
     */
    public Shoe(int numDecks) {
        this.numDecks = numDecks;
        this.decks = new ArrayList<>(numDecks);
        resetShoe();
    }

    /**
     * Re-adds all the cards to the shoe
     */
    public void resetShoe() {
        for (int i = 0; i < numDecks; i++) {
            decks.add(new Deck());
        }
    }

    /**
     * Prints all cards in the shoe to the console
     * @return String of all cards in the shoe
     */
    public String toString() {
        String result = "";
        for (Deck deck : decks) {
            result += deck + "\n";
        }
        return result;
    }

    /**
     * Picks a random card from a random deck in the shoe
     * @return Card that was chosen
     */
    public Card pickCard() {
        if (isEmpty()) {
            System.out.println("Shuffle");
            resetShoe();
        }

        Random rand = new Random();
        int num = rand.nextInt(decks.size());
        Card card = decks.get(num).pickCard();
        if (decks.get(num).isEmpty()) {
            decks.remove(num);
        }
        return card;
    }

    /**
     * Returns true if the shoe is empty
     * @return the isEmpty value of the shoe
     */
    private boolean isEmpty() {
        return decks.isEmpty();
    }
}