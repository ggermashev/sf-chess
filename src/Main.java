import java.util.Scanner;
import Exception.GameOverException;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        GameTest gameTest = new GameTest();
        gameTest.test();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Ходят ".concat(game.getPlayerColor()));
            game.printBoard();
            String move = scanner.nextLine();
            String[] parsedMove = move.split(" ");
            if (parsedMove.length != 2) {
                System.out.println("Choose piece and cell to move again. Example:\nA2 A4");
                continue;
            }

            String from = parsedMove[0];
            String to = parsedMove[1];
            if (from.length() != 2 || to.length() != 2) {
                System.out.println("Choose piece and cell to move again. Example:\nA2 A4");
                continue;
            }

            String[] parsedFrom = from.split("");
            String[] parsedTo = to.split("");

            int fromCol = parsedFrom[0].charAt(0) - 65;
            int fromRow = Integer.parseInt(parsedFrom[1]) - 1;
            int toCol = parsedTo[0].charAt(0) - 65;
            int toRow = Integer.parseInt(parsedTo[1]) - 1;

            if (fromRow < 0 || fromRow > 7 || fromCol < 0 || fromCol > 7 || toRow < 0 || toRow > 7 || toCol < 0 || toCol > 7) {
                System.out.println("Choose piece and cell to move again. Example:\nA2 A4");
                continue;
            }

            try {
                game.move(fromRow, fromCol, toRow, toCol);
            } catch (GameOverException e) {
                System.out.println(game.getPlayerColor().concat(" wins!"));
                return;
            }
        }
    }
}
