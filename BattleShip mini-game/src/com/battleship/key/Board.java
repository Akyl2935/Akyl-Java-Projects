package com.battleship.key;

import java.util.List;
import java.util.Arrays;


public class Board {
    private final int boardSize;
    private final char[][] board;
    private final List<Character> letters = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J');
    private final Player player;

    public Board(int boardSize, Player player) {
        this.boardSize = boardSize;
        this.board = new char[boardSize][boardSize];
        this.player = player;
        createGameBoard();
        placeShips();
    }
    //filling each board [][] with space;

    private void createGameBoard() {
        for (char[] row : board) {
            Arrays.fill(row, ' ');
        }
    }

    private void placeShips() {
        for (Ship ship : player.getShips()) {
            for (Coord coord : ship.getCoordinates()) {
                int x = coord.getX();
                int y = coord.getY();

                board[x][y] = String.valueOf(Ship.getSizes()).charAt(0);
            }
        }
    }

    public int getLetterIndex(char letter) {
        return letters.indexOf(letter);
    }

    public String attemptHit(int x, int y) {
        Coord coord = new Coord(x, y);

        for (Ship ship : player.getShips()) {
            boolean[] hitData = ship.didHit(coord);
            boolean didHit = hitData[0];
            boolean sank = hitData[1];

            if (didHit) {
                board[x][y] = 'X';

                return sank ? "You sank their battleship!" : "Hit!";
            }
        }

        return "Miss!";
    }

    public String toString() {
        StringBuilder result = new StringBuilder("    ");
        String delimiter = " | ";

        //Add columns

        for (int a = 0; a < boardSize; ++a) {
            result.append(letters.get(a));

            if (a < boardSize - 1) {
                result.append(delimiter);
            }
        }
        result.append("\n");

        //Add rows and board

        for (int x = 0; x < boardSize; ++x) {
            for (int y = 0; y < boardSize; ++y) {

                //Add the row letter first

                if (y == 0) {
                    result.append(x);
                    result.append(delimiter);
                }

                //Add each board tile state

                result.append(board[x][y]);
                result.append(delimiter);
            }

            result.append("\n");

        }

        return result.toString();
    }
}


