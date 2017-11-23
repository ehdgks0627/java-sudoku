package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private Position pos;
    private int data = EMPTY_DATA;
    private boolean isStatic;
    private Color color;

    private static final Color HIGHLIGHT_COLOR = Color.GREEN;
    private static final Font STATIC_FONT = new Font("null", Font.BOLD, 20);
    private static final Font GENERAL_FONT = new Font("null", Font.PLAIN, 20);
    public static final int EMPTY_DATA = -1;

    GameButton(int data, boolean isStatic, int row, int col, Color color) {
        super();
        if (isStatic) {
            setText(Integer.toString(data));
        }

        this.data = data;
        pos = new Position(row, col);
        this.isStatic = isStatic;
        this.color = color;

        setBackground(color);
        if (isStatic) {
            setFont(STATIC_FONT);
        } else {
            setFont(GENERAL_FONT);
        }

        setContentAreaFilled(false);
        setOpaque(true);
        updateUI();
    }

    public Position getPos() {
        return pos;

    }

    public boolean getIsStatic() {
        return isStatic;

    }

    public int getData() {
        return data;

    }

    public void setData(int data) {
        this.data = data;
        if (data == EMPTY_DATA) {
            setText("");
        } else {
            setText(Integer.toString(data));
        }
    }

    public void highlight() {
        setBackground(HIGHLIGHT_COLOR);
        setContentAreaFilled(false);
        setOpaque(true);
        updateUI();
    }

    public void deHighlight() {
        setBackground(color);
        setContentAreaFilled(false);
        setOpaque(true);
        updateUI();
    }
}
