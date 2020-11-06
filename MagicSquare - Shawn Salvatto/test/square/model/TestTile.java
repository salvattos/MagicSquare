package square.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import square.model.Tile;

class TestTile {

	
	@Test
	void testConstruction() {
		Tile t = new Tile(1);
		assertEquals(1, t.getVal());
		assertTrue(t.isShown());
		assertFalse(t.isCenter());
	}

	@Test
	void testCopy() {
		Tile t = new Tile(1);
		Tile n = t.copy();
		assertEquals(n.getVal(), t.getVal());
		assertEquals(n.isShown(), t.isShown());
		assertEquals(n.isCenter(), t.isCenter());
	}
	
	@Test
	void testAdd() {
		Tile t = new Tile(1);
		Tile t2 = new Tile(2);
		
		t.add(t2);
		
		assertEquals(3, t2.getVal());
		assertFalse(t.isShown());
	}
	
	@Test
	void testSubtract() {
		Tile t = new Tile(1);
		Tile t2 = new Tile(2);
		
		t.subtract(t2);
		
		assertEquals(1, t2.getVal());
		assertFalse(t.isShown());
	}
	
	@Test
	void testMult() {
		Tile t = new Tile(4);
		Tile t2 = new Tile(2);
		
		t.multiply(t2);
		
		assertEquals(8, t2.getVal());
		assertFalse(t.isShown());
	}
	
	@Test
	void testDiv() {
		Tile t = new Tile(4);
		Tile t2 = new Tile(2);
		
		t.divide(t2);
		
		assertEquals(2, t2.getVal());
		assertFalse(t.isShown());
	}
	

	
}
