package github.iruuunechka.model;

public interface TetrisModel {
    void pause();
    void start();

    void moveLeft();
    void moveRight();
    void moveDown();
    void rotate();
}
