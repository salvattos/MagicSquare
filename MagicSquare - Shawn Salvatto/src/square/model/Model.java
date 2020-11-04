package square.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
	Puzzle puzzle;
	Tile selectedTile;
	boolean gameWon;
	boolean gameLost;

	public Model() {

	}

	public void setPuzzle(Puzzle p) {
		puzzle = p;
		gameWon = false;
		gameLost = false;
		selectedTile = null;
	}

	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setSelectedTile(Tile t) {
		selectedTile = t;
	}

	public void clearSelectedTile() {
		selectedTile = null;
	}

	public Tile getSelectedTile() {
		return selectedTile;
	}

	public boolean isGameWon() {
		return gameWon;
	}

	public void setGameWon(boolean flag) {
		gameWon = flag;
	}

	public boolean isGameLost() {
		return gameLost;
	}

	public void setGameLost(boolean flag) {
		gameLost = flag;
	}

	public void resetPuzzle() {
		selectedTile = null;

		puzzle.reset();

		gameWon = false;
		gameLost = false;

	}

	public List<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();

		if (selectedTile == null) {
			return moves;
		}

		return availableMoves(selectedTile);
	}

	public List<MoveType> availableMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		Coordinate coord = t.getLocation();

		// left - subtraction
		if (coord.col > 0 && puzzle.getTile(coord.col - 1, coord.row).isShown()) {
			boolean valid = false;

			if (puzzle.getTile(coord.col - 1, coord.row).getVal() - t.getVal() > 0) {
				valid = true;
			}

			if (valid) {
				moves.add(MoveType.Left);
			}
		}

		// right - addition
		if (coord.col + 1 < puzzle.numColumns && puzzle.getTile(coord.col + 1, coord.row).isShown()) {

			moves.add(MoveType.Right);

		}

		// up - multiplication
		if (coord.row > 0 && puzzle.getTile(coord.col, coord.row - 1).isShown) {
			moves.add(MoveType.Up);
		}

		// down - division
		if (coord.row + 1 < puzzle.numRows && puzzle.getTile(coord.col, coord.row + 1).isShown()) {
			boolean valid = false;

			if ((t.getVal() % puzzle.getTile(coord.col, coord.row + 1).getVal()) == 0) {
				valid = true;
			}

			if (valid) {
				moves.add(MoveType.Down);
			}
		}

		return moves;
	}

	public boolean tryMove(MoveType dir) {
		if (selectedTile == null) {
			return false;
		}
		Coordinate coord = selectedTile.getLocation();

		// left - subtraction
		if (dir == MoveType.Left) {
			selectedTile.subtract(puzzle.getTile(coord.col - 1, coord.row));
			selectedTile = null;
			return true;
		}

		// Right - addition
		if (dir == MoveType.Right) {
			selectedTile.add(puzzle.getTile(coord.col + 1, coord.row));
			selectedTile = null;
			return true;
		}

		// Up - multiplication
		if (dir == MoveType.Up) {
			selectedTile.multiply(puzzle.getTile(coord.col, coord.row - 1));
			selectedTile = null;
			return true;
		}

		// Down - division
		if (dir == MoveType.Down) {
			selectedTile.divide(puzzle.getTile(coord.col, coord.row + 1));
			selectedTile = null;
			return true;
		}

		return true;
	}

	public boolean isWinCondition() {
		for(Tile t : puzzle) {
			if(t.isShown && !t.isCenter) {
				return false;
			}
		}
		System.out.println("won");
		return true;
	}

	public boolean isLostCondition() {
		ArrayList<Tile> tilesLeft = new ArrayList<>();

		// if the user moves the center tile out they lose automatically
		for (Tile t : puzzle) {
			if (t.isCenter && !t.isShown) {
				System.out.println("Lost");
				return true;
			}
		}
		
		//if there are no valid moves left - see if any shown tile has available moves
		boolean isLost = true;
		
		for(Tile t : puzzle) {
			if(t.isShown) {
				tilesLeft.add(t);
			}
		}
		
		for(Tile t : tilesLeft) {
			if(!t.isCenter) {
			if(!availableMoves(t).isEmpty()) {
				isLost = false;
			}
			}
		}
		
		if(isLost) {
			System.out.println("Lost");
			return true;
		}
		
		return false;
	}

}
