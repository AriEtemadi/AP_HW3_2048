import java.util.Scanner;

class Request {
    private static Scanner scanner = new Scanner(System.in);

    public static String nextLine() {
        return scanner.nextLine();
    }

    private String command;
    private RequestType type;

    void getCommand() {
        command = scanner.nextLine();
    }

    void extractType() {
        type = RequestType.INVALID;
        if (command.equals("4"))
            type = RequestType.LEFT;
        else if (command.equals("6"))
            type = RequestType.RIGHT;
        else if (command.equals("2"))
            type = RequestType.DOWN;
        else if (command.equals("8"))
            type = RequestType.UP;
    }

    RequestType getType() {
        return type;
    }
}
