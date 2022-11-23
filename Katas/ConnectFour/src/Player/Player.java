package Player;

import java.util.Random;

import Grid.Grid;

public class Player {
    private String ficha;
    private Grid tablero;

    public Player(String ficha, Grid tablero) {
        if (ficha != Grid.VACIO) {
            this.ficha = ficha;
        } else {
            this.ficha = Grid.DEFAULT1;
        }
        this.tablero = tablero;
    }

    public boolean putTokenInColumn(int column) {
        return this.tablero.insertToken(this.ficha, column);
    }

    public void seeGridState() {
        System.out.println(this.tablero.toString());
    }

    public boolean isWinner() {
        return this.tablero.isWinner(this.ficha);
    }

    public static void main(String args[]) {
        int column;
        Random rand = new Random();
        Grid tablero = new Grid();
        Player yelloy = new Player("Y", tablero);
        Player red = new Player("R", tablero);
        while (!yelloy.isWinner() && !red.isWinner()) {
            do {
                column = rand.nextInt(Grid.NUMBER_OF_COLUMNS);
            } while (!yelloy.putTokenInColumn(column));
            yelloy.seeGridState();
            if (!yelloy.isWinner()) {
                do {
                    column = rand.nextInt(Grid.NUMBER_OF_COLUMNS);
                } while (!red.putTokenInColumn(column));
                red.seeGridState();
            }

        }

    }
}
