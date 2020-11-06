package square.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestPuzzle {

	@Test
	public void testConst() {
		Puzzle p = new Puzzle(3, 3);
		assertEquals (3, p.numColumns);
		assertEquals (3, p.numRows);
	}
	
	@Test
	public void testAdd() {
		Puzzle p = new Puzzle(3, 3);
		Tile t1 = new Tile(9);
		
		p.add(t1, 1, 1);
		
		assertEquals(1,t1.getCol());
		assertEquals(1,t1.getRow());
		assertTrue(p.tiles.contains(t1));

	}
	
	@Test
	public void testGet() {
		Puzzle p = new Puzzle(3, 3);
		Tile t1 = new Tile(9);
		
		p.add(t1, 1, 1);
		
		assertEquals(t1, p.getTile(1, 1));

	}


}
