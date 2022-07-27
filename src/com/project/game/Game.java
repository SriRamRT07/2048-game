package com.project.game;

import com.project.game.dto.Board;
import com.project.game.dto.Cell;
import com.project.game.players.Computer;
import com.project.game.players.User;

public class Game {

    private static void printBoard(Board board) {
        StringBuilder topLines = new StringBuilder();
        StringBuilder midLines = new StringBuilder();
        for (int x = 0; x < board.getSize(); ++x) {
            topLines.append("*--------");
            midLines.append("|        ");
        }
        topLines.append("*");
        midLines.append("|");

        for (int y = 0; y < board.getSize(); ++y) {
            System.out.println(topLines);
            System.out.println(midLines);
            for (int x = 0; x < board.getSize(); ++x) {
                Cell cell = new Cell(x, y);
                System.out.print("|");
                if (board.isEmpty(cell)) {
                    System.out.print("        ");
                } else {
                    StringBuilder output = new StringBuilder(Integer.toString(board.getCell(cell)));
                    while (output.length() < 8) {
                        output.append(" ");
                        if (output.length() < 8) {
                            output.insert(0, " ");
                        }
                    }
                    System.out.print(output);
                }
            }
            System.out.println("|");
            System.out.println(midLines);
        }
        System.out.println(topLines);
        System.out.println("Score: " + board.getScore());
    }
    public static void main(String[] args){
        System.out.println("Welcome to 2048 Game");
        Board board = new Board(4);
        Computer computer = new Computer();
        User user = new User();
        for (int i = 0; i < 2; ++i) {
            board = computer.makeMove(board);
        }

        printBoard(board);

        while(true){
            System.out.println("Human move");
            System.out.println("==========");
            board = user.makeMove(board);
            printBoard(board);

            System.out.println("Computer move");
            System.out.println("=============");
            board = computer.makeMove(board);
            printBoard(board);

            if(board.emptyCells().isEmpty())
                break;

        }

        System.out.println("Final Score: " + board.getScore());
    }
}
