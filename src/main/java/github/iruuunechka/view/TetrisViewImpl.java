package github.iruuunechka.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TetrisViewImpl extends JPanel implements TetrisView {
    private final int gameHeight;
    private final int gameWidth;
    private final BufferedImage board;

    public TetrisViewImpl(int gameWidth, int gameHeight, int px) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        Dimension d = new Dimension(gameWidth * px, gameHeight * px);
        setPreferredSize(d);
        board = new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB);
    }

    private void paintBoard() {
        Graphics2D g = (Graphics2D)this.getGraphics();
        if (g != null) {
            g.drawImage(board, 0, 0, null);
            g.dispose();
        }
    }

    private int getBlockSize() {
        return getPreferredSize().width / gameWidth;
    }

    @Override
    public void redraw(int[][] oldBlocks, int[][] newBlocks) {
        int px = getBlockSize();
        Graphics2D g = board.createGraphics();
        g.setColor(Color.WHITE);
        for (int[] block : oldBlocks) {
            g.fill3DRect(block[0] * px, block[1] * px, px, px, true);
        }
        g.setColor(Color.BLACK);
        for (int[] block : newBlocks) {
            g.fill3DRect(block[0] * px, block[1] * px, px, px, true);
        }
        paintBoard();
    }

    @Override
    public void deleteLine(int y) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void play() {

    }

    @Override
    public int getHeight() {
        return gameHeight;
    }

    @Override
    public int getWidth() {
        return gameWidth;
    }
}
