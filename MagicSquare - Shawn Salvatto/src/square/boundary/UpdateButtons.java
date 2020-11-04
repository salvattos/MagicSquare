package square.boundary;

import java.util.List;

import square.model.MoveType;


public class UpdateButtons {

	public static void enableButtons(MagicSquareApp app, List<MoveType> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getRightButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);

		for (MoveType mt : moves) {
			if (mt == MoveType.Left) {
				app.getLeftButton().setEnabled(true);
			} else if (mt == MoveType.Right) {
				app.getRightButton().setEnabled(true);
			} else if (mt == MoveType.Up) {
				app.getUpButton().setEnabled(true);
			} else if (mt == MoveType.Down) {
				app.getDownButton().setEnabled(true);
			}
		}
	}


}
