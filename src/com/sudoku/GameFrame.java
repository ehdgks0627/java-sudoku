package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private JButton btnNewGame = new JButton("New Game");
    private JButton btnShowAnswer = new JButton("Show Answer");
    private JButton btnExit = new JButton("Exit");

    private JPanel mainPanel = new JPanel();
    private GamePanel gamePanel = new GamePanel();
    private JPanel controlPanel = new JPanel();

    GameFrame() {
        setTitle("스도쿠 게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        controlPanel.setLayout(new GridLayout(3,1));
        controlPanel.setSize(200,600);
        controlPanel.add(btnNewGame);
        controlPanel.add(btnShowAnswer);
        controlPanel.add(btnExit);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.LINE_START);
        mainPanel.add(controlPanel, BorderLayout.LINE_END);

        add(mainPanel);
    }

}
