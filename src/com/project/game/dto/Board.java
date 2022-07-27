package com.project.game.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {



    private final int[][] board;
    private final int score;

    public Board(int size) {
        this.board = new int[size][];
        this.score = 0;

        for (int x = 0; x < size; ++x) {
            this.board[x] = new int[size];
            for (int y = 0; y < size; ++y) {
                board[x][y] = 0;
            }
        }
    }

    public Board(int[][] board, int score) {
        this.score = score;
        this.board = new int[board.length][];

        for (int x = 0; x < board.length; ++x) {
            this.board[x] = Arrays.copyOf(board[x], board[x].length);
        }
    }

    public int getSize() {
        return board.length;
    }

    public int getScore() {
        return score;
    }

    public int getCell(Cell cell) {
        return board[cell.getX()][cell.getY()];
    }

    public boolean isEmpty(Cell cell) {
        return getCell(cell) == 0;
    }

    public int[][] getBoard() {
        return board;
    }

    public List<Cell> emptyCells() {
        List<Cell> result = new ArrayList<>();
        for (int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[x].length; ++y) {
                Cell cell = new Cell(x, y);
                if (isEmpty(cell)) {
                    result.add(cell);
                }
            }
        }
        return result;
    }
}
