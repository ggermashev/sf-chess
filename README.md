# Шахматы 

## Критерии оценки

- Реализован класс [ChessPiece](./src/Piece/ChessPiece.java)
- Реализован класс [Horse](./src/Piece/Horse.java)
- Реализован класс [Pawn](./src/Piece/Pawn.java)
- Реализован класс [Bishop](./src/Piece/Bishop.java)
- Реализован класс [Rook](./src/Piece/Rook.java)
- Реализован класс [Queen](./src/Piece/Queen.java) и [King](./src/Piece/King.java)
- Реализована возможность [рокировки](./src/ChessBoard.java)
  ```
    private boolean castling(ChessPiece piece, ChessPiece target, Position from, Position to) {
        if (!piece.check || !target.check) { return false; }

        int fromCol = Math.min(from.col, to.col);
        int toCol = Math.max(from.col, to.col);
        for (int col = fromCol + 1; col < toCol - 1; col++) {
            if (board[from.row][col].getColor() != null) { return false; }
        }

        board[from.row][from.col] = new Empty();
        board[to.row][to.col] = new Empty();
        int delta = toCol > from.col ? -1 : 2;

        Position toGo = new Position(to.row, to.col + delta);
        try {
            if (((King) piece).isUnderAttack(board, toGo)) {
                return false;
            }
        } catch (Exception e) { return false; }

        board[to.row][to.col + delta] = piece;
        board[to.row][to.col + 2*delta - delta/2] = target;

        piece.check = false;
        target.check = false;
        changePlayer();
        return true;
    }
  ```
  PS. Решил реализовать рокировку одним методом вместо двух. По сути необходимо проверять одно и то же, но 
  в разных направлениях. Рокировка делается, если сначала выбрать короля, 
  а затем сходить им на клетку, где стоит ладья.
  По итогу кода получилось в 4 раза меньше, чем в примере.
  
  
- Реализована атака фигур

  Для каждой фигуры реализовано в:
  ```
    public abstract boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) throws EmptyFieldException;
  ```
- Фигуры не проходят друг через друга

  Для каждой фигуры реализовано в:
  ```
    public abstract boolean canMoveToPosition(ChessPiece[][] board, Position position, Position toGo) throws EmptyFieldException;
  ```
- Соблюдены принципы Java Code Style и SOLID

## Тесты
Весь функционал покрыт [тестами](./src/GameTest.java)

## Как играть
Чтобы сходить фигурой, в консоль необходимо ввести строку в формате
```
A2 A4
```