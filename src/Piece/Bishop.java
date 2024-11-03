package Piece;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {
    public Bishop(Player player, Position position) {
        super(player, position);
        id = player.bishopId;
    }

    public boolean mayGo(Piece[][] board, Position position, Position toGo) {
        List<Position> mays = new ArrayList<Position>();
        int row = position.row;
        int col = position.col;

        for (int i = 1; i < 8; i++) {
            int r = row + i;
            int c = col + i;
            if (r < 0 || r > 7 || c < 0 || c > 7) {
                break;
            }
            if (board[r][c].color == null) {
                mays.add(new Position(r, c));
                continue;
            }
            if (board[r][c].color != color) {
                mays.add(new Position(r, c));
                break;
            }
            if (board[r][c].color == color) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            int r = row - i;
            int c = col + i;
            if (r < 0 || r > 7 || c < 0 || c > 7) {
                break;
            }
            if (board[r][c].color == null) {
                mays.add(new Position(r, c));
                continue;
            }
            if (board[r][c].color != color) {
                mays.add(new Position(r, c));
                break;
            }
            if (board[r][c].color == color) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            int r = row + i;
            int c = col - i;
            if (r < 0 || r > 7 || c < 0 || c > 7) {
                break;
            }
            if (board[r][c].color == null) {
                mays.add(new Position(r, c));
                continue;
            }
            if (board[r][c].color != color) {
                mays.add(new Position(r, c));
                break;
            }
            if (board[r][c].color == color) {
                break;
            }
        }

        for (int i = 1; i < 8; i++) {
            int r = row - i;
            int c = col - i;
            if (r < 0 || r > 7 || c < 0 || c > 7) {
                break;
            }
            if (board[r][c].color == null) {
                mays.add(new Position(r, c));
                continue;
            }
            if (board[r][c].color != color) {
                mays.add(new Position(r, c));
                break;
            }
            if (board[r][c].color == color) {
                break;
            }
        }

        for (Position may: mays) {
            if (may.isEqual(toGo)) { return true; }
        }

        return false;
    }
}
