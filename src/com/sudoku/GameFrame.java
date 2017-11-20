package com.sudoku;

import javax.swing.*;

public class GameFrame extends JFrame {
    GameFrame() {
        setTitle("스도쿠 게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(new GamePanel());
    }
}
