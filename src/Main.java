import javax.swing.*;

/**
 * Zachary Menter and Toby Moszer
 * Last Updated: 3/24/2021
 */
public class Main {

    /**
     * Size of the game in pixels
     */
    public static final int SIZE_X = 1280;
    public static final int SIZE_Y = 720;

    public static void main(String[] args) {

        Game game = new Game();

        JFrame frame = new JFrame("yeet time");

        frame.setSize(SIZE_X, SIZE_Y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        MyPanel panel = new MyPanel(game);

        frame.add(panel);
        frame.addKeyListener(panel);

        panel.setVisible(true);
        frame.setVisible(true);

        frame.repaint();
        panel.repaint();


        while (true) {
            panel.repaint();
        }

    }

}
