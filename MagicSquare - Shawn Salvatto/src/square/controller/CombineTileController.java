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

public class CombineTileController {
	Model model;
	MagicSquareApp app;

	public CombineTileController(Model m, MagicSquareApp app) {
		this.model = m;
		this.app = app;
	}

	public boolean move(MoveType dir) {
		if (model.getSelectedTile() == null) {
			return false;
		}

		if (model.tryMove(dir)) {

			UpdateButtons.enableButtons(app, model.availableMoves());

			app.repaint();

		}

		// win checker
		if (model.isWinCondition()) {
			model.setGameWon(true);
			app.getlblEndScreen().setText("You've Won!");
			app.getlblEndScreen().setVisible(true);
			app.repaint();
			return true;
		}

		// lose checker
		if (model.isLostCondition()) {
			model.setGameLost(true);
			app.getlblEndScreen().setText("You Lose :(");
			app.getlblEndScreen().setVisible(true);
			app.repaint();
			return true;
		}

		return true;
	}
}
