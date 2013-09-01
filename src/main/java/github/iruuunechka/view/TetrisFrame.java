package github.iruuunechka.view;

import javax.swing.*;

/**
 * @author Arkady Rost
 */
public class TetrisFrame extends JFrame {

    public TetrisFrame(JPanel panel) {
        getContentPane().add(panel);
        pack();
        setTitle("Tetris Game");
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.requestFocusInWindow();
    }
}
