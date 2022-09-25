/**
 * A class that represents a bishop piece.
 * @author Victor Majestic
 */

public class BishopPiece extends ChessPiece {
  
  /*
   * A constructor that initializes a bishop piece.
   * @param label the label of the piece.
   * @param side the side the piece belongs to.
   */
  public BishopPiece(String label, Side side) {
    super("B", side);
  }
  
  /**
   * Determines the legality of a move that does not capture.
   * The legality of a bishop is if it moves in a straight line in any direction, and there are no pieces in the way.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalNonCaptureMove(int row, int column) {
    if (super.getChessBoard().hasPiece(row, column) == false) {
      if (row - getRow() == column - getColumn()) {
        if (row - getRow() > 0) {
          for (int i = getRow(); i < row; i = i + 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(row, column) == true) {
              return false;
            }
          }
        }
        if (row - getRow() < 0) {
          for (int i = getRow(); i < row; i = i - 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(row, column) == true) {    
              return false;
            }
          }
        }
      }
      return true;
    }
    return false;
  }
  
  /**
   * Determines the legality of a bishop move, except it captures.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalCaptureMove(int row, int column) {
    if (super.getChessBoard().hasPiece(row, column) == true) {
      if (row - getRow() == column - getColumn()) {
        if (row - getRow() > 0) {
          for (int i = getRow(); i < row; i = i + 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(row, column) == true) {    
              return false;
            }
          }
        }
        if (row - getRow() < 0) {
          for (int i = getRow(); i < row; i = i - 1) {                    // i is an index that refers to certain squares on the board.
            if (super.getChessBoard().hasPiece(row, column) == true) {    
              return false;
            }
          }
        }
      }
      return true;
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