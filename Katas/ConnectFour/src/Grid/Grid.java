package Grid;

import java.util.Objects;

public class Grid {
    public final static int NUMBER_OF_ROWS = 6;
    public final static int NUMBER_OF_COLUMNS = 7;
    public final static String VACIO = " ";
    public final static String DEFAULT1 = "1";

    private String grid[][];

    public Grid() {
        grid = new String[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                this.grid[i][j] = VACIO;
            }
        }
    }

    public String[][] getGrid() {
        return grid;
    }

    public boolean insertToken(String token, int column) {
        if ((column - 1) < NUMBER_OF_COLUMNS && (column - 1) > 0) {
            for (int i = 0; i < NUMBER_OF_ROWS; i++) {
                if (Objects.equals(this.grid[i][(column - 1)], VACIO)) {
                    this.grid[i][(column - 1)] = token;
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public boolean checkRowWinner(String token) {
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            for (int j = 0; (j + 3) < NUMBER_OF_COLUMNS; j++) {
                if (Objects.equals(this.getGrid()[i][j], token) && Objects.equals(this.getGrid()[i][j + 1], token)
                        && Objects.equals(this.getGrid()[i][j + 2], token)
                        && Objects.equals(this.getGrid()[i][j + 3], token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonWinner(String token) {
        for (int j = 0; (j + 3) < NUMBER_OF_COLUMNS; j++) {
            for (int i = 0; (i + 3) < NUMBER_OF_ROWS; i++) {

                if (Objects.equals(this.getGrid()[i][j], token) && Objects.equals(this.getGrid()[i + 1][j + 1], token)
                        && Objects.equals(this.getGrid()[i + 2][j + 2], token)
                        && Objects.equals(this.getGrid()[i + 3][j + 3], token)) {
                    return true;
                }
                if (Objects.equals(this.getGrid()[i][j + 3], token)
                        && Objects.equals(this.getGrid()[i + 1][j + 2], token)
                        && Objects.equals(this.getGrid()[i + 2][j + 1], token)
                        && Objects.equals(this.getGrid()[i + 3][j], token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkColumnWinner(String token) {
        for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
            for (int i = 0; (i + 3) < NUMBER_OF_ROWS; i++) {

                if (Objects.equals(this.getGrid()[i][j], token) && Objects.equals(this.getGrid()[i + 1][j], token)
                        && Objects.equals(this.getGrid()[i + 2][j], token)
                        && Objects.equals(this.getGrid()[i + 3][j], token)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isWinner(String token) {
        if (!checkRowWinner(token)) {
            if (!checkColumnWinner(token)) {
                return checkDiagonWinner(token);
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        String tablero = "";
        for (int i = NUMBER_OF_ROWS - 1; i >= 0; i--) {
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                tablero += "|" + this.getGrid()[i][j];
            }
            tablero += "|\n";
        }
        return tablero;
    }

}
