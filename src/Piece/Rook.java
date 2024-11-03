package Piece;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece{
    public Rook(Player player, Position position) {
        super(player, position);
        id = player.rookId;;
    }

    public boolean mayGo(Piece[][] board, Position position, Position toGo) {
        List<Position> mays = new ArrayList<Position>();
        int row = position.row;
        int col = position.col;

        for (int r = row-1; r >=0; r--) {
            if (board[r][col].color == null) {
                mays.add(new Position(r, col));
                continue;
            }
            if (board[r][col].color == color) {
                break;
            }
            if (board[r][col].color != color) {
                mays.add(new Position(r, col));
                break;
            }
        }

        for (int r = row+1; r <= 7; r++) {
            if (board[r][col].color == null) {
                mays.add(new Position(r, col));
                continue;
            }
            if (board[r][col].color == color) {
                break;
            }
            if (board[r][col].color != color) {
                mays.add(new Position(r, col));
                break;
            }
        }

        for (int c = col+1; c <= 7; c++) {
            if (board[row][c].color == null) {
                mays.add(new Position(row, c));
                continue;
            }
            if (board[row][c].color == color) {
                break;
            }
            if (board[row][c].color != color) {
                mays.add(new Position(row, c));
                break;
            }
        }

        for (int c = col-1; c >=0; c--) {
            if (board[row][c].color == null) {
                mays.add(new Position(row, c));
                continue;
            }
            if (board[row][c].color == color) {
                break;
            }
            if (board[row][c].color != color) {
                mays.add(new Position(row, c));
                break;
            }
        }

        for (Position may: mays) {
            if (may.isEqual(toGo)) { return true; }
        }

        return false;
    }
}
