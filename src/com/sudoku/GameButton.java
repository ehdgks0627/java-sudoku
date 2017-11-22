package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private Position pos;
    private int data = Position.EMPTY_POSITION;
    private boolean isStatic;

    GameButton(String text, boolean isStatic, int row, int col) {
        super(text);
        pos = new Position(row, col);
        this.isStatic = isStatic;
    }

    public Position getpos() {
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
        setText(Integer.toString(data));
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
