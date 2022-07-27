package com.project.game.service;

import com.project.game.dto.Board;
import com.project.game.dto.Cell;

import java.util.Arrays;
import java.util.LinkedList;

public class BoardActions {

    private MatrixTransformation matrixTransformation =  new MatrixTransformation();

    public Board move(int move,Board currBoard) {
        int newScore = 0;

        int[][] board  = currBoard.getBoard();
        int score = currBoard.getScore();
        // Clone the board
        int[][] tiles = new int[board.length][];
        for (int x = 0; x < board.length; ++x) {
            tiles[x] = Arrays.copyOf(board[x], board[x].length);
        }

        if(matrixTransformation == null)
            matrixTransformation = new MatrixTransformation();

        if (move == 1 || move == 2) {
            tiles = matrixTransformation.transpose(tiles);

        }
        if (move == 4 || move == 2) {
            tiles = matrixTransformation.reverse(tiles);
        }

        int[][] result = new int[tiles.length][];

        for (int x = 0; x < tiles.length; ++x) {
            LinkedList<Integer> thisRow = new LinkedList<>();
            for (int y = 0; y < tiles[0].length; ++y) {
                if (tiles[x][y] > 0) {
                    thisRow.add(tiles[x][y]);
                }
            }
            LinkedList<Integer> newRow = new LinkedList<>();
            while (thisRow.size() >= 2) {
                int first = thisRow.pop();
                int second = thisRow.peek();
                if (second == first) {
                    int newNumber = first * 2;
                    newRow.add(newNumber);
                    newScore += newNumber;
                    thisRow.pop();
                } else {
                    newRow.add(first);
                }
            }
            newRow.addAll(thisRow);

            result[x] = new int[tiles[0].length];
            for (int y = 0; y < tiles[0].length; ++y) {
                if (newRow.isEmpty()) {
                    result[x][y] = 0;
                } else {
                    result[x][y] = newRow.pop();
                }
            }
        }

        if (move == 4 || move == 2) {
            result = matrixTransformation.reverse(result);
        }
        if (move == 1 || move == 2) {
            result = matrixTransformation.transpose(result);
        }

        return new Board(result, score + newScore);
    }

    public Board placeTile(Board board,Cell cell, int num) {

        if(matrixTransformation == null)
            matrixTransformation = new MatrixTransformation();

        if (!board.isEmpty(cell)) {
            throw new IllegalArgumentException("That cell is not empty");
        }

        Board result = new Board(board.getBoard(), board.getScore());
        result.getBoard()[cell.getX()][cell.getY()] = num;
        return result;
    }

}
