package com.project.game.players;

import com.project.game.dto.Board;
import com.project.game.service.BoardActions;

import java.security.SecureRandom;
import java.util.Random;

public class User {

    private Random rand = new Random();

    private BoardActions boardActions = new BoardActions();

    public Board makeMove(Board input) {
        int move  = rand.nextInt(4)+1;
        return boardActions.move(move,input);
    }
}
