import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Table {

    private int length;
    private Cell[][] cells;

    Table(int n) {
        this.length = n;
        this.cells = new Cell[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cells[i][j] = new Cell(i, j);
    }

    void slideUp() {
        for (int i = 0; i < length; i++) {
            int j = 0;
            while (j < length) {
                if (cells[j][i].isEmpty()) {
                    j++;
                    continue;
                }
                if (j > 0 && cells[j - 1][i].isEmpty()) {
                    cells[j][i].swap(cells[j - 1][i]);
                    j--;
                    continue;
                }
                if (j > 0 && !cells[j - 1][i].isEmpty()) {
                    if (cells[j][i].getValue() == cells[j - 1][i].getValue()) {
                        cells[j - 1][i].aggregate(cells[j][i]);
                        j--;
                        continue;
                    }
                }
                j++;
            }
        }
    }

    void slideDown() {
        Table tmp = new Table(length);
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                tmp.cells[i][j].setValue(this.cells[length - 1 - i][j].getValue());
        tmp.slideUp();
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                this.cells[i][j].setValue(tmp.cells[length - 1 - i][j].getValue());
    }

    void slideRight() {
        Table tmp = new Table(length);
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                tmp.cells[i][j].setValue(this.cells[j][length - 1 - i].getValue());
        tmp.slideUp();
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                this.cells[i][j].setValue(tmp.cells[length - 1 - j][i].getValue());
    }

    void slideLeft() {
        Table tmp = new Table(length);
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                tmp.cells[i][j].setValue(this.cells[length - 1 - j][i].getValue());
        tmp.slideUp();
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                this.cells[i][j].setValue(tmp.cells[j][length - 1 - i].getValue());
    }

    void popup() {
        Random random = new Random();
        int num = random.nextInt(2) + 1;
        getRandomEmptyCell().setValue(num);
    }

    private Cell getRandomEmptyCell() {
        Random random = new Random();
        List<Cell> empties = getEmptyCells();
        return empties.get(random.nextInt(empties.size()));
    }

    private List<Cell> getEmptyCells() {
        List<Cell> empties = new ArrayList<>();
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++)
                if (cells[i][j].isEmpty())
                    empties.add(cells[i][j]);
        return empties;
    }

    void draw() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++)
                System.out.print(" ----");
            System.out.println();
            for (int j = 0; j < length; j++)
                System.out.printf("|%4d", cells[i][j].getValue());
            System.out.println("|");
        }
        for (int j = 0; j < length; j++)
            System.out.print(" ----");
        System.out.println();
    }
}
