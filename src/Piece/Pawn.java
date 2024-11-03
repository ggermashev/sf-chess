package Piece;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(Player player, Position position) {
        super(player, position);
        id = player.pawnId;;
    }

    public boolean mayGo(Piece[][] board, Position position, Position toGo) {

        List<Position> mays = new ArrayList<Position>();
        int row = position.row;
        int col = position.col;

        if (color == "white") {
            if (row == 7) { return false; }
            if (board[row+1][col].color == null) { mays.add(new Position(row+1, col)); }
            if (row == 1 && board[row+2][col].color == null) { mays.add(new Position(row+2, col)); }
            if (col > 0 && board[row+1][col-1].color == "black") { mays.add(new Position(row+1, col-1)); }
            if (col < 7 && board[row+1][col+1].color == "black") { mays.add(new Position(row+1, col+1)); }
        }
        if (color == "black") {
            if (row == 0) { return false; }
            if (board[row-1][col].color == null) { mays.add(new Position(row-1, col)); }
            if (row == 6 && board[row-2][col].color == null) { mays.add(new Position(row-2, col)); }
            if (col > 0 && board[row-1][col-1].color == "white") { mays.add(new Position(row-1, col-1)); }
            if (col < 7 && board[row-1][col+1].color == "white") { mays.add(new Position(row-1, col+1)); }
        }

        for (Position may: mays) {
            if (may.isEqual(toGo)) { return true; }
        }

        return false;
    }
}
