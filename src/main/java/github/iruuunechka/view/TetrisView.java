package github.iruuunechka.view;

public interface TetrisView {
    void redraw(int[][] oldBlocks, int[][] newBlocks);
    void deleteLine(int y);

    void pause();
    void play();

    int getHeight();
    int getWidth();
}
