package Player;

import java.util.Random;

import Grid.Grid;

public class Player {
    private int ficha;
    private Grid tablero;

    public Player(int ficha, Grid tablero) {
        if (ficha != Grid.VACIO) {
            this.ficha = ficha;
        } else {
            this.ficha = Grid.DEFAULT1;
        }
        this.tablero = tablero;
    }

    public void putTokenInColumn(int column) {
        this.tablero.insertToken(this.ficha, column);
    }

    public void seeGridState() {
        System.out.println(this.tablero.toString());
    }

    public boolean isWinner() {
        return isWinner(this.ficha);
    }

    public static void main(String args[]) {
        int column;
        Random rand = new Random();
        int i = 0;
        Grid tablero = new Grid();
        Player p1 = new Player(0, tablero);
        Player p2 = new Player(1, tablero);
        while (i < 10) {
            column = rand.nextInt(Grid.NUMBER_OF_COLUMNS);
            p1.putTokenInColumn(column);
            p1.seeGridState();
            column = rand.nextInt(Grid.NUMBER_OF_COLUMNS);
            p2.putTokenInColumn(column);
            p2.seeGridState();
            i++;
        }

    }
}
