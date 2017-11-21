package com.sudoku;

public class GameInfo {
    private int[][] answer;
    private boolean[][] answer_mask;

    GameInfo() {
        answer = new int[9][9];
        answer_mask = new boolean[9][9];
    }

    public int getAnswer(int row, int col) {
        return answer[row][col];
    }

    public boolean getAnswer_mask(int row, int col) {
        return answer_mask[row][col];
    }
}
