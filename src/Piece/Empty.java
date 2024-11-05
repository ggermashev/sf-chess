package Piece;

import Exception.EmptyFieldException;

public class Empty extends ChessPiece {

    public Empty() {
        super(null);
        this.color = null;
        this.id = null;
    }

    public boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) throws EmptyFieldException{
        throw new EmptyFieldException();
    }
}
