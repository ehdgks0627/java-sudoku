package com.sudoku;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    GamePanel() {
        setLayout(new GridLayout(9, 9));

        for (int i = 0; i < 9 * 9; i++) {
            JButton t = new JButton("" + i);
            add(t);
        }
    }
}
