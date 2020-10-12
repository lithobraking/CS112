import java.util.Arrays;

public class Board {
    // setup!
    private static boolean hasWinner = false;
    private static boolean isTie = false;
    private static boolean boardIsReady = true;
    private static final String[] squares = new String[9];
    private static String turn = "X";
    private static int moveCount = 0;

    public Board() {
        Arrays.fill(squares, "");
    }

    // getter methods
    public static String getTurn() {
        return turn;
    }
    public static boolean isHasWinner() {
        return hasWinner;
    }
    public static boolean hasTie() {
        return isTie;
    }
    public static boolean isBoardIsReady() {
        return boardIsReady;
    }

    public static void nextTurn() {
        if (!hasWinner) {
            if (turn.equals("X")) {
                turn = "O";
            } else {
                turn = "X";
            }
        }
    }

    public static void setSquare(int index) {
        squares[index] = turn;
        moveCount++;
    }

    public static void setBoardIsReady() {
        boardIsReady = true;
        turn = "O";
    }

    public static void reset() {
        Arrays.fill(squares, "");
        hasWinner = false;
        boardIsReady = false;
        isTie = false;
        moveCount = 0;
    }

    public static void checkForWinner() {
        String a = "";
        String b = "";
        String c = "";


        int[][] lines = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {0, 3, 6},
                {1, 4, 7},
                {2, 5, 8},
                {0, 4, 8},
                {2, 4, 6}
        };
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < lines[i].length; j++) {
                int location = lines[i][j];
                if (!squares[location].equals("") && a.equals("")) {
                    a = squares[location];
                } else if (!squares[location].equals("") && !a.equals("") && b.equals("")) {
                    b = squares[location];
                } else if (!squares[location].equals("") && !a.equals("") && !b.equals("")) {
                    c = squares[location];
                }
            }
            if (!a.equals("") && (a.equals(b) && a.equals(c))) {
                hasWinner = true;
                break;
            } else {
                a = "";
                b = "";
                c = "";
            }
        }
        if (moveCount == 9) {
            isTie = true;
        }
    }
}
