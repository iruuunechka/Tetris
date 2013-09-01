package github.iruuunechka;

import github.iruuunechka.controller.TetrisController;
import github.iruuunechka.model.RandomPieceFactory;
import github.iruuunechka.model.TetrisModel;
import github.iruuunechka.model.TetrisModelImpl;
import github.iruuunechka.view.TetrisFrame;
import github.iruuunechka.view.TetrisViewImpl;

public class App {
    public static void main( String[] args ) {
        TetrisViewImpl view = new TetrisViewImpl(20, 40, 10);
        TetrisModelImpl model = new TetrisModelImpl(view, 1000, new RandomPieceFactory());
        view.addKeyListener(new TetrisController(model));
        new TetrisFrame(view);
        model.run();
    }
}
