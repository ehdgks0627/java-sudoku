package com.sudoku;

import javafx.geometry.Pos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private GameButton[][] pan = new GameButton[9][9];
    private GamePosition selectedPos = new GamePosition();

    GamePanel() {
        setLayout(new GridLayout(9, 9));

        //pan =

        for (int i = 0; i < 9 * 9; i++) {
            GameButton t = new GameButton("" + i, i / 9, i % 9);
            t.setPreferredSize(new Dimension(60, 60));
            t.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Object source = e.getSource();
                    if (source instanceof GameButton) {
                        GameButton btn = (GameButton) source;

                        GamePosition pos = null;
                        try {
                            pos = (GamePosition)btn.getpos().clone();
                        } catch (CloneNotSupportedException e1) {
                            e1.printStackTrace();
                        }
                        if (selectedPos.isEmpty()) {
                            btn.highlight();
                            try {
                                selectedPos = (GamePosition)btn.getpos().clone();
                            } catch (CloneNotSupportedException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            if (selectedPos.equals(pos)) {
                                btn.dehighlight();
                                selectedPos.setEmpty();
                            } else {
                                pan[selectedPos.x][selectedPos.y].dehighlight();
                                btn.highlight();
                                try {
                                    selectedPos = (GamePosition)btn.getpos().clone();
                                } catch (CloneNotSupportedException e1) {
                                    e1.printStackTrace();
                                }
                            }
                        }
                    }
                }
            });
            add(t);
            pan[i / 9][i % 9] = t;
        }

    }
}
