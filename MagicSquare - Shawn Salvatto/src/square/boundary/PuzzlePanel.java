package square.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import square.model.Coordinate;
import square.model.Model;
import square.model.Puzzle;
import square.model.Tile;

public class PuzzlePanel extends JPanel {

	Model model;
	public static final int sideSize = 100;
	public static final int offset = 2;
	String s;

	public PuzzlePanel(Model m) {
		this.model = m;
	}

	public Rectangle computeRectangle(Tile t) {
		int col = t.getCol();
		int row = t.getRow();
		// DEFECT v
		Rectangle rect = new Rectangle(col * sideSize + offset, row * sideSize + offset, sideSize - 2 * offset,
				sideSize - 2 * offset);

		return rect;
	}

	public Coordinate pointToCoordinate(Point p) {
		return new Coordinate(p.x / sideSize, p.y / sideSize);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// String stuff
		Font font = new Font("Arial", Font.BOLD, 48);

		if (model == null) {
			return;
		}

		Puzzle puzzle = model.getPuzzle();
		Tile selectedTile = model.getSelectedTile();

		for (Tile t : puzzle) {

			g.setColor(Color.yellow);
			
			if (t.equals(selectedTile)) { // sets selected tile then chages color
				g.setColor(Color.yellow);
			} else if(t.isShown()) {
				g.setColor(Color.gray);
			} else {
				g.setColor(Color.DARK_GRAY);
			}

		
			
			if(model.isGameWon()) {
				if(t.isCenter()) {
					g.setColor(Color.RED);
				}
			}
			
			Rectangle r = computeRectangle(t);
			g.fillRect(r.x, r.y, r.width, r.height);

			if (t.isShown()) {
				s = Integer.toString(t.getVal());
			} else {
				s = "";
			}
			g.setFont(font);
			FontMetrics fm = g.getFontMetrics();

			g.setColor(Color.BLACK);
			g.drawString(s, r.x + sideSize / 2 - fm.stringWidth(s) / 2, r.y + sideSize / 2 + fm.getHeight() / 2);

		}

	}

}
