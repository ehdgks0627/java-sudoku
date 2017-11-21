package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private GamePosition pos;
    private int data = -1;
    private boolean isStatic;

    GameButton(String text, boolean isStatic, int row, int col) {
        super(text);
        pos = new GamePosition(row, col);
        this.isStatic = isStatic;
    }

    public GamePosition getpos() {
        return pos;
    }

    public boolean getIsStatic() {
        return isStatic;
    }

    public int getdata() {
        return data;
    }

    public void setdata(int data) {
        this.data = data;
    }

    public void highlight() {
        setBackground(Color.BLACK);
        setContentAreaFilled(false);
        setOpaque(true);
        updateUI();
    }

    public void dehighlight() {
        setBackground(Color.WHITE);
        setContentAreaFilled(false);
        setOpaque(true);
        updateUI();
    }
}
