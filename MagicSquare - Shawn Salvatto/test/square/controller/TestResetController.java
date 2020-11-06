package square.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import square.model.Coordinate;
import square.model.MoveType;
import square.model.Tile;


class TestResetController extends AppTestCase {

	@Test
	public void testReset() {
		Tile t = this.getTile(new Coordinate(1,1)).get(); // piece in bottom of '012' state
		model.setSelectedTile(t);
		assertTrue (model.tryMove(MoveType.Left));
		assertEquals (8, model.getPuzzle().getTile(0,1).getVal()); 
		
		ResetTilesController rpc = new ResetTilesController(model, app);
		rpc.reset();
		assertEquals (9, model.getPuzzle().getTile(0,1).getVal());  
	}

}
