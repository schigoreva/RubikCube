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

    private List<String> VERGES = List.of("L", "F", "R", "B", "U", "D");

    private List<List<Integer>> VERGE_N = List.of(
            List.of(5, 2, 4, 3, 1),
            List.of(5, 3, 4, 0, 2),
            List.of(5, 0, 4, 1, 3),
            List.of(5, 1, 4, 2, 0),
            List.of(0, 0, 0, 0, 0),
            List.of(3, 4, 1, 0, 2)
    );

    private List<List<Integer>> LINK_V = List.of(
            List.of(1, 4, 3, 5),
            List.of(2, 4, 0, 5),
            List.of(3, 4, 1, 5),
            List.of(0, 4, 2, 5),
            List.of(2, 3, 0, 1),
            List.of(2, 1, 0, 3)
    );

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

    private void turnVergeRight(int verge) {
        Cell[][] item = board[verge];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                board[verge][x][y] = item[y][size - x - 1];
            }
        }
    }

    private void turnLevel(int k) {
        Cell[] copy = board[1][k];
        board[1][k] = board[0][k];
        board[0][k] = board[3][k];
        board[3][k] = board[2][k];
        board[2][k] = copy;
    }

    // U 1 r 1
    void turnVerge(String command) {
        String[] list = command.split(" ");
        int verge = VERGES.indexOf(list[0]);
        int k = Integer.parseInt(list[1]);
        String turn = list[2];
        int cnt = Integer.parseInt(list[3]) % 4;
        if (verge != 4) {
            turnCube(verge);
            if (verge == 5) {
                turnCube(verge);
            }
        }
        if (turn.equals("r")) {
            for (int i = 0; i < cnt; i++) {
                if (k == 0) {
                    turnVergeRight(verge);
                }
                turnLevel(k);
            }

        } else {
            if (k == 0) {
                for (int i = 0; i < (4 - cnt) % 4; i++) {
                    turnVergeRight(verge);
                }
            }
        }
        if (verge != 4) {
            turnCube(verge);
            turnCube(verge);
            if (verge != 5) {
                turnCube(verge);
            }
        }
    }

    private void turnCube(int verge) {
        Cell[][] copy = board[verge];
        board[verge] = board[VERGE_N.get(verge).get(0)];
        board[VERGE_N.get(verge).get(0)] = board[VERGE_N.get(verge).get(1)];
        board[VERGE_N.get(verge).get(1)] = board[VERGE_N.get(verge).get(2)];
        board[VERGE_N.get(verge).get(2)] = copy;
        turnVergeRight(VERGE_N.get(verge).get(3));
        for (int i = 0; i < 3; i++) {
            turnVergeRight(VERGE_N.get(verge).get(4));
        }
    }

    void turnCubeCommand(String command) {
        String[] list = command.split(" ");
        int verge = VERGES.indexOf(list[0]);
        String turn = list[1];
        int cnt = Integer.parseInt(list[2]);
        if(verge != 4) {
            for (int i = 0; i < cnt; i++) {
                turnCube(verge);
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

