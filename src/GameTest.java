import Exception.GameOverException;

public class GameTest {
    Game game;
    boolean allGood;

    public GameTest() {
        game = new Game();
        allGood = true;
    }

    public void test() {
        testPawn();
        testRook();
        testHorse();
        testBishop();
        testQueen();
        testKing();
        testCastling();

        if (allGood) {
            System.out.println("Tests are good! You can play now");
        }
    }

    public void testPawn() {
        System.out.println("Testing pawn...");

        testWhitePawn1();
        testWhitePawn2();
        testWhitePawn3();

        testBlackPawn1();
        testBlackPawn2();
        testBlackPawn3();

        testWhitePawnKillLeft();
        testWhitePawnKillRight();
        testBlackPawnKillLeft();
        testBlackPawnKillRight();

        testPawnCantForward();
    }

    public void testRook() {
        System.out.println("Testing rook...");

        testRookMove();
        testRookThroughPiece();
        testRookWrongMove();
        testRookKill();
        testRookThroughEnemy();
    }

    public void testHorse() {
        System.out.println("Testing horse...");

        testHorseMove1();
        testHorseMove2();
        testHorseMove3();
        testHorseMove4();
        testHorseMove5();
        testHorseMove6();
        testHorseMove7();
        testHorseMove8();
        testHorseCantMove();
        testHorseCanKill();
    }

    public void testBishop() {
        System.out.println("Testing bishop...");

        testBishopMove();
        testBishopCantMove();
        testBishopKill();
    }

    public void testQueen() {
        System.out.println("Testing queen...");

        testQueenMove();
        testQueenCantMove();
        testQueenKill();
    }

    public void testKing() {
        System.out.println("Testing king...");

        testKingMove();
        testKingCantMove();
        testKingKill();
        testKingKilled();
    }

    public void testCastling() {
        System.out.println("Testing castling...");

        testCastlingLong();
        testCastlingShort();
        testCantCastling();
    }

    private void beforeTest() {
        game = new Game();
    }

