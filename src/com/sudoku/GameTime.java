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
        this.hour = hour % Integer.MAX_VALUE;
        this.minute = minute % 60;
        this.second = second % 60;
        this.millisecond = millisecond % 60;
        onTimer = new Timer(10, (ActionEvent e) -> {
            AddMSecond();
            setText(toString());
        });
        setText(toString());
    }

    public void AddMSecond() {
        millisecond += 1;
        if (millisecond >= 100) {
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

    public void Start() {
        onTimer.start();
    }

    public void Stop() {
        onTimer.stop();
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d:%02d", hour, minute, second, millisecond);
    }
}
