package ru.job4j.tictactoe;
/**
 * Logic Class for TicTacToe game.
 * @author
 * @version
 * @since
 */
public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * Determine whether X winner.
     * @return true if X is winner of the game
     */
    public boolean isWinnerX() {
        return (checkRowsX() || checkColumnsX() || checkDiagonalsX());
    }

    /**
     * Checking all elements of row for X.
     * @return
     */
    public boolean checkRowsX() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            result = true;
            for (int j = 0; j < table.length - 1; j++) {
                if (!(table[i][j].hasMarkX() && table[i][j + 1].hasMarkX())) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Checking all elements of column for X.
     * @return
     */

    public boolean checkColumnsX() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            result = true;
            for (int j = 0; j < table.length - 1; j++) {
                if (!(table[j][i].hasMarkX() && table[j + 1][i].hasMarkX())) {
                    result = false;
                    break;
                 }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    /**
     * Checking all elements of both diagonals for X.
     * @return
     */

    public boolean checkDiagonalsX() {
        boolean result = true;
        for (int i = 0; i < table.length - 1; i++) {
            result = true;
            if (!(table[i][i].hasMarkX() && table[i + 1][i + 1].hasMarkX()
            || table[i][table.length - 1 - i].hasMarkX() && table[i + 1][table.length - 2 - i].hasMarkX())) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Determine whether O winner
     * @return
     */
    public boolean isWinnerO() {
        return (checkRowsO() || checkColumnsO() || checkDiagonalsO());
    }

    public boolean checkRowsO() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            result = true;
            for (int j = 0; j < table.length - 1; j++) {
                if (!(table[i][j].hasMarkO() && table[i][j + 1].hasMarkO())) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean checkColumnsO() {
        boolean result = true;
        for (int i = 0; i < table.length; i++) {
            result = true;
            for (int j = 0; j < table.length - 1; j++) {
                if (!(table[j][i].hasMarkO() && table[j + 1][i].hasMarkO())) {
                    result = false;
                    break;
                }
            }
            if (result) {
                break;
            }
        }
        return result;
    }

    public boolean checkDiagonalsO() {
        boolean result = true;
        for (int i = 0; i < table.length - 1; i++) {
            result = true;

            if (!(table[i][i].hasMarkO() && table[i + 1][i + 1].hasMarkO()
                    || table[i][table.length - 1 - i].hasMarkO() && table[i + 1][table.length - 2 - i].hasMarkO())) {
                result = false;
                break;
            }
        }
        return result;
    }
    public boolean hasGap() {
       boolean gap = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!(table[i][j].hasMarkX() || table[i][j].hasMarkO())) {
                    gap = true;
                    break;
                }
            }
        }

        return gap;
    }
}
