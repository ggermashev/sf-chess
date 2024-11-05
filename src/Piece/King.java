package Piece;

import Player.Player;
import Exception.EmptyFieldException;

import java.util.ArrayList;
import java.util.List;

public class King extends ChessPiece {
    public King(Player player) {
        super(player);
        id = player.kingId;;
    }

    public boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) throws EmptyFieldException {
        List<Position> mays = new ArrayList<Position>();
        int row = position.row;
        int col = position.col;

        for (int r = -1; r < 2; r++) {
            for (int c = -1; c < 2; c++) {
                if (r == 0 && c == 0) { continue;}
                if (row + r < 0 || row + r > 7 || col + c < 0 || col + c > 7) { continue; }
                if (board[row+r][col+c].color != color ) { mays.add(new Position(row+r, col+c)); }
            }
        }

        for (Position may: mays) {
            if (may.isEqual(toGo)) {
                return true;
            }
        }

        return false;
    }

    public boolean isUnderAttack(ChessPiece[][] board, Position toGo) throws EmptyFieldException {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Position position = new Position(row, col);
                ChessPiece piece = board[row][col];
                if (piece.color != null && piece.color != color && piece.canMoveToPosition(board, position, toGo)) {
                    return true;
                }
            }
        }

        return false;
    }
}
