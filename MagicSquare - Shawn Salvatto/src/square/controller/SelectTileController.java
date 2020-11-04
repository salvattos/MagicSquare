package square.controller;

import java.awt.Point;
import java.util.List;

import square.boundary.MagicSquareApp;
import square.boundary.UpdateButtons;
import square.model.Coordinate;
import square.model.Model;
import square.model.MoveType;
import square.model.Puzzle;
import square.model.Tile;

public class SelectTileController {
	Model model;
	MagicSquareApp app;

	public SelectTileController(Model m, MagicSquareApp app) {
		this.model = m;
		this.app = app;
	}

	public void process(Point point) {

		Coordinate c = app.getPuzzlePanel().pointToCoordinate(point);
		Puzzle puzzle = model.getPuzzle();

		for (Tile t : puzzle) {
			if (t.contains(c) && t.isShown()) {
				model.clearSelectedTile();
				model.setSelectedTile(t);

				List<MoveType> moves = model.availableMoves(t);

				if (model.isGameWon() || model.isGameLost()) {
					moves.clear();
				}
				UpdateButtons.enableButtons(app, moves);

				app.repaint();
			}
		}
	}

}
