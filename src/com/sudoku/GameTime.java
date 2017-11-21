package com.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameTime extends JLabel {
    private int hour;
    private int minute;
    private int second;
    private int millisecond;
    private Timer onTimer;

    GameTime() {
        this(0, 0, 0, 0);
    }

    GameTime(int hour, int minute, int second, int millisecond) {
        this.hour = hour;
        this.minute = minute % 60;
        this.second = second % 60;
        this.millisecond = millisecond % 60;
        onTimer = new Timer(100, (ActionEvent e) -> {
            AddMSecond();
            setText(toString());
        });
        onTimer.start();
    }

    public void AddMSecond() {
        millisecond += 1;
        if (millisecond >= 10) {
            millisecond = 0;
            second += 1;
            if (second >= 60) {
                second = 0;
                minute += 1;
                if (minute >= 60) {
                    minute = 0;
                    hour += 1;
                }
            }
        }
    }

    public void Reset() {
        hour = 0;
        minute = 0;
        second = 0;
        millisecond = 0;
    }

    @Override
    public String toString() {
        return hour + ":" + minute + ":" + second + "." + millisecond;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

    }
}
