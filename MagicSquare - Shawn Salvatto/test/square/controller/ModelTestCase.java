package square.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import square.model.Coordinate;
import square.model.Model;
import square.model.Puzzle;
import square.model.Tile;


class ModelTestCase {

protected Model model;
	

	
	@BeforeEach
	public void setUp() {
		model  = new Model();
		
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
		
		model.setPuzzle(puzzle);
	}
	
	/** Helper test method for location a piece by a coordinate. */
	protected Optional<Tile> getTile(Coordinate c) {
		for (Tile t : model.getPuzzle()) {
			if (t.contains(c)) {
				return Optional.of(t);
			}
		}
		
		return Optional.empty(); 
	}
}
