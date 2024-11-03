import Piece.Piece;
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


public class Board {
    private Piece[][] field;
    White white;
    Black black;
    Player player;
    Player enemy;

    Board() {
        white = new White();
        black = new Black();
        player = white;
        enemy = black;
        field = new Piece[8][8];
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position position = new Position(row, col);
                if (row == 0) {
                    switch (col) {
                        case 0:
                            field[row][col] = new Rook(white, position);
                            break;
                        case 1:
                            field[row][col] = new Horse(white, position);
                            break;
                        case 2:
                            field[row][col] = new Bishop(white, position);
                            break;
                        case 3:
                            field[row][col] = new Queen(white, position);
                            break;
                        case 4:
                            field[row][col] = new King(white, position);
                            break;
                        case 5:
                            field[row][col] = new Bishop(white, position);
                            break;
                        case 6:
                            field[row][col] = new Horse(white, position);
                            break;
                        case 7:
                            field[row][col] = new Rook(white, position);
                            break;

                    }
                }
                else if (row == 1) {
                    field[row][col] = new Pawn(white, position);
                }
                else if (row == 6) {
                    field[row][col] = new Pawn(black, position);
                }
                else if (row == 7) {
                    switch (col) {
                        case 0:
                            field[row][col] = new Rook(black, position);
                            break;
                        case 1:
                            field[row][col] = new Horse(black, position);
                            break;
                        case 2:
                            field[row][col] = new Bishop(black, position);
                            break;
                        case 3:
                            field[row][col] = new Queen(black, position);
                            break;
                        case 4:
                            field[row][col] = new King(black, position);
                            break;
                        case 5:
                            field[row][col] = new Bishop(black, position);
                            break;
                        case 6:
                            field[row][col] = new Horse(black, position);
                            break;
                        case 7:
                            field[row][col] = new Rook(black, position);
                            break;

                    }
                } else {
                    field[row][col] = new Empty(position);
                }
            }
        }
    }

    public boolean move(Position from, Position to) throws GameOverException {
        Piece piece = field[from.row][from.col];
        Piece target = field[to.row][to.col];

        // Рокировка
        if (piece instanceof King && target instanceof Rook && piece.color == target.color) {
            if (!piece.firstMove || !target.firstMove) { return false; }

            int fromCol = Math.min(from.col, to.col);
            int toCol = Math.max(from.col, to.col);
            for (int col = fromCol + 1; col < toCol - 1; col++) {
                if (field[from.row][col].color != null) { return false; }
            }

            field[from.row][from.col] = new Empty(from);
            field[to.row][to.col] = new Empty(to);
            int delta = toCol > from.col ? -1 : 2;
            field[to.row][to.col + delta] = piece;
            field[to.row][to.col + 2*delta - delta/2] = target;

            piece.firstMove = false;
            target.firstMove = false;
            changePlayer();
            return true;
        }

        if (player.color != piece.color) {
            System.out.println("You can not move this piece. Try again. ".concat(from.toString()));
            print();
            return false;
        }

        boolean mayGo;
        try {
            mayGo = piece.mayGo(field, from, to);
        } catch (EmptyFieldException e) {
            System.out.println("This field is empty. Nothing to move");
            return false;
        }

        if (mayGo) {
            field[from.row][from.col] = new Empty(from);
            field[to.row][to.col] = piece;

            if (target.id != null) {
                enemy.killPiece(target.id);
            }

            piece.firstMove = false;
            changePlayer();
            return true;
        }

        return false;
    }


    public void print() {
        for (int row = 7; row >= 0; row--) {
            System.out.print(row + 1);
            System.out.print("  ");
            for (int col = 0; col < 8; col++) {
                System.out.print(field[row][col].getId() + " ");
            }
            System.out.println();
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    public String getPieceId(Position position) {
        Piece piece = getPieceByPosition(position);
        return piece.id;
    }

    private void changePlayer() {
        if (player.color == "white") {
            player = black;
            enemy = white;
        } else {
            player = white;
            enemy = black;
        }
    }

    private Piece getPieceByPosition(Position position) {
        return field[position.row][position.col];
    }

}
