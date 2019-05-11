class Game {
    private Table table;
    private Request request = new Request();

    Game(int n) {
        this.table = new Table(n);
    }

    void play() {
        gameLoop:
        while (true) {
            table.draw();
            request.getCommand();
            request.extractType();
            switch (request.getType()) {
                case UP:
                    table.slideUp();
                    break;
                case DOWN:
                    table.slideDown();
                    break;
                case RIGHT:
                    table.slideRight();
                    break;
                case LEFT:
                    table.slideLeft();
                    break;
                case BACK:
                    break gameLoop;
                case EXIT:
                    break gameLoop;
                case INVALID:
                    System.out.println("invalid command");
                    break;
            }
            table.popup();
        }
    }
}
