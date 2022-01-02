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
    private final Shoe shoe;

    /**
     * The dealer of the game
     */
    private final Dealer dealer;

    /**
     * The player of the game
     */
    private final Player player;

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
     * Raises the betting interval
     */
    public void raiseInterval() {
        if (isBetting) {
            player.raiseInterval();
        }
    }

    /**
     * Lowers the betting interval
     */
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
                System.err.println("You need to bet.");
            } else {
                //set isBetting to false and deal cards
                isBetting = false;
                deal();

                //if player is dealt a blackjack
                if (player.getHand().getTotal() == 21) {
                    finishHand();
                }
            }
        } else {
            //add a card to player's hand if they have not busted
            if (!player.isBust()) {
                player.hit(shoe.pickCard());
                if (player.isBust() || player.getHand().getTotal() == 21) {
                    finishHand();
                }
            }
        }
    }

    /**
     * Checks player and dealer totals, finds out who won
     */
    public void finishHand() {
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
                        if (player.getHand().getCards().size() == 2 && playerTotal == 21) {
                            player.setState("Blackjack");
                            player.addMoney(player.getBet() * 2.5);
                        } else {
                            player.setState("Win");
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
     * Doubles the player's bet if they have enough money and if they have two cards
     */
    public void doubleBet() {
        if (player.getHand().getCards().size() == 2) {
            if (player.doubleBet()) {
                player.hit(shoe.pickCard());
                finishHand();
            } else {
                System.err.println("Not enough funds.");
            }
        }
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
            card.paint(g, x, 10);
            x += 106;
        }

        //paint the player's hand
        x = Main.SIZE_X / 2 - 159;
        for (Card card : player.getHand().getCards()) {
            card.paint(g, x, Main.SIZE_Y - 350);
            x += 106;
        }


        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Sans-serif", Font.PLAIN, 30));
        g.drawString("Money: $" + player.getMoney() + "0", 10, Main.SIZE_Y - 50);
        g.drawString("Bet: $" + player.getBet() + "0", 10, Main.SIZE_Y - 80);
        g.drawString("Chip: $" + player.getBettingInterval() + "0", 10, Main.SIZE_Y - 110);
        if (player.getHand().getTotal() > 0) {
            g.drawString(String.valueOf(player.getHand().getTotal()), Main.SIZE_X - 100, Main.SIZE_Y - 50);
        }
        if (!dealer.getHand().isEmpty() && !dealer.getHand().getCards().get(1).getFacedown()) {
            g.drawString(String.valueOf(dealer.getHand().getTotal()), Main.SIZE_X - 100, 40);
        }

        g.setFont(new Font("Sans-serif", Font.ITALIC, 50));
        g.drawString(player.getState(), 100, Main.SIZE_Y / 2 - 15);
    }
}