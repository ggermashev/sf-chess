package Piece;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class Horse extends ChessPiece {
    public Horse(Player player ) {
        super(player);
        id = player.horseId;;
    }

    public boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) {
        List<Position> mays = new ArrayList<Position>();
        int row = position.row;
        int col = position.col;

        if (row < 7 && col > 1 && board[row+1][col-2].color != color) { mays.add((new Position(row+1, col-2))); }
        if (row < 7 && col < 6 && board[row+1][col+2].color != color) { mays.add((new Position(row+1, col+2))); }

        if (row < 6 && col < 7 && board[row+2][col+1].color != color) { mays.add((new Position(row+2, col+1))); }
        if (row < 6 && col > 0 && board[row+2][col-1].color != color) { mays.add((new Position(row+2, col-1))); }

        if (row > 0 && col < 6 && board[row-1][col+2].color != color) { mays.add((new Position(row-1, col+2))); }
        if (row > 0 && col > 1 && board[row-1][col-2].color != color) { mays.add((new Position(row-1, col-2))); }

        if (row > 1 && col > 0 && board[row-2][col-1].color != color) { mays.add((new Position(row-2, col-1))); }
        if (row > 1 && col < 7 && board[row-2][col+1].color != color) { mays.add((new Position(row-2, col+1))); }


        for (Position may: mays) {
            if (may.isEqual(toGo)) { return true; }
        }

        return false;
    }
}
