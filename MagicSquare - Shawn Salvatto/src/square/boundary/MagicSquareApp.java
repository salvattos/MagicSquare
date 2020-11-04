package square.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import square.controller.CombineTileController;
import square.controller.ResetTilesController;
import square.controller.SelectTileController;
import square.model.Model;
import square.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MagicSquareApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	Model model;

	JButton btnUp;
	JButton btnDown;
	JButton btnLeft;
	JButton btnRight;
	JButton btnReset;
	JLabel lblEndScreen;
	
	

	public PuzzlePanel getPuzzlePanel() {
		return panel;
	}

	public JLabel getlblEndScreen() {
		return lblEndScreen;
	}
	
	public JButton getUpButton() {
		return btnUp;
	}

	public JButton getDownButton() {
		return btnDown;
	}

	public JButton getLeftButton() {
		return btnLeft;
	}

	public JButton getRightButton() {
		return btnRight;
	}

	public JButton gerResetButton() {
		return btnReset;
	}

	/**
	 * Create the frame.
	 */
	public MagicSquareApp(Model m) {
		super();
		this.model = m;

		setTitle("Magic Square");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 750, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new PuzzlePanel(model);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectTileController(model, MagicSquareApp.this).process(me.getPoint());
			}
		});

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 new ResetTilesController(model, MagicSquareApp.this).reset();
			 }
		 });

		btnUp = new JButton("X");
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnUp.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 new CombineTileController(model, MagicSquareApp.this).move(MoveType.Up);
			 }
		 });

		btnDown = new JButton("\u00F7");
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnDown.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 new CombineTileController(model, MagicSquareApp.this).move(MoveType.Down);
			 }
		 });

		btnLeft = new JButton("-");
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLeft.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 new CombineTileController(model, MagicSquareApp.this).move(MoveType.Left);
			 }
		 });

		btnRight = new JButton("+");
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnRight.addActionListener(new ActionListener() {
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 new CombineTileController(model, MagicSquareApp.this).move(MoveType.Right);
			 }
		 });
		
		lblEndScreen = new JLabel("You've Won!");
		lblEndScreen.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblEndScreen.setVisible(false);
		
	

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(97)
							.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDown, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
								.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(175))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnReset)
							.addGap(149))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(167)
					.addComponent(lblEndScreen)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnReset)
							.addGap(88)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnUp, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addGap(40)
									.addComponent(btnDown, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnRight, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnLeft, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
					.addComponent(lblEndScreen)
					.addGap(52))
		);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());
	}
}
