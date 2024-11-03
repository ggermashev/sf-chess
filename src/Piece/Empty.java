package Piece;

import Exception.EmptyFieldException;

public class Empty extends Piece {

    public Empty(Position position) {
        super(null, position);
        this.color = null;
        this.id = null;
    }

    public boolean mayGo(Piece[][] board, Position position, Position toGo) throws EmptyFieldException{
        throw new EmptyFieldException();
    }
}
