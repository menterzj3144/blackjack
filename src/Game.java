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
        shoe = new Shoe(2);
        player = new Player(1000);
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
                player.setState("");
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

                if (player.getHand().getTotal() == 21) {
                    moveOn();
                }
            }
        } else {
            //add a card to player's hand if they have not busted
            if (!player.isBust()) {
                player.hit(shoe.pickCard());
                if (player.isBust() || player.getHand().getTotal() == 21) {
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
            while (dealer.mustHit() && player.getHand().getTotal() != 21) {
                dealer.hit(shoe.pickCard());
            }

            int playerTotal = player.getHand().getTotal();
            int dealerTotal = dealer.getHand().getTotal();

            if (!player.isBust()) {
                if (dealer.isBust()) {
                    player.setState("Win");
                    player.addMoney(player.getBet() * 2);
                } else {
                    if (playerTotal == dealerTotal) {
                        player.setState("Push");
                        player.addMoney(player.getBet());
                    } else if (playerTotal > dealerTotal) {
                        player.setState("Win");
                        if (player.getHand().getCards().size() == 2 && playerTotal == 21) {
                            player.addMoney(player.getBet() * 2.5);
                            player.setState("Blackjack");
                        } else {
                            player.addMoney(player.getBet() * 2);
                        }
                    } else {
                        player.setState("Lose");
                    }
                }
            } else {
                player.setState("Lose");
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


        Font font = new Font("Sans-serif", Font.PLAIN, 30);
        g.setColor(new Color(0,0,0));
        g.setFont(font);
        g.drawString("Money: $" + player.getMoney() + "0", 10, Main.SIZE_Y - 50);
        g.drawString("Bet: $" + player.getBet() + "0", 10, Main.SIZE_Y - 80);
        g.drawString(player.getState(), 100, Main.SIZE_Y / 2);
        if (player.getHand().getTotal() > 0) {
            g.drawString(String.valueOf(player.getHand().getTotal()), Main.SIZE_X - 100, Main.SIZE_Y - 50);
        }
        if (!dealer.getHand().isEmpty() && !dealer.getHand().getCards().get(1).getFacedown()) {
            g.drawString(String.valueOf(dealer.getHand().getTotal()), Main.SIZE_X - 100, 40);
        }
    }
}