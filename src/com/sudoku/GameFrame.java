package com.sudoku;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private JButton btnNewGame = new JButton("New Game");
    private JButton btnShowAnswer = new JButton("Show Answer");
    private JButton btnExit = new JButton("Exit");

    private GameTime timeLabel = new GameTime();

    private JPanel mainPanel = new JPanel();
    private GamePanel gamePanel = new GamePanel();
    private JPanel controlPanel = new JPanel();

    GameFrame() {
        setTitle("스도쿠 게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.LINE_START);
        mainPanel.add(controlPanel, BorderLayout.CENTER);

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        controlPanel.add(timeLabel);
        controlPanel.add(btnNewGame);
        controlPanel.add(btnShowAnswer);
        controlPanel.add(btnExit);

        Font font = new Font("null", Font.PLAIN, 20);

        timeLabel.setFont(font);

        btnNewGame.setPreferredSize(new Dimension(250, 50));
        btnNewGame.setFont(font);
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.NewGame();
                timeLabel.Reset();
            }
        });

        btnShowAnswer.setPreferredSize(new Dimension(250, 50));
        btnShowAnswer.setFont(font);
        btnShowAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.ShowSolution();
                timeLabel.Stop();
            }
        });

        btnExit.setPreferredSize(new Dimension(250, 50));
        btnExit.setFont(font);

        add(mainPanel);
    }
}
