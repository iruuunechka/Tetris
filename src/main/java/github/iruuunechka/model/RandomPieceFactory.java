package github.iruuunechka.model;

import java.util.Random;

public class RandomPieceFactory implements PieceFactory {
    private final Random random = new Random();

    private static final int[][][][] piecePool = new int[][][][] {
        // square
        new int[][][] {
            // 0 rotation
            new int[][] {
                // x
                new int[] {0, 1, 0, 1},
                //y
                new int[] {0, 0, 1, 1}
            }
        },
        // line
        new int[][][] {
            // 0 rotation
            new int[][] {
                // x
                new int[] {0, 1, 2, 3},
                // y
                new int[] {0, 0, 0, 0}
            },
            // 1 rotation
            new int[][] {
                //x
                new int[] {0, 0, 0, 0},
                //y
                new int[] {0, 1, 2, 3}
            }
        }
    };


    @Override
    public Piece createPiece() {
        return new PieceImpl(piecePool[random.nextInt(piecePool.length)]);
    }
}
