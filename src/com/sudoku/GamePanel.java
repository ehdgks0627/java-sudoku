package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    private GameInfo answer;
    private GameButton[][] pan = new GameButton[9][9];
    private Position selectedPos = new Position();
    private boolean isPlay;

    GamePanel() {
        setLayout(new GridLayout(9, 9));

        NewGame();
    }

    public Color pickColor(int row, int col) {
        if ((col < 3 || (5 < col && col < 9)) && (row < 3 || (row > 5 && row < 9)) || ((2 < row && row < 6) && (2 < col && col < 6))) {
            return Color.WHITE;
        } else {
            return Color.GRAY;
        }
    }

    public void NewGame() {
        isPlay = false;
        removeAll();
        answer = SudokuPanGenerator.GeneratePan();
        selectedPos.setEmpty();

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                GameButton t;
                if (answer.getAnswer_mask(row, col)) {
                    t = new GameButton("" + answer.getAnswer(row, col), true, row, col, pickColor(row, col));
                } else {
                    t = new GameButton("", false, row, col, pickColor(row, col));
                }

                t.setPreferredSize(new Dimension(60, 60));
                t.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ('1' <= c && c <= '9') {
                            InputBoard(c - '0');
                        }
                    }
                });
                t.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (isPlay) {
                            Object source = e.getSource();
                            if (source instanceof GameButton) {
                                GameButton btn = (GameButton) source;
                                if (btn.getIsStatic()) {
                                    return;
                                }
                                Position pos = null;
                                try {
                                    pos = (Position) btn.getPos().clone();
                                } catch (CloneNotSupportedException e1) {
                                    e1.printStackTrace();
                                }
                                if (selectedPos.isEmpty()) {
                                    btn.highlight();
                                    try {
                                        selectedPos = (Position) btn.getPos().clone();
                                    } catch (CloneNotSupportedException e1) {
                                        e1.printStackTrace();
                                    }
                                } else {
                                    if (selectedPos.equals(pos)) {
                                        btn.deHighlight();
                                        selectedPos.setEmpty();
                                    } else {
                                        pan[selectedPos.row][selectedPos.col].deHighlight();
                                        btn.highlight();
                                        try {
                                            selectedPos = (Position) btn.getPos().clone();
                                        } catch (CloneNotSupportedException e1) {
                                            e1.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    }
                });
                add(t);
                pan[row][col] = t;
            }
        }
        isPlay = true;
    }

    public void InputBoard(int num) {
        if (!selectedPos.isEmpty()) {
            pan[selectedPos.row][selectedPos.col].setData(num);
            pan[selectedPos.row][selectedPos.col].deHighlight();
            selectedPos.setEmpty();
            //TODO validate
        }
    }


    public void ShowSolution() {
        isPlay = false;
        if (!selectedPos.isEmpty()) {
            pan[selectedPos.row][selectedPos.col].deHighlight();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                pan[row][col].setText("" + answer.getAnswer(row, col));
            }
        }
    }
}