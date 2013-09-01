package github.iruuunechka.model;

import java.util.Random;

public class RandomPieceFactory implements PieceFactory {
    private final Random random = new Random();

    private static final int[][][][] piecePool = new int[][][][] {
        // square
        new int[][][] {
            // 0 rotation
//            new int[][] {
//                // x
//                new int[] {0, 1, 0, 1},
//                //y
//                new int[] {0, 0, 1, 1}
//            }
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
            // 0 rotation
            new int[][] {
//                new int[] {0, 1, 2, 3},
//                new int[] {0, 0, 0, 0}
                new int[] {0, 0},
                new int[] {1, 0},
                new int[] {2, 0},
                new int[] {3, 0},
            },
//          // 1 rotation
            new int[][] {
//                //x
//                new int[] {0, 0, 0, 0},
//                //y
//                new int[] {0, 1, 2, 3}
                new int[] {0, 0},
                new int[] {0, 1},
                new int[] {0, 2},
                new int[] {0, 3},
            }
        }
    };


    @Override
    public Piece createPiece() {
        System.out.println(random.nextInt(piecePool.length));
        return new PieceImpl(piecePool[random.nextInt(piecePool.length)]);
    }
}
