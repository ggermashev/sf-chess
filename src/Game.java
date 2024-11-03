import Piece.Position;
import Exception.GameOverException;

public class Game {
    private Board board;

    public Game() {
        board = new Board();
    }

    public void move(int fromRow, int fromCol, int toRow, int toCol) throws GameOverException {
        Position from = new Position(fromRow, fromCol);
        Position to = new Position(toRow, toCol);

        board.move(from, to);
    }

    public void printBoard() {
        board.print();
    }

    public String getPieceId(int row, int col) {
        Position position = new Position(row, col);
        return board.getPieceId(position);
    }

    public String getPlayerColor() {
        return board.player.color;
    }
}
