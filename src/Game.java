import card.Card;
import card.Shoe;
import gamblers.Dealer;
import gamblers.Player;

import java.awt.*;
import java.io.IOException;

/**
 * Represents a game
 */
public class Game {

    /**
     * The shoe of cards in the game
     */
    private Shoe shoe;

    /**
     * The dealer of the game
     */
    private Dealer dealer;

    /**
     * The player of the game
     */
    private Player player;

    /**
     * If the player is betting or not
     */
    private boolean isBetting;

    /**
     * Creates a new game
     */
    Game() {
        shoe = new Shoe(5);
        player = new Player(100);
        dealer = new Dealer();
        isBetting = true;
    }

    /**
     * Raises the player's bet
     */
    public void raiseBet() {
        if (isBetting) {
            if (!dealer.getHand().isEmpty()) {
                player.getHand().clear();
                dealer.getHand().clear();
            }
            player.raiseBet();
        }
    }

    /**
     * Lowers the player's bet
     */
    public void lowerBet() {
        if (isBetting) {
            player.lowerBet();
        }
    }

    public void raiseInterval() {
        if (isBetting) {
            player.raiseInterval();
        }
    }

    public void lowerInterval() {
        if (isBetting) {
            player.lowerInterval();
        }
    }

    /**
     * Adds cards to the player's hand
     */
    public void hit() {
        if (isBetting) {
            //player cannot bet zero
            if (player.getBet() == 0) {
                System.err.println("Ya gotta bet bitch");
            } else {
                //set isBetting to false and deal cards
                isBetting = false;
                deal();
                System.out.println("Player total: " + player.getHand().getTotal());

                if (player.getHand().getTotal() == 21) {
                    moveOn();
                }
            }
        } else {
            //add a card to player's hand if they have not busted
            if (!player.isBust()) {
                player.hit(shoe.pickCard());
                System.out.println("Player total: " + player.getHand().getTotal());
                if (player.isBust()) {
                    moveOn();
                }
            }
        }
    }

    /**
     * Checks player and dealer totals, finds out who won
     */
    public void moveOn() {
        if (!dealer.getHand().isEmpty()) {
            dealer.getHand().getCards().get(1).setFacedown(false);
            while (dealer.mustHit()) {
                dealer.hit(shoe.pickCard());
            }

            int playerTotal = player.getHand().getTotal();
            int dealerTotal = dealer.getHand().getTotal();

            System.out.println("Dealer total: " + dealerTotal);
            if (!player.isBust()) {
                if (dealer.isBust()) {
                    //give money
                    System.out.println("Win");
                    player.addMoney(player.getBet() * 2);
                } else {
                    //compare hands
                    if (playerTotal == dealerTotal) {
                        System.out.println("Push");
                        player.addMoney(player.getBet());
                    } else if (playerTotal > dealerTotal) {
                        System.out.println("Win");
                        if (player.getHand().getCards().size() == 2 && playerTotal == 21) {
                            player.addMoney(player.getBet() * 2.5);
                        } else {
                            player.addMoney(player.getBet() * 2);
                        }
                    } else {
                        System.out.println("Lose");
                    }
                }
            } else {
                System.out.println("Lose");
            }
            isBetting = true;
            player.clearBet();
        }
    }

    /**
     * Deals the initial cards for the hand
     */
    private void deal() {
        player.hit(shoe.pickCard());
        dealer.hit(shoe.pickCard());
        player.hit(shoe.pickCard());

        //dealer's second card starts face down
        Card card = shoe.pickCard();
        card.setFacedown(true);
        dealer.hit(card);
    }

    /**
     * Paints the game to the screen
     * @param g
     * @throws IOException
     */
    public void paint(Graphics g) throws IOException {
        g.setColor(new Color(35, 112, 98));
        g.fillRect(0, 0, Main.SIZE_X, Main.SIZE_Y);

        //paint the dealer's hand
        int x = Main.SIZE_X / 2 - 159;
        for (Card card : dealer.getHand().getCards()) {
            card.paint(g, x, 40);
            x += 106;
        }

        //paint the player's hand
        x = Main.SIZE_X / 2 - 159;
        for (Card card : player.getHand().getCards()) {
            card.paint(g, x, Main.SIZE_Y - 390);
            x += 106;
        }
    }
}