package square.controller;

import javax.swing.JOptionPane;

import square.boundary.MagicSquareApp;



public class ExitController {
	MagicSquareApp app;
	
	public ExitController(MagicSquareApp app) {
		this.app = app;
	}
	

	public void exit() {

		int c = JOptionPane.showConfirmDialog(app, "Do you wish to exit application?");
		if (c == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
		
	}
}