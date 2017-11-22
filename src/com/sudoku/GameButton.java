package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private Position pos;
    private int data = Position.EMPTY_POSITION;
    private boolean isStatic;
    private Color color;

    public static final Color HIGHLIGHT_COLOR = Color.GREEN;
    public static final Font STATIC_FONT = new Font("null", Font.BOLD, 20);
    public static final Font GENERAL_FONT = new Font("null", Font.PLAIN, 20);

    GameButton(String text, boolean isStatic, int row, int col, Color color) {
        super(text);
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
        setText(Integer.toString(data));
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
