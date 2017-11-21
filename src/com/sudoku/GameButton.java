package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameButton extends JButton {
    private GamePosition pos;
    private int data = -1;

    GameButton(String text, int x, int y) {
        super(text);
        pos = new GamePosition(x, y);
    }

    public GamePosition getpos() {
        return pos;
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
