package github.iruuunechka.view;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class TetrisViewImpl extends JPanel implements TetrisView {
    private final int gameHeight;
    private final int gameWidth;
    private final int px;


    private static final Color emptyColor = Color.WHITE;
    private static final Color pieceColor = Color.PINK;

    private final BufferedImage[] boards;
    private int activeBoard = 0;

    private void swapBuffers() {
        activeBoard ^= 1;
    }

    public TetrisViewImpl(int gameWidth, int gameHeight, int px) {
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        this.px = px;
        Dimension d = new Dimension(gameWidth * px, gameHeight * px);
        setPreferredSize(d);
        boards = new BufferedImage[] {
                new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB),
                new BufferedImage(d.width, d.height, BufferedImage.TYPE_INT_ARGB)
        };
        Graphics2D g = boards[activeBoard].createGraphics();
        g.setColor(emptyColor);
        for (int i = 0; i < gameWidth; i++) {
            for (int j = 0; j < gameHeight; j++) {
                g.fill3DRect(i * px, j * px, px, px, true);
            }
        }
        g.setColor(pieceColor);
        g.dispose();
    }

    private void paintBoard(Image image) {
        Graphics2D g = (Graphics2D)this.getGraphics();
        if (g != null) {
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }
    }

    @Override
    public void redraw(int[][] oldBlocks, int[][] newBlocks) {
        Graphics2D g = boards[activeBoard].createGraphics();
        g.setColor(emptyColor);
        for (int[] block : oldBlocks) {
            g.fill3DRect(block[0] * px, block[1] * px, px, px, true);
        }
        g.setColor(pieceColor);
        for (int[] block : newBlocks) {
            g.fill3DRect(block[0] * px, block[1] * px, px, px, true);
        }
        g.dispose();
        paintBoard(boards[activeBoard]);
    }

    @Override
    public void deleteLine(int y) {
        BufferedImage top = boards[activeBoard].getSubimage(0, 0, boards[activeBoard].getWidth(), y * px);
        swapBuffers();
        Graphics2D g = boards[activeBoard].createGraphics();
        g.drawImage(top, null, 0, px);
        g.setColor(emptyColor);
        for (int i = 0; i < gameWidth; i++) {
            g.fill3DRect(i * px, 0, px, px, true);
        }
        g.dispose();
        paintBoard(boards[activeBoard]);
    }

    @Override
    public void pause() {
        System.out.println("Paused");
    }

    @Override
    public void play() {
        System.out.println("Play!!!");
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
