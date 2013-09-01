package github.iruuunechka.model;

public interface TetrisModel {
    void pause();
    void play();
    void start();
    void gameOver();

    void moveLeft();
    void moveRight();
    void moveDown();
    void rotate();
}
