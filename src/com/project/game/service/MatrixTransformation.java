package com.project.game.service;

public class MatrixTransformation {

    public int[][] transpose(int[][] input) {
        int[][] result = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            result[i] = new int[input[0].length];
            for (int j = 0; j < input[0].length; j++) {
                result[i][j] = input[j][i];
            }
        }
        return result;
    }

    public int[][] reverse(int[][] input) {
        int[][] result = new int[input.length][];

        for (int i = 0; i < input.length; i++) {
            result[i] = new int[input[0].length];
            for (int j = 0; j < input[0].length; j++) {
                result[i][j] = input[i][input.length - j - 1];
            }
        }
        return result;
    }


}
