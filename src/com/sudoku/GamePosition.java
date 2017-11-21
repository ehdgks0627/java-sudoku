package com.sudoku;

public class GamePosition extends Object {
    int row;
    int col;

    public GamePosition() {
        this(-1, -1);
    }

    public GamePosition(int row, int col) {
        if (row >= 0) {
            this.row = row;
        } else {
            this.row = -1;
        }
        if (col >= 0) {
            this.col = col;
        } else {
            this.col = -1;
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        if (!(object instanceof GamePosition)) {
            return false;
        }
        GamePosition _obj = (GamePosition) object;
        if (_obj.row == this.row && _obj.col == this.col) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (row == -1 && col == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void setEmpty() {
        row = -1;
        col = -1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new GamePosition(row, col);
    }
}
