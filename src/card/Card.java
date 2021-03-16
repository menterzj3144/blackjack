package card;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Represents a card
 */
public class Card {

    /**
     * Symbol shown on the card
     */
    private String type;

    /**
     * Numerical value of the card
     */
    private int value;

    /**
     * Suit of the card
     */
    private String suit;

    private final int SIZE_X = 212;

    private final int SIZE_Y = 300;

    Card(String type, int value, String suit) {
        this.type = type;
        this.value = value;
        this.suit = suit;
    }

    public String getType() {
        return this.type;
    }

    public int getValue() {
        return this.value;
    }

    public String getSuit() {
        return suit;
    }

    public String toString() {
        return type + " of " + suit;
    }

    public void paint(Graphics g, int positionX, int positionY) throws IOException {
        BufferedImage image = ImageIO.read(new File("cards\\" + type.toLowerCase() + "_of_" + suit.toLowerCase() + ".png"));
        Image scaledImage = image.getScaledInstance(SIZE_X, SIZE_Y, Image.SCALE_DEFAULT);
        g.drawImage(scaledImage, positionX, positionY, null);
    }
}