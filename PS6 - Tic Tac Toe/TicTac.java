import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTac extends JFrame {
	/* this code spits in the face of the MVC paradigm, but my work schedule spits
	 * in the face of my attempts at time management, so I had to rush and do this
	 * in about a day and a half, so it's L's all around! */

	GridSquare[] squares = new GridSquare[9];

	public TicTac() {
		super.setTitle("Unstoppable Force Meets Immovable Object (aka Tic-Tac-Toe)");
		super.setSize(800, 800);
		super.setLayout(new GridLayout(3,3));
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		Board b = new Board(); // instantiating a static class?? blasphemous, but my code throws a tantrum
		this.render();		   // if I try to refactor it for some weird reason
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);

		super.setVisible(true);
	}

	// checks the game on every click for a completion state
	ActionListener gameStateListener = onUpdate -> {
		if (Board.isHasWinner()) {
			JOptionPane.showMessageDialog(this, Board.getTurn() + " wins!\nResetting...");
			Board.reset();
			this.resetButtons();
		}
		if (Board.hasTie()) {
			JOptionPane.showMessageDialog(this, "Cat's game\nResetting...");
			Board.reset();
			this.resetButtons();
		}
	};

	public void resetButtons() {
		for (int i = 0; i < squares.length; i++) {
			squares[i].setState("");
		}
	}

	public void render() {
		for (int i = 0; i < squares.length; i++) {
			int index = i;
			squares[i] = new GridSquare(i);
			super.add(squares[i]);
			squares[i].addActionListener(gameStateListener);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TicTac t = new TicTac();
			}
		});
	}
}