# Шахматы 

## Критерии оценки

- Реализован класс [ChessPiece](./src/Piece/Piece.java)
- Реализован класс [Horse](./src/Piece/Horse.java)
- Реализован класс [Pawn](./src/Piece/Pawn.java)
- Реализован класс [Bishop](./src/Piece/Bishop.java)
- Реализован класс [Rook](./src/Piece/Rook.java)
- Реализован класс [Queen](./src/Piece/Queen.java) и [King](./src/Piece/King.java)
- Реализована возможность [рокировки](./src/Board.java)
  ```
    // Рокировка
    if (piece instanceof King && target instanceof Rook && piece.color == target.color) {
        if (!piece.firstMove || !target.firstMove) { return false; }
    
        int fromCol = Math.min(from.col, to.col);
        int toCol = Math.max(from.col, to.col);
        for (int col = fromCol + 1; col < toCol - 1; col++) {
            if (field[from.row][col].color != null) { return false; }
        }
    
        field[from.row][from.col] = new Empty(from);
        field[to.row][to.col] = new Empty(to);
        int delta = toCol > from.col ? -1 : 2;
        field[to.row][to.col + delta] = piece;
        field[to.row][to.col + 2*delta - delta/2] = target;
    
        piece.firstMove = false;
        target.firstMove = false;
        changePlayer();
        return true;
    }
  ```
- Реализована атака фигур
  ```
  public abstract boolean mayGo(Piece[][] board, Position position, Position toGo)
  ```
- Фигуры не проходят друг через друга
  ```
  public abstract boolean mayGo(Piece[][] board, Position position, Position toGo)
  ```
- Соблюдены принципы Java Code Style и SOLID

## Тесты
Весь функционал покрыт [тестами](./src/GameTest.java)

## Как играть
Чтобы сходить фигурой, в консоль необходимо ввести строку в формате
```
A2 A4
```