package github.iruuunechka.model;

public class PieceImpl implements Piece{
    private int x;
    private int y;
    private int[][][] form;
    private int cur;

    public PieceImpl(int[][][] form) {
        this.form = form;
    }

    private PieceImpl(int[][][] form, int x, int y, int cur) {
        this.form = form;
        this.x = x;
        this.y = y;
        this.cur = cur;
    }

    private int[][] getForm(int pos) {
        int[][] blocks = new int[form[pos].length][form[pos][0].length];
        for (int i = 0; i < form[pos].length; ++i) {
            System.arraycopy(form[pos][i], 0, blocks[i], 0, form[pos][i].length);
        }
        return blocks;
    }

    private int[][] getCurrentPos(int[][] block) {
        for (int i = 0; i < block.length; ++i) {
            block[i][0] += x;
            block[i][1] += y;
        }
        return block;
    }

    @Override
    public int[][] getBlocks() {
        return getCurrentPos(getForm(cur));
    }

    @Override
    public int[][] getRotatedBlocks() {
        return getCurrentPos(getForm((cur + 1) % form.length));
    }

    @Override
    public int[][] getDownBlocks() {
        int[][] block = getBlocks();
        for (int i = 0; i < block.length; ++i) {
            block[i][1] += 1;
        }
        return block;
    }

    @Override
    public int[][] getLeftBlocks() {
        int[][] block = getBlocks();
        for (int i = 0; i < block.length; ++i) {
            block[i][0] -= 1;
        }
        return block;
    }

    @Override
    public int[][] getRightBlocks() {
        int[][] block = getBlocks();
        for (int i = 0; i < block.length; ++i) {
            block[i][0] += 1;
        }
        return block;
    }

    @Override
    public void rotate() {
        cur = (cur + 1) % form.length;
    }

    @Override
    public void left() {
        x--;
    }

    @Override
    public void right() {
        x++;
    }

    @Override
    public void down() {
        y++;
    }

    public Piece copy() {
        int[][][] formCopy = new int[form.length][form[0].length][form[0][0].length];
        for (int i = 0; i < form.length; ++i) {
            formCopy[i] = getForm(i);
        }
        return new PieceImpl(formCopy, x, y, cur);
    }

}
