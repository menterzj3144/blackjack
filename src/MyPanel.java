import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyPanel extends JPanel {

    private Game game;

    MyPanel(Game game) {
        this.game = game;
    }

    public void paintComponent(Graphics g) {
        try {
            game.paint(g);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
