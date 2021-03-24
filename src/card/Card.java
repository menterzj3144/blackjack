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

    /**
     * If the card is facedown
     */
    private boolean facedown = false;

    /**
     * Size of the card
     */
    private final int SIZE_X = 212;
    private final int SIZE_Y = 300;


    /**
     * Creates a new card
     * @param type type of card (2, 3, King, Ace, etc.)
     * @param value integer value of the card
     * @param suit String of the suit of the card
     */
    Card(String type, int value, String suit) {
        this.type = type;
        this.value = value;
        this.suit = suit;
    }

    /**
     * Returns the card type
     * @return String of the card type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Returns the value of the card
     * @return integer value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Prints the card to the console
     * @return String representation of the card
     */
    public String toString() {
        return type + " of " + suit;
    }

    /**
     * Sets the facedown value
     * @param facedown boolean value of facedown
     */
    public void setFacedown(Boolean facedown) {
        this.facedown = facedown;
    }

    public boolean getFacedown() {
        return facedown;
    }

    /**
     * Paints the card to the screen
     * @param g
     * @param positionX x-position of the card
     * @param positionY y-position of the card
     * @throws IOException
     */
    public void paint(Graphics g, int positionX, int positionY) throws IOException {
       BufferedImage image;

        if (facedown) {
            image = ImageIO.read(new File("cards\\zach.png"));
        } else {
            image = ImageIO.read(new File("cards\\" + type.toLowerCase() + "_of_" + suit.toLowerCase() + ".png"));
        }
        Image scaledImage = image.getScaledInstance(SIZE_X, SIZE_Y, Image.SCALE_DEFAULT);
        g.drawImage(scaledImage, positionX, positionY, null);
    }
}