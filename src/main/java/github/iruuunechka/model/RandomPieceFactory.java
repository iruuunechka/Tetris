package github.iruuunechka.model;

import java.util.Random;

public class RandomPieceFactory implements PieceFactory {
    private final int[][][][] piecePool;
    private final Random random = new Random();

    public RandomPieceFactory(int[][][][] piecePool) {
        this.piecePool = piecePool;
    }

    @Override
    public Piece createPiece() {
        return new PieceImpl(piecePool[random.nextInt(piecePool.length)]);
    }
}
