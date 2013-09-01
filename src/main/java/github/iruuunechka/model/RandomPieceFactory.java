package github.iruuunechka.model;

import java.util.Random;

public class RandomPieceFactory implements PieceFactory {
    private final Random random = new Random();
    private int startPosX = 0;
    private int startPosY = 0;
    private static final int[][][][] piecePool = new int[][][][] {
        // square
        new int[][][] {
            new int[][] {
                //x,y
                new int[] {0, 0},
                new int[] {0, 1},
                new int[] {1, 0},
                new int[] {1, 1},
            }
        },
        // line
        new int[][][] {
            new int[][] {
                new int[] {0, 0},
                new int[] {1, 0},
                new int[] {2, 0},
                new int[] {3, 0},
            },
          // 1 rotation
            new int[][] {
                new int[] {0, 0},
                new int[] {0, 1},
                new int[] {0, 2},
                new int[] {0, 3},
            }
        }
    };


    @Override
    public Piece createPiece() {
        return new PieceImpl(piecePool[random.nextInt(piecePool.length)], startPosX, startPosY);
    }

    @Override
    public void setStartPosition(int x, int y) {
        startPosX = x;
        startPosY = y;
    }
}
