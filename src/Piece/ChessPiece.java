package Piece;

import Player.Player;
import Exception.EmptyFieldException;


public abstract class ChessPiece {
    protected String color;
    protected String id;
    public boolean check;

    public ChessPiece(Player player) {
        if (player != null) {
            color = player.color;
            check = true;
        }
    }

    public abstract boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) throws EmptyFieldException;

    public String getSymbol() {
        return id;
    }

    public String getColor() {
        return color;
    }
}




