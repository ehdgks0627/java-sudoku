package com.sudoku;

import javax.swing.*;

import com.sun.glass.ui.Size;

import java.awt.*;

public class GameFrame extends JFrame {
	private JButton btnNewGame = new JButton("New Game");
	private JButton btnShowAnswer = new JButton("Show Answer");
	private JButton btnExit = new JButton("Exit");

	private JPanel Button = new JPanel();
	private JPanel time = new JPanel();

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

		controlPanel.setLayout(new GridLayout(2, 1));
		controlPanel.add(time);

		controlPanel.add(Button);

		Font font = new Font("null", Font.PLAIN, 20);
		btnNewGame.setPreferredSize(new Dimension(250, 50));
		btnNewGame.setFont(font);
		btnShowAnswer.setPreferredSize(new Dimension(250, 50));
		btnShowAnswer.setFont(font);
		btnExit.setPreferredSize(new Dimension(250, 50));
		btnExit.setFont(font);

		Button.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		Button.add(btnNewGame);
		Button.add(btnShowAnswer);
		Button.add(btnExit);

		add(mainPanel);
	}

}
