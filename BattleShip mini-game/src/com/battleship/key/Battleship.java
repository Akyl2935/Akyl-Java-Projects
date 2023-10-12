package com.battleship.key;

import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        int boardSize = 10;
        Player player = new Player(boardSize);
        Board board = new Board(boardSize, player);

        runGameLoop(board);


        //Create infinite game loop to:  Draw the current game board;
        //Print the last action: "Hit", "Miss", "Sank".
    }

    private static void runGameLoop(Board board) {
        Scanner scanner = new Scanner(System.in);
        String lastAction = null; //"Miss","Hit","Sank!"

        while (true) {
            System.out.println(board);
            if (lastAction != null) {
                System.out.println(lastAction);
            }

            String coord;
            do {
                System.out.println("Enter a coordinate (ex \"A0\" or \"quit\" to stop playing.)");

                coord = scanner.next().toUpperCase();

                if (coord.equalsIgnoreCase("quit")) {
                    return;
                }
            } while (!isValidCoord(coord, board));

            char[] array = coord.toCharArray();

            int column = board.getLetterIndex(array[0]);
            int row = array[1] - 48;

            lastAction = board.attemptHit(row, column);
        }
    }


    private static boolean isValidCoord(String coord, Board board) {
        if (coord.length() != 2) {
            return false;
        }

        char[] array = coord.toCharArray();

        //A - J

        if (board.getLetterIndex(array[0]) == -1) {
            return false;
        }

        int value = array[1];

        //ASCII

        //'0' = 48
        //'1' = 49

        //0 - 9

        return value >= 48 && value <= 57;

    }
}
