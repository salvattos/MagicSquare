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



public class ResetTilesController {
	Model model;
	MagicSquareApp app;

	public ResetTilesController(Model m, MagicSquareApp app) {
		this.model = m;
		this.app = app;
	}

	public void reset() {

		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.availableMoves());
		app.getlblEndScreen().setVisible(false);
		app.repaint();

	}

}
