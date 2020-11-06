package square.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class TestModel{
	
	Model model;
	
	protected Optional<Tile> getTile(Coordinate c) {
		for (Tile t : model.getPuzzle()) {
			if (t.contains(c)) {
				return Optional.of(t);
			}
		}
		
		return Optional.empty(); 
	}
	
	@BeforeEach
	public void setUp() {
		model  = new Model();
		
		Puzzle puzzle = new Puzzle(3, 3);
		
		Tile t = new Tile(1);
		t.setCenter(true);
		puzzle.add(t, 1, 1);

		puzzle.add(new Tile(9), 0, 1);
		puzzle.add(new Tile(3), 2, 1);

		puzzle.add(new Tile(4), 0, 2);
		puzzle.add(new Tile(5), 1, 2);
		puzzle.add(new Tile(7), 2, 2);

		puzzle.add(new Tile(3), 0, 0);
		puzzle.add(new Tile(6), 1, 0);
		puzzle.add(new Tile(8), 2, 0);
		
		model.setPuzzle(puzzle);
	}
	
	
	@Test
	public void testInitialState() {
	
		assertFalse(model.isGameWon());
		assertFalse(model.isGameLost());

		// no moves available.
		assertEquals(0, model.availableMoves().size());
	}

	@Test
	public void testPossibleMove() {
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		assertEquals (1, t.getVal());
		model.setSelectedTile(t);
		
		List<MoveType> available = model.availableMoves();
		assertEquals (3, available.size());
		assertTrue (available.contains(MoveType.Left));
		assertTrue (available.contains(MoveType.Right));
		assertTrue (available.contains(MoveType.Up));
	}
	
	@Test
	public void testSubtract() {
		assertFalse (model.tryMove(MoveType.Left)); 
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (8, model.getPuzzle().getTile(t.getCol() - 1, t.getRow()).getVal());
	}
	
	@Test
	public void testAdd() { //not done
		assertFalse (model.tryMove(MoveType.Right)); 
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Right));
		assertEquals (4, model.getPuzzle().getTile(t.getCol() + 1, t.getRow()).getVal());
	}
	
	@Test
	public void testMult() {//not done
		assertFalse (model.tryMove(MoveType.Up)); 
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Up));
		assertEquals (6, model.getPuzzle().getTile(t.getCol(), t.getRow() - 1).getVal());
	}
	
	@Test
	public void testDiv() { //not done
		assertFalse (model.tryMove(MoveType.Down)); 
		Tile t = this.getTile(new Coordinate(1, 0)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Down));
		assertEquals (6, model.getPuzzle().getTile(t.getCol(), t.getRow() + 1).getVal());
	}
	
	@Test
	public void testBadMoves() {
		Tile t = this.getTile(new Coordinate(2,0)).get(); 
		model.setSelectedTile(t);
		assertEquals (0, model.availableMoves().size());
	}
	
	@Test
	public void testReset() {
		assertFalse (model.tryMove(MoveType.Left)); 
		Tile t = this.getTile(new Coordinate(1, 1)).get(); 
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (8,  model.getPuzzle().getTile(0,1).getVal());
		
		model.resetPuzzle();
		t = this.getTile(new Coordinate(0, 1)).get(); 
		assertEquals(9, t.getVal());
	}
	
	@Test
	public void testWinOrLose() {
		assertFalse (model.isGameLost());
		model.setGameLost(true);
		assertTrue (model.isGameLost());
		model.setGameLost(false);
		
		assertFalse (model.isGameWon());
		model.setGameWon(true);
		assertTrue (model.isGameWon());
		model.setGameWon(false);

	}
	
}
