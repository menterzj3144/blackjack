import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class MyPanel extends JPanel implements KeyListener {

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(e.getKeyCode() + " " + e.getKeyChar());

        //left
        if (e.getKeyCode() == 37) {
            System.out.println("yet");
        }
        //up
        else if (e.getKeyCode() == 38) {
            game.raiseBet();
        }
        //right
        else if (e.getKeyCode() == 39) {

        }
        //down
        else if (e.getKeyCode() == 40) {
            game.lowerBet();
        }
        //space
        else if (e.getKeyCode() == 32) {
            game.hit();
        }
        //enter
        else if (e.getKeyCode() == 10) {
            game.moveOn();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
