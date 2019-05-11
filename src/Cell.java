class Cell {
    private int x;
    private int y;
    private int value;

    Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    void setX(int x) {
        this.x = x;
    }

    int getY() {
        return y;
    }

    void setY(int y) {
        this.y = y;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

    boolean isEmpty() {
        return value == 0;
    }

    void swap(Cell cell) {
        int tmp = this.value;
        this.value = cell.value;
        cell.value = tmp;
    }

    void aggregate(Cell cell) {
        this.value += cell.value;
        cell.value = 0;
    }
}
