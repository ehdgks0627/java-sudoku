package com.sudoku;

import java.util.Random;

public class SudokuPanGenerator {
    int[][] answer;
    boolean[][] answer_mask;
    public static final int DIFFICULTY_HARD = 35;
    public static final int DIFFICULTY_MEDIUM = 28;
    public static final int DIFFICULTY_EASY = 24;

    public static GameInfo GeneratePan(int difficulty) {
        SudokuPanGenerator spg = new SudokuPanGenerator();
        spg.nextBoard(difficulty);

        GameInfo answer = new GameInfo();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                answer.setAnswer(row, col, spg.answer[row][col]);
                answer.setAnswer_mask(row, col, spg.answer_mask[row][col]);
            }
        }

        return answer;
    }

    public int[][] nextBoard(int difficulty) {
        answer = new int[9][9];
        answer_mask = new boolean[9][9];
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                answer_mask[row][col] = true;
            }
        }
        nextCell(0, 0);
        makeHoles(difficulty);
        return answer;

    }

    public boolean nextCell(int x, int y) {
        int nextX = x;
        int nextY = y;
        int[] toCheck = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random r = new Random();
        int tmp = 0;
        int current = 0;
        int top = toCheck.length;

        for (int i = top - 1; i > 0; i--) {
            current = r.nextInt(i);
            tmp = toCheck[current];
            toCheck[current] = toCheck[i];
            toCheck[i] = tmp;
        }

        for (int i = 0; i < toCheck.length; i++) {
            if (legalMove(x, y, toCheck[i])) {
                answer[x][y] = toCheck[i];
                if (x == 8) {
                    if (y == 8)
                        return true;
                    else {
                        nextX = 0;
                        nextY = y + 1;
                    }
                } else {
                    nextX = x + 1;
                }
                if (nextCell(nextX, nextY))
                    return true;
            }
        }
        answer[x][y] = 0;
        return false;
    }

    private boolean legalMove(int x, int y, int current) {
        for (int i = 0; i < 9; i++) {
            if (current == answer[x][i])
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (current == answer[i][y])
                return false;
        }
        int cornerX = 0;
        int cornerY = 0;
        if (x > 2)
            if (x > 5)
                cornerX = 6;
            else
                cornerX = 3;
        if (y > 2)
            if (y > 5)
                cornerY = 6;
            else
                cornerY = 3;
        for (int i = cornerX; i < 10 && i < cornerX + 3; i++)
            for (int j = cornerY; j < 10 && j < cornerY + 3; j++)
                if (current == answer[i][j])
                    return false;
        return true;
    }

    public void makeHoles(int holesToMake) {
        double remainingSquares = 81;
        double remainingHoles = (double) holesToMake;

        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                double holeChance = remainingHoles / remainingSquares;
                if (Math.random() <= holeChance) {
                    answer_mask[i][j] = false;
                    remainingHoles--;
                }
                remainingSquares--;
            }
    }
}
