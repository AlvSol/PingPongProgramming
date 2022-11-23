package Grid;

public class Grid {
    public final static int NUMBER_OF_ROWS = 6;
    public final static int NUMBER_OF_COLUMNS = 7;
    public final static int VACIO = -1;
    public final static int DEFAULT1 = 1;

    private int grid[][];

    public Grid() {
        grid = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                this.grid[i][j] = VACIO;
            }
        }
    }

    public int[][] getGrid() {
        return grid;
    }

    public void insertToken(int token, int column) {
        if ((column - 1) < NUMBER_OF_COLUMNS && (column - 1) > 0) {
            for (int i = 0; i < NUMBER_OF_ROWS; i++) {
                if (this.grid[i][(column - 1)] == VACIO) {
                    this.grid[i][(column - 1)] = token;
                    return;
                }
            }
        }

    }

    @Override
    public String toString() {
        String tablero = "";
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                if (this.getGrid()[i][j] == VACIO) {
                    tablero += "| ";
                } else {
                    tablero += "|" + this.getGrid()[i][j];
                }
            }
            tablero += "|\n";
        }
        return tablero;
    }

}
