package square.controller;

import java.awt.Point;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import square.boundary.MagicSquareApp;
import square.boundary.PuzzlePanel;
import square.model.Coordinate;
import square.model.Model;


public class AppTestCase extends ModelTestCase{
protected MagicSquareApp app;
	
	@BeforeEach
	public void createApp() {
		app = new MagicSquareApp(model);
		app.setVisible(true);
	}
	
	@AfterEach
	public void tearDown() throws Exception {
		app.setVisible(false);
	}
	
	/** 
	 * Map a Coordinate in puzzle to mouse point at center of square.
	 * 
	 * @param  c       Desired Coordinate.
	 * @return Point   Associated with the center of a square with given coordinate. 
	 */
	public static Point coordinateToPoint(Coordinate c) {
		return new Point(c.col * PuzzlePanel.sideSize + PuzzlePanel.sideSize/2, c.row * PuzzlePanel.sideSize + PuzzlePanel.sideSize/2);
	}
}
