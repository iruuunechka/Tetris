package github.iruuunechka.model;

/**
 * @author Irene Petrova
 */
public interface Piece {
    int[][] getBlocks();
    int[][] getRotatedBlocks();
    int[][] getDownBlocks();
    int[][] getLeftBlocks();
    int[][] getRightBlocks();
    void rotate();
    void left();
    void right();
    void down();
}
