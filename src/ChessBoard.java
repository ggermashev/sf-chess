import Piece.ChessPiece;
import Piece.Position;
import Piece.Pawn;
import Piece.Rook;
import Piece.Horse;
import Piece.Bishop;
import Piece.Queen;
import Piece.King;
import Piece.Empty;
import Player.Black;
import Player.Player;
import Player.White;
import Exception.EmptyFieldException;
import Exception.GameOverException;


public class ChessBoard {
    private ChessPiece[][] board;
    White white;
    Black black;
    Player nowPlayer;
    Player enemy;

    ChessBoard() {
        white = new White();
        black = new Black();
        nowPlayer = white;
        enemy = black;
        board = new ChessPiece[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (row == 0) {
                    switch (col) {
                        case 0:
                            board[row][col] = new Rook(white);
                            break;
                        case 1:
                            board[row][col] = new Horse(white);
                            break;
                        case 2:
                            board[row][col] = new Bishop(white);
                            break;
                        case 3:
                            board[row][col] = new Queen(white);
                            break;
                        case 4:
                            board[row][col] = new King(white);
                            break;
                        case 5:
                            board[row][col] = new Bishop(white);
                            break;
                        case 6:
                            board[row][col] = new Horse(white);
                            break;
                        case 7:
                            board[row][col] = new Rook(white);
                            break;

                    }
                }
                else if (row == 1) {
                    board[row][col] = new Pawn(white);
                }
                else if (row == 6) {
                    board[row][col] = new Pawn(black);
                }
                else if (row == 7) {
                    switch (col) {
                        case 0:
                            board[row][col] = new Rook(black);
                            break;
                        case 1:
                            board[row][col] = new Horse(black);
                            break;
                        case 2:
                            board[row][col] = new Bishop(black);
                            break;
                        case 3:
                            board[row][col] = new Queen(black);
                            break;
                        case 4:
                            board[row][col] = new King(black);
                            break;
                        case 5:
                            board[row][col] = new Bishop(black);
                            break;
                        case 6:
                            board[row][col] = new Horse(black);
                            break;
                        case 7:
                            board[row][col] = new Rook(black);
                            break;

                    }
                } else {
                    board[row][col] = new Empty();
                }
            }
        }
    }

    public boolean moveToPosition(Position from, Position to) throws GameOverException {
        ChessPiece piece = board[from.row][from.col];
        ChessPiece target = board[to.row][to.col];

        // Рокировка
        if (piece instanceof King && target instanceof Rook && piece.getColor() == target.getColor()) {
            return castling(piece, target, from, to);
        }

        if (nowPlayer.color != piece.getColor()) {
            System.out.println("You can not move this piece. Try again. ".concat(from.toString()));
            printBoard();
            return false;
        }

        boolean mayGo;
        try {
            mayGo = piece.canMoveToPosition(board, from, to);
            if (mayGo && piece instanceof King) {
                mayGo = !((King) piece).isUnderAttack(board, to);
            }
        } catch (EmptyFieldException e) {
            System.out.println("This field is empty. Nothing to move");
            return false;
        }

        if (mayGo) {
            board[from.row][from.col] = new Empty();
            board[to.row][to.col] = piece;

            if (target.getSymbol() != null) {
                enemy.killPiece(target.getSymbol());
            }

            piece.check = false;
            changePlayer();
            return true;
        }

        return false;
    }


    public void printBoard() {
        for (int row = 7; row >= 0; row--) {
            System.out.print(row + 1);
            System.out.print("  ");
            for (int col = 0; col < 8; col++) {
                String id = board[row][col].getSymbol();
                if (id == null) { id = "__"; }
                System.out.print(id + " ");
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    public String getPieceId(Position position) {
        ChessPiece piece = getPieceByPosition(position);
        return piece.getSymbol();
    }

    private void changePlayer() {
        if (nowPlayer.color == "white") {
            nowPlayer = black;
            enemy = white;
        } else {
            nowPlayer = white;
            enemy = black;
        }
    }

    private ChessPiece getPieceByPosition(Position position) {
        return board[position.row][position.col];
    }

    private boolean castling(ChessPiece piece, ChessPiece target, Position from, Position to) {
        if (!piece.check || !target.check) { return false; }

        int fromCol = Math.min(from.col, to.col);
        int toCol = Math.max(from.col, to.col);
        for (int col = fromCol + 1; col < toCol - 1; col++) {
            if (board[from.row][col].getColor() != null) { return false; }
        }

        board[from.row][from.col] = new Empty();
        board[to.row][to.col] = new Empty();
        int delta = toCol > from.col ? -1 : 2;
        board[to.row][to.col + delta] = piece;
        board[to.row][to.col + 2*delta - delta/2] = target;

        piece.check = false;
        target.check = false;
        changePlayer();
        return true;
    }

}
