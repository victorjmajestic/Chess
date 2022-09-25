/**
 * A class that represents a queen piece.
 * @author Victor Majestic
 */

public class QueenPiece extends ChessPiece {
  
  /*
   * A constructor that initializes a ___ piece.
   * @param label the label of the piece.
   * @param side the side the piece belongs to.
   */
  public QueenPiece(String label, Side side) {
    super("Q", side);
  }
  
  /**
   * Determines the legality of a move that does not capture.
   * The legality of a queen is if it moves in any direction in a straight, as long as there are no pieces in the way.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == false) {
      if (toRow != getRow() && toColumn == getColumn()) {
        for (int i = getRow(); i < toRow; i = i + 1) {                      // i is an index that refers to certain squares on the board.
          if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
        }
        return true;
      }
      if (toRow == getRow() && toColumn != getColumn()) {
        for (int i = getColumn(); i < toColumn; i = i + 1) {                // i is an index that refers to certain squares on the board.
          if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
        }
        return true;
      }
      if (toRow - getRow() == toColumn - getColumn()) {
        if (toRow - getRow() > 0) {
          for (int i = getRow(); i < toRow; i = i + 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
              return false;
            }
          }
          return true;
        }
        if (toRow - getRow() < 0) {
          for (int i = getRow(); i < toRow; i = i - 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
              return false;
            }
          }
          return true;
        }
      }
    }
    return false;
  }
  
  /**
   * Determines the legality of a queen move, except it captures.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalCaptureMove(int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
      if (toRow != getRow() && toColumn == getColumn()) {
        for (int i = getRow(); i < toRow; i = i + 1) {                     // i is an index that refers to certain squares on the board.
          if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
        }
        return true;
      }
      if (toRow == getRow() && toColumn != getColumn()) {
        for (int i = getColumn(); i < toColumn; i = i + 1) {              // i is an index that refers to certain squares on the board.
          if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
        }
        return true;
      }
      if (toRow - getRow() == toColumn - getColumn()) {
        if (toRow - getRow() > 0) {
          for (int i = getRow(); i < toRow; i = i + 1) {                  // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
              return false;
            }
          }
          return true;
        }
        if (toRow - getRow() < 0) {
          for (int i = getRow(); i < toRow; i = i - 1) {                  // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
              return false;
            }
          }
          return true;
        }
      }
    }
    return false;
  }
  
  /* Determines if the piece can be played, which is true if it is either a valid capture or non-capture move.
   * @param piece the piece that is to move.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if a move can be made legally, false if it cannot.
   */
  public boolean legalPieceToPlay(ChessPiece piece, int toRow, int toColumn) {
    if (piece.isLegalNonCaptureMove(toRow, toColumn) || piece.isLegalCaptureMove(toRow, toColumn)) {
      return true;
    }
    return false;
  }
  
  /* Moves the piece.
   * @param piece the piece that is moved.
   * @param toRow the row the piece is moved to.
   * @param toColumn the column the piece is moved to.
   * @return true if a move was made successfully, false if it does not.
   */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (legalPieceToPlay(piece, toRow, toColumn) == true) {
      makeMove(piece, toRow, toColumn);
      return true;
    }
    return false;
  }
  
  /*
   * Mandatory overridden method, does nothing.
   */
  public int getNumColumns() {
    return 0;
  }
  
  /*
   * Mandatory overridden method, does nothing.
   */
  public int getNumRows() {
    return 0;
  }
  
  /*
   * Mandatory overridden method, does nothing.
   */
  public void startGame(ChessBoard board) {
  }
}