package square;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import square.boundary.MagicSquareApp;
import square.controller.ExitController;
import square.model.Model;
import square.model.Puzzle;
import square.model.Tile;

public class Main {

	public static void main(String[] args) {

		Model m = new Model();
		
		
		Puzzle puzzle = new Puzzle(3, 3);
		Tile t = new Tile(1);
		t.setCenter(true);
		puzzle.add(t, 1, 1);

		puzzle.add(new Tile(9), 0, 1);
		puzzle.add(new Tile(2), 2, 1);

		puzzle.add(new Tile(4), 0, 2);
		puzzle.add(new Tile(5), 1, 2);
		puzzle.add(new Tile(7), 2, 2);

		puzzle.add(new Tile(3), 0, 0);
		puzzle.add(new Tile(6), 1, 0);
		puzzle.add(new Tile(8), 2, 0);
		
		m.setPuzzle(puzzle);

		
		MagicSquareApp app = new MagicSquareApp(m);
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		app.setVisible(true);
		
	}

}
