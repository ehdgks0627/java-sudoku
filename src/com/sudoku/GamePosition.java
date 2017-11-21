package com.sudoku;

public class GamePosition extends Object {
    int x;
    int y;

    public GamePosition() {
        this(-1, -1);
    }

    public GamePosition(int x, int y) {
        if (x >= 0) {
            this.x = x;
        } else {
            this.x = -1;
        }
        if (y >= 0) {
            this.y = y;
        } else {
            this.y = -1;
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
        if (_obj.x == this.x && _obj.y == this.y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (x == -1 && y == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void setEmpty() {
        x = -1;
        y = -1;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new GamePosition(x, y);
    }
}
