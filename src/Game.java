import card.Card;
import card.Shoe;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private Shoe shoe;
    private ArrayList<Card> dealerHand;
    private Player player;

    Game() {
        shoe = new Shoe(5);
        dealerHand = new ArrayList<>();
        player = new Player(100);
    }

    public void startGame() {
        player.addCard(shoe.pickCard());
        dealerHand.add(shoe.pickCard());
        player.addCard(shoe.pickCard());

        //dealer's second card starts face down
        Card card = shoe.pickCard();
        card.setFacedown(true);
        dealerHand.add(card);
    }

    public void paint(Graphics g) throws IOException {
        g.setColor(new Color(35,112,98));
        g.fillRect(0, 0, Main.SIZE_X, Main.SIZE_Y);

        //paint the dealer's hand
        int x = Main.SIZE_X / 2 - 106;
        for (Card card : dealerHand) {
            card.paint(g, x, 10);
            x += 106;
        }

        //paint the player's hand
        x = Main.SIZE_X / 2 - 106;
        for (Card card : player.hand) {
            card.paint(g, x, Main.SIZE_Y - 350);
            x += 106;
        }
    }
}