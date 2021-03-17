import card.Card;
import card.Shoe;
import gamblers.Dealer;
import gamblers.Player;

import java.awt.*;
import java.io.IOException;

public class Game {

    private Shoe shoe;
    private Dealer dealer;
    private Player player;

    private boolean isBetting;

    Game() {
        shoe = new Shoe(5);
        player = new Player(100);
        dealer = new Dealer();
        isBetting = true;
    }

    public void raiseBet() {
        if (isBetting) {
            if (!dealer.getHand().isEmpty()) {
                player.getHand().clear();
                dealer.getHand().clear();
            }
            player.raiseBet();
        }
    }

    public void lowerBet() {
        if (isBetting) {
            player.lowerBet();
        }
    }

    public void hit() {
        if (isBetting) {
            if (player.getBet() == 0) {
                System.err.println("Ya gotta bet bitch");
            } else {
                isBetting = false;
                deal();
                System.out.println("Player total: " + player.getHand().getTotal());
            }
        } else {
            if (!player.isBust() && !isBetting) {
                player.hit(shoe.pickCard());
                System.out.println("Player total: " + player.getHand().getTotal());
                if (player.isBust()) {
                    System.out.println("You suck");
                    moveOn();
                }
            }
        }
    }

    public void moveOn() {
        if (!dealer.getHand().isEmpty()) {
            dealer.getHand().getCards().get(1).setFacedown(false);
            while (dealer.mustHit()) {
                dealer.hit(shoe.pickCard());
            }
            System.out.println("Dealer total: " + dealer.getHand().getTotal());
            if (!player.isBust()) {
                if (dealer.isBust()) {
                    //give money
                } else {
                    //compare hands
                }
            }
            //player busts
            else {

            }
            isBetting = true;
            player.clearBet();
        }
    }

    private void deal() {
        player.hit(shoe.pickCard());
        dealer.hit(shoe.pickCard());
        player.hit(shoe.pickCard());

        //dealer's second card starts face down
        Card card = shoe.pickCard();
        card.setFacedown(true);
        dealer.hit(card);
    }

    public void paint(Graphics g) throws IOException {
        g.setColor(new Color(35, 112, 98));
        g.fillRect(0, 0, Main.SIZE_X, Main.SIZE_Y);

        //paint the dealer's hand
        int x = Main.SIZE_X / 2 - 106;
        for (Card card : dealer.getHand().getCards()) {
            card.paint(g, x, 10);
            x += 106;
        }

        //paint the player's hand
        x = Main.SIZE_X / 2 - 106;
        for (Card card : player.getHand().getCards()) {
            card.paint(g, x, Main.SIZE_Y - 350);
            x += 106;
        }
    }
}