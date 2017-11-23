package com.sudoku;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame {
    private GameTime timeLabel = new GameTime();
    private GamePanel gamePanel = new GamePanel(this);
    private ButtonGroup buttonGroup;

    GameFrame() {
        setTitle("스도쿠게임");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(gamePanel, BorderLayout.LINE_START);

        JPanel controlPanel = new JPanel();
        mainPanel.add(controlPanel, BorderLayout.CENTER);

        Font font1 = new Font("null", Font.PLAIN, 12);

        JRadioButton easy = new JRadioButton("EASY");
        easy.setFont(font1);
        easy.setSelected(true);
        easy.setActionCommand(easy.getText());

        JRadioButton medium = new JRadioButton("MEDIUM");
        medium.setFont(font1);
        medium.setActionCommand(medium.getText());

        JRadioButton hard = new JRadioButton("HARD");
        hard.setFont(font1);
        hard.setActionCommand(hard.getText());

        buttonGroup = new ButtonGroup();
        buttonGroup.add(easy);
        buttonGroup.add(medium);
        buttonGroup.add(hard);

        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 20));
        controlPanel.add(easy);
        controlPanel.add(medium);
        controlPanel.add(hard);
        controlPanel.add(timeLabel);

        Font font = new Font("null", Font.PLAIN, 20);

        JButton btnNewGame = new JButton("New Game");
        controlPanel.add(btnNewGame);
        btnNewGame.setPreferredSize(new Dimension(200, 50));
        btnNewGame.setFont(font);
        btnNewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gamePanel.NewGame(buttonGroup.getSelection().getActionCommand());
                timeLabel.Reset();
                timeLabel.Start();
            }
        });

        JButton btnShowAnswer = new JButton("Show Answer");
        controlPanel.add(btnShowAnswer);

        JButton btnExit = new JButton("Exit");
        controlPanel.add(btnExit);

        timeLabel.setFont(font);


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
