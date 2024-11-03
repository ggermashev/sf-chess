package Piece;

import Player.Player;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Player player, Position position) {
        super(player, position);
        id = player.kingId;;
    }

    public boolean mayGo(Piece[][] board, Position position, Position toGo) {
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
            if (may.isEqual(toGo)) { return true; }
        }

        return false;
    }
}
