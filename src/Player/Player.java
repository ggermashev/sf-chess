package Player;
import java.util.Objects;
import Exception.GameOverException;

public abstract class Player {
    public String pawnId;
    public String rookId;
    public String horseId;
    public String bishopId;
    public String queenId;
    public String kingId;
    public String color;

    private AlivePieces alivePieces;

    Player() {
        alivePieces = new AlivePieces();
    }

    public void killPiece(String id) throws GameOverException {
        alivePieces.kill((id));
    }

    private class AlivePieces {
        public int pawn;
        public int rook;
        public int horse;
        public int bishop;
        public int queen;
        public int king;

        AlivePieces() {
            pawn = 8;
            rook = 2;
            horse = 2;
            bishop = 2;
            queen = 1;
            king = 1;
        }

        public void kill(String id) throws GameOverException {
            if (Objects.equals(id, pawnId)) {
                pawn--;
            }
            if (Objects.equals(id, rookId)) {
                rook--;
            }
            if (Objects.equals(id, horseId)) {
                horse--;
            }
            if (Objects.equals(id, bishopId)) {
                bishop--;
            }
            if (Objects.equals(id, queenId)) {
                queen--;
            }
            if (Objects.equals(id, kingId)) {
                throw new GameOverException();
            }

        }
    }

}


