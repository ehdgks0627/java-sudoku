package com.sudoku;

public class Position extends Object {
    int row;
    int col;
    public static final int EMPTY_POSITION = -1;

    public Position() {
        this(EMPTY_POSITION, EMPTY_POSITION);
    }

    public Position(int row, int col) {
        if (row >= 0) {
            this.row = row;
        } else {
            this.row = EMPTY_POSITION;
        }
        if (col >= 0) {
            this.col = col;
        } else {
            this.col = EMPTY_POSITION;
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
        if (!(object instanceof Position)) {
            return false;
        }
        Position _obj = (Position) object;
        if (_obj.row == this.row && _obj.col == this.col) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (row == EMPTY_POSITION && col == EMPTY_POSITION) {
            return true;
        } else {
            return false;
        }
    }

    public void setEmpty() {
        row = EMPTY_POSITION;
        col = EMPTY_POSITION;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Position(row, col);
    }
}
