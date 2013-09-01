package github.iruuunechka.model;

public interface PieceFactory {
    Piece createPiece();
    void setStartPosition(int x, int y);
}
