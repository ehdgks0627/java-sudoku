package com.sudoku;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {

    private GameTime timeLabel = new GameTime();

    private GamePanel gamePanel = new GamePanel(this);

    GameFrame() {
        setTitle("스도쿠 게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.LINE_START);

        JPanel controlPanel = new JPanel();
        mainPanel.add(controlPanel, BorderLayout.CENTER);

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        controlPanel.add(timeLabel);

        JButton btnNewGame = new JButton("New Game");
        controlPanel.add(btnNewGame);

        JButton btnShowAnswer = new JButton("Show Answer");
        controlPanel.add(btnShowAnswer);

        JButton btnExit = new JButton("Exit");
        controlPanel.add(btnExit);

        Font font = new Font("null", Font.PLAIN, 20);

        timeLabel.setFont(font);

        btnNewGame.setPreferredSize(new Dimension(200, 50));
        btnNewGame.setFont(font);
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.NewGame();
                timeLabel.Reset();
            }
        });

        btnShowAnswer.setPreferredSize(new Dimension(200, 50));
        btnShowAnswer.setFont(font);
        btnShowAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.ShowSolution();
                stopGame();
            }
        });

        btnExit.setPreferredSize(new Dimension(200, 50));
        btnExit.setFont(font);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(mainPanel);
    }

    public void stopGame() {
        timeLabel.Stop();
    }
}
