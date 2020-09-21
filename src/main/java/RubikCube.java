import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RubikCube {

    private Cell[][][] board;
    private int size;
    private final static Map<Cell, Character> SYMBOL = Map.of(
            Cell.RED, 'R',
            Cell.WHITE, 'W',
            Cell.GREEN, 'G',
            Cell.YELLOW, 'Y',
            Cell.ORANGE, 'O',
            Cell.BLUE, 'B'
    );
    private final static int TOP = 0;
    private final static int LEFT = 1;
    private final static int FRONT = 2;
    private final static int RIGHT = 3;
    private final static int BACK = 4;
    private final static int BOTTOM = 5;

    RubikCube(int size) {
        this.size = size;
        this.board = new Cell[6][size][size];
        Cell[] cells = Cell.values();
        for (int i = 0; i < 6; i++) {
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    this.board[i][x][y] = cells[i];
                }
            }
        }
    }

    private void rotateFaceRight(int face) {
        Cell[][] item = new Cell[size][size];
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                item[i][j] = board[face][i][j];
            }
        }
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[face][x][y] = item[y][size - x - 1];
            }
        }
    }

    private void rotateFaceLeft(int face) {
        for (int i = 0; i < 3; i++) {
            rotateFaceRight(face);
        }
    }


    void rotateRowRight(int row) {
        if (row == 0) {
            rotateFaceRight(TOP);
        } else if (row + 1 == size) {
            rotateFaceLeft(BOTTOM);
        }
        Cell[] copy = board[FRONT][row];
        board[FRONT][row] = board[LEFT][row];
        board[LEFT][row] = board[BACK][row];
        board[BACK][row] = board[RIGHT][row];
        board[RIGHT][row] = copy;
    }

    void rotateRowLeft(int row) {
        for (int i = 0; i < 3; i++) {
            rotateRowRight(row);
        }
    }

    private void rotateRight() {
        for (int i = 0; i < size; i++) {
           rotateRowRight(i);
        }
    }

    private void rotateLeft() {
        for (int i = 0; i < 3; i++) {
            rotateRight();
        }
    }

    private void rotateUp() {
        Cell[][] copy = board[FRONT];
        board[FRONT] = board[BOTTOM];
        board[BOTTOM] = board[BACK];
        board[BACK] = board[TOP];
        board[TOP] = copy;
        rotateFaceRight(LEFT);
        rotateFaceLeft(RIGHT);
    }

    private void rotateDown() {
        for (int i = 0; i < 3; i++) {
            rotateUp();
        }
    }

    void toTop(int face) {
        switch (face) {
            case LEFT:
                rotateRight();
                rotateUp();
                break;
            case FRONT:
                rotateUp();
                break;
            case RIGHT:
                rotateLeft();
                rotateUp();
                break;
            case BACK:
                rotateDown();
                break;
            case BOTTOM:
                rotateUp();
                rotateUp();
                break;
            default:
                break;
        }
    }

    public void apply(String line) throws IllegalArgumentException {
        String[] data = line.split(" ");
        if (data.length != 2) {
            throw new IllegalArgumentException("Your imput must contains exactly two arguments");
        }
        String command = data[0];
        int num;
        try {
            num = Integer.parseInt(data[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("2nd argument must be integer");
        }
        if (command.equals("top")) {
            if (num < 1 || num > 6) {
                throw new IllegalArgumentException("2nd argument must be face ID");
            }
            toTop(num - 1);
        } else {
            if (num < 1 || num > size) {
                throw new IllegalArgumentException("2nd argument must be row number");
            }
            if (command.equals("right")) {
                rotateRowRight(num - 1);
            } else if (command.equals("left")) {
                rotateRowLeft(num - 1);
            } else {
                throw new IllegalArgumentException("unknown command");
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < size; x++) {
            for (int i = 0; i < 6; i++) {
                for (int y = 0; y < size; y++) {
                    builder.append(SYMBOL.get(board[i][x][y]));
                    builder.append("  ");
                }
                builder.append("   ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}

