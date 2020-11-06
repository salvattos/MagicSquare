package square.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import square.model.Coordinate;
import square.model.MoveType;

class TestCombineController extends AppTestCase {
	protected SelectTileController stc;
	Point pt;
	CombineTileController ctc;

	@BeforeEach
	public void TCCSetUp() {
		stc = new SelectTileController(model, app);
		pt = coordinateToPoint(new Coordinate(1, 1));
		stc.process(pt);
	}

	@Test
	public void testSelect() {
		assertEquals(new Coordinate(1, 1), app.getPuzzlePanel().pointToCoordinate(pt));
	}

	@Test
	public void testSubtract() {
		ctc = new CombineTileController(model, app);
		assertTrue(ctc.move(MoveType.Left));
		assertEquals(8, model.getPuzzle().getTile(0, 1).getVal());
	}
	
	@Test
	public void testAdd() {
		ctc = new CombineTileController(model, app);
		assertTrue(ctc.move(MoveType.Right));
		assertEquals(3, model.getPuzzle().getTile(2, 1).getVal());
	}
	
	@Test
	public void testMultiply() {
		ctc = new CombineTileController(model, app);
		assertTrue(ctc.move(MoveType.Up));
		assertEquals(6, model.getPuzzle().getTile(1, 0).getVal());
	}
	
	@Test
	public void testFail() {
		ctc = new CombineTileController(model, app);
		assertTrue(ctc.move(MoveType.Left));
		assertTrue(model.isGameLost());
	}
	
	@Test
	public void testWin() {
		ctc = new CombineTileController(model, app);
		
		model.getPuzzle().getTile(0, 0).setShown(false);
		model.getPuzzle().getTile(1, 0).setShown(false);
		model.getPuzzle().getTile(2, 0).setShown(false);
		model.getPuzzle().getTile(2, 1).setShown(false);
		model.getPuzzle().getTile(0, 2).setShown(false);
		model.getPuzzle().getTile(1, 2).setShown(false);
		model.getPuzzle().getTile(2, 2).setShown(false);
		
		pt = coordinateToPoint(new Coordinate(0, 1));
		stc.process(pt);
		
		ctc.move(MoveType.Right);
		
		assertTrue(model.isGameWon());
	}
}
