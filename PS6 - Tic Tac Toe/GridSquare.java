import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridSquare extends JButton implements ActionListener {
    private String squareState;
    private final int index;
    ImageIcon X;
    ImageIcon O;

    public GridSquare(int index) {
        this.squareState = "";
        this.index = index;
        X = new ImageIcon(this.getClass().getResource("X.jpg")); // Andrew Yang when someone says "UBI" or "Math"
        O = new ImageIcon(this.getClass().getResource("O.png")); // Gordon Ramsay when he can't find the lamb sauce

        X = (ImageIcon) resizeIcon(X, 260, 260);
        O = (ImageIcon) resizeIcon(O, 260, 260);
        this.addActionListener(this);
    }

    public String getSquareState() {
        return squareState;
    }

    private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
        Image img = icon.getImage();
        Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void setState(String input) {
        this.squareState = input;
        if (squareState.equals("X")) {
            this.setIcon(X);
        } else if (squareState.equals("O")) {
            this.setIcon(O);
        } else {
            this.setIcon(null);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (squareState.equals("") && !Board.isHasWinner()) {
            if (Board.isBoardIsReady()) {
                setState(Board.getTurn());
                Board.setSquare(index);
            } else {
                Board.setBoardIsReady();
            }

            System.out.println(Board.getTurn() + " placed at index " + index);
            Board.checkForWinner();
            if (!Board.isHasWinner()) {
                Board.nextTurn();
            }
        }
    }
}
