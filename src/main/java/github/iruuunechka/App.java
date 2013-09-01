package github.iruuunechka;

import github.iruuunechka.view.TetrisFrame;
import github.iruuunechka.view.TetrisViewImpl;

public class App {
    public static void main( String[] args ) {
        TetrisViewImpl view = new TetrisViewImpl(20, 40, 10);
        new TetrisFrame(view);
    }
}
