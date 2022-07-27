package com.project.game.players;

import com.project.game.dto.Board;
import com.project.game.dto.Cell;
import com.project.game.service.BoardActions;

import java.util.List;
import java.util.Random;

public class Computer {

    private Random rand = new Random();

    public Board makeMove(Board input) {
        List<Cell> emptyCells = input.emptyCells();

        double numberToPlace = rand.nextDouble();
        int indexToPlace = rand.nextInt(emptyCells.size());
        Cell cellToPlace = emptyCells.get(indexToPlace);

        BoardActions boardActions = new BoardActions();

        return boardActions.placeTile(input,cellToPlace, numberToPlace >= 0.9 ? 4 : 2);
    }
}
