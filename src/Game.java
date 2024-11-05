import Piece.Position;
import Exception.GameOverException;

public class Game {
    private ChessBoard board;

    public Game() {
        board = new ChessBoard();
    }

    public void move(int fromRow, int fromCol, int toRow, int toCol) throws GameOverException {
        Position from = new Position(fromRow, fromCol);
        Position to = new Position(toRow, toCol);

        board.moveToPosition(from, to);
    }

    public void printBoard() {
        board.printBoard();
    }

    public String getPieceId(int row, int col) {
        Position position = new Position(row, col);
        return board.getPieceId(position);
    }

    public String getPlayerColor() {
        return board.nowPlayer.color;
    }
}