    private void testWhitePawn1() {
        beforeTest();
        try {
            game.move(1,0,2,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test white pawn 1 failed");

            return;
        }
        String id = game.getPieceId(2, 0);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test white pawn 1 failed");
    }

    private void testWhitePawn2() {
        beforeTest();
        try {
            game.move(1,0,3,0);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test white pawn 2 failed");

            return;
        }
        String id = game.getPieceId(3, 0);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test white pawn 2 failed");
    }

    private void testWhitePawn3() {
        beforeTest();
        try {
            game.move(1,0,4,0);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test white pawn 3 failed");

            return;
        }
        String id = game.getPieceId(4, 0);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test white pawn 3 failed");
    }

    private void testWhitePawnKillLeft() {
        beforeTest();
        try {
            game.move(1,4,3,4);
            game.move( 6, 3, 4, 3);
            game.move(3,4,4,3);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test white pawn kill left failed");

            return;
        }

        String id = game.getPieceId(4, 3);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test white pawn kill left failed");
    }

    private void testWhitePawnKillRight() {
        beforeTest();
        try {
            game.move(1,4,3,4);
            game.move( 6, 5, 4, 5);
            game.move(3,4,4,5);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test white pawn kill right failed");

            return;
        }

        String id = game.getPieceId(4, 5);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test white pawn kill right failed");
    }

    private void testBlackPawn1() {
        beforeTest();
        try {
            game.move(1,0,2,0);
            game.move(6,0,5,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test black pawn 1 failed");

            return;
        }


        String id = game.getPieceId(5, 0);
        if (id == "bp") { return; }

        allGood = false;
        System.out.println("test black pawn 1 failed");
    }

    private void testBlackPawn2() {
        beforeTest();
        try {
            game.move(1,0,2,0);
            game.move(6,0,4,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test black pawn 2 failed");

            return;
        }

        String id = game.getPieceId(4, 0);
        if (id == "bp") { return; }

        allGood = false;
        System.out.println("test black pawn 2 failed");
    }

    private void testBlackPawn3() {
        beforeTest();
        try {
            game.move(1,0,2,0);
            game.move(6,0,3,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test black pawn 3 failed");

            return;
        }

        String id = game.getPieceId(3, 0);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test black pawn 3 failed");
    }

    private void testBlackPawnKillLeft() {
        beforeTest();
        try {
            game.move(1,4,3,4);
            game.move( 6, 5, 4, 5);
            game.move( 1, 0, 3, 0);
            game.move(4,5,3,4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test black pawn kill left failed");

            return;
        }

        String id = game.getPieceId(3, 4);
        if (id == "bp") { return; }

        allGood = false;
        System.out.println("test black pawn kill left failed");
    }

    private void testBlackPawnKillRight() {
        beforeTest();
        try {
            game.move(1,4,3,4);
            game.move( 6, 3, 4, 3);
            game.move( 1, 0, 3, 0);
            game.move(4,3,3,4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test black pawn kill right failed");

            return;
        }

        String id = game.getPieceId(3,4);
        if (id == "bp") { return; }

        allGood = false;
        System.out.println("test black pawn kill right failed");
    }

    private void testPawnCantForward() {
        beforeTest();
        try {
            game.move(1, 0, 3, 0);
            game.move(6, 0, 5, 0);
            game.move(0, 0, 2, 0);
            game.move(5, 0, 4, 0);
            game.move(2, 0, 2, 1);
            game.move(4, 0, 3, 0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test pawn cant go forward failed");

            return;
        }


        String id = game.getPieceId(3, 0);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test pawn cant go forward failed");
    }

    private void testRookThroughPiece() {
        beforeTest();
        try {
            game.move(0, 0, 3, 0);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test rook through piece failed");

            return;
        }

        String id = game.getPieceId(3, 0);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test rook through piece failed");
    }

    private void testRookMove() {
        beforeTest();
        try {
            game.move(1, 0, 3, 0);
            game.move(6, 0, 5, 0);
            game.move(0, 0, 2, 0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test rook move failed");

            return;
        }


        String id = game.getPieceId(2, 0);
        if (id == "wr") { return; }

        allGood = false;
        System.out.println("test rook move failed");
    }

    private void testRookWrongMove() {
        beforeTest();
        try {
            game.move(1, 0, 3, 0);
            game.move(6, 0, 5, 0);
            game.move(0, 0, 2, 1);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test rook wrong move failed");

            return;
        }


        String id = game.getPieceId(2, 1);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test rook wrong move failed");
    }

    private void testRookKill() {
        beforeTest();
        try {
            game.move(1, 0, 3, 0);
            game.move(6, 0, 5, 0);
            game.move(0, 0, 2, 0);
            game.move(5, 0, 4, 0);
            game.move(2, 0, 2, 1);
            game.move(6, 1, 5, 1);
            game.move(2, 1, 5, 1);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test rook kill failed");

            return;
        }


        String id = game.getPieceId(5, 1);
        if (id == "wr") { return; }

        allGood = false;
        System.out.println("test rook kill failed");
    }

    private void testRookThroughEnemy() {
        beforeTest();
        try {
            game.move(1, 0, 3, 0);
            game.move(6, 0, 5, 0);
            game.move(0, 0, 2, 0);
            game.move(5, 0, 4, 0);
            game.move(2, 0, 2, 1);
            game.move(6, 1, 5, 1);
            game.move(2, 1, 6, 1);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test rook through enemy failed");

            return;
        }


        String id = game.getPieceId(6, 1);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test rook through enemy failed");
    }

    private void testHorseMove1() {
        beforeTest();
        try {
            game.move(0,1,2,2);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 1 failed");

            return;
        }
        String id = game.getPieceId(2, 2);
        if (id == "wh") { return; }

        allGood = false;
        System.out.println("test horse move 1 failed");
    }
    private void testHorseMove2() {
        beforeTest();
        try {
            game.move(0,1,2,0);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 2 failed");

            return;
        }
        String id = game.getPieceId(2, 0);
        if (id == "wh") { return; }

        allGood = false;
        System.out.println("test horse move 2 failed");
    }
    private void testHorseMove3() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(6,0,5,0);
            game.move(2,2,3,4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 3 failed");

            return;
        }


        String id = game.getPieceId(3, 4);
        if (id == "wh") { return; }

        allGood = false;
        System.out.println("test horse move 3 failed");
    }
    private void testHorseMove4() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(6,0,5,0);
            game.move(2,2,3,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 4 failed");

            return;
        }


        String id = game.getPieceId(3, 0);
        if (id == "wh") { return; }

        allGood = false;
        System.out.println("test horse move 4 failed");
    }
    private void testHorseMove5() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(7,1,5,2);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 5 failed");

            return;
        }


        String id = game.getPieceId(5, 2);
        if (id == "bh") { return; }

        allGood = false;
        System.out.println("test horse move 5 failed");
    }
    private void testHorseMove6() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(7,1,5,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 6 failed");

            return;
        }


        String id = game.getPieceId(5, 0);
        if (id == "bh") { return; }

        allGood = false;
        System.out.println("test horse move 6 failed");
    }
    private void testHorseMove7() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(7,1,5,2);
            game.move(1,0,2,0);
            game.move(5,2,4,4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 7 failed");

            return;
        }



        String id = game.getPieceId(4, 4);
        if (id == "bh") { return; }

        allGood = false;
        System.out.println("test horse move 7 failed");
    }
    private void testHorseMove8() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(7,1,5,2);
            game.move(1,0,2,0);
            game.move(5,2,4,0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse move 8 failed");

            return;
        }



        String id = game.getPieceId(4, 0);
        if (id == "bh") { return; }

        allGood = false;
        System.out.println("test horse move 8 failed");
    }

    private void testHorseCantMove() {
        beforeTest();
        try {
            game.move(0,1,3,1);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse cant move failed");

            return;
        }
        String id = game.getPieceId(3, 1);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test horse cant move failed");
    }

    private void testHorseCanKill() {
        beforeTest();
        try {
            game.move(0,1,2,2);
            game.move(6,3,4,3);
            game.move(2,2,4,3);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test horse can kill failed");

            return;
        }



        String id = game.getPieceId(4, 3);
        if (id == "wh") { return; }

        allGood = false;
        System.out.println("test horse can kill failed");
    }

    private void testBishopMove() {
        beforeTest();
        try {
            game.move(1, 4, 2, 4);
            game.move(6,0,5,0);
            game.move(0, 5, 1, 4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test bishop can move failed");

            return;
        }


        String id = game.getPieceId(1, 4);
        if (id == "wb") { return; }

        allGood = false;
        System.out.println("test bishop can move failed");
    }

    private void testBishopCantMove() {
        beforeTest();
        try {
            game.move(0, 5, 2, 3);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test bishop cant move failed");

            return;
        }

        String id = game.getPieceId(2, 3);
        if (id == null) { return; }

        allGood = false;
        System.out.println("test bishop cant move failed");
    }

    private void testBishopKill() {
        beforeTest();
        try {
            game.move(1, 4, 2, 4);
            game.move(6,0,5,0);
            game.move(0, 5, 5, 0);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test bishop can kill failed");

            return;
        }


        String id = game.getPieceId(5, 0);
        if (id == "wb") { return; }

        allGood = false;
        System.out.println("test bishop can kill failed");
    }

    private void testQueenMove() {
        beforeTest();
        try {
            game.move(1, 4, 2, 4);
            game.move(6,0,5,0);
            game.move(0, 3, 1, 4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test queen can move failed");

            return;
        }


        String id = game.getPieceId(1, 4);
        if (id == "wq") { return; }

        allGood = false;
        System.out.println("test queen can move failed");
    }

    private void testQueenCantMove() {
        beforeTest();
        try {
            game.move(0, 3, 1, 4);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test queen cant move failed");

            return;
        }

        String id = game.getPieceId(1, 4);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test queen cant move failed");
    }

    private void testQueenKill() {
        beforeTest();
        try {
            game.move(1, 4, 2, 4);
            game.move(6,7,4,7);
            game.move(0, 3, 4, 7);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test queen can kill failed");

            return;
        }


        String id = game.getPieceId(4, 7);
        if (id == "wq") { return; }

        allGood = false;
        System.out.println("test queen can kill failed");
    }

    private void testKingMove() {
        beforeTest();
        try {
            game.move(1, 4, 2, 4);
            game.move(6,0,5,0);
            game.move(0, 4, 1, 4);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test king can move failed");

            return;
        }


        String id = game.getPieceId(1, 4);
        if (id == "wk") { return; }

        allGood = false;
        System.out.println("test king can move failed");
    }

    private void testKingCantMove() {
        beforeTest();
        try {
            game.move(0, 4, 1, 4);


        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test king cant move failed");

            return;
        }

        String id = game.getPieceId(1, 4);
        if (id == "wp") { return; }

        allGood = false;
        System.out.println("test king cant move failed");
    }

    private void testKingKill() {
        beforeTest();
        try {
            game.move(1, 3, 2, 3);
            game.move(6,4,5,4);
            game.move(1, 0, 2, 0);
            game.move(7, 3, 4, 6);
            game.move(2, 0, 3, 0);
            game.move(4, 6, 1, 3);
            game.move(0, 4, 1, 3);

        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test king can kill failed");

            return;
        }



        String id = game.getPieceId(1, 3);
        if (id == "wk") { return; }

        allGood = false;
        System.out.println("test king can kill failed");
    }
    private void testKingKilled() {
        beforeTest();
        try {
            game.move(1, 3, 2, 3);
            game.move(6,4,5,4);
            game.move(0, 4, 1, 3);
            game.move(7, 3, 4, 6);
            game.move(1, 0, 3, 0);
            game.move(4, 6, 1, 3);
        } catch (GameOverException e) {
            return;
        }

        allGood = false;
        System.out.println("test king can be killed failed");
    }

    private void testCastlingShort() {
        beforeTest();
        try {
            game.move(1, 6, 2, 6);
            game.move(6, 6, 5, 6);
            game.move(0, 6, 2, 7);
            game.move(5, 6, 4, 6);
            game.move(0, 5, 1, 6);
            game.move(4, 6, 3, 6);
            game.move(0, 4, 0, 7);
        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test castling short failed");

            return;
        }

        String idK = game.getPieceId(0, 6);
        String idR = game.getPieceId(0, 5);

        if (idK == "wk" && idR == "wr") { return; }

        allGood = false;
        System.out.println("test castling short failed");
    }

    private void testCastlingLong() {
        beforeTest();
        try {
            game.move(1, 3, 2, 3);
            game.move(6, 6, 5, 6);
            game.move(0, 2, 2, 4);
            game.move(5, 6, 4, 6);
            game.move(0, 3, 1, 3);
            game.move(4, 6, 3, 6);
            game.move(0, 1, 2, 0);
            game.move(3, 6, 2, 6);
            game.move(0, 4, 0, 0);
        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test castling long failed");

            return;
        }

        String idK = game.getPieceId(0, 2);
        String idR = game.getPieceId(0, 3);

        if (idK == "wk" && idR == "wr") { return; }

        allGood = false;
        System.out.println("test castling long failed");
    }

    private void testCantCastling() {
        beforeTest();
        try {
            game.move(0, 4, 0, 7    );
        } catch (GameOverException e) {
            allGood = false;
            System.out.println("test cant castling failed");

            return;
        }

        String id = game.getPieceId(0, 6);
        if (id != "wk") { return; }

        allGood = false;
        System.out.println("test cant castling failed");
    }

}
