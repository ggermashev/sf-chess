package Piece;

import Player.Player;
import Exception.EmptyFieldException;


public abstract class Piece {
    public String color;
    public String id;
    public boolean firstMove;

    public Piece(Player player, Position position) {
        if (player != null) {
            color = player.color;
            firstMove = true;
        }
    }

    public abstract boolean mayGo(Piece[][] board, Position position, Position toGo) throws EmptyFieldException;

    public String getId() {
        return id != null ? id : "__";
    }
}




