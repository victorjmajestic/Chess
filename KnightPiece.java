/**
 * A class that represents a knight piece.
 * @author Victor Majestic
 */

public class KnightPiece extends ChessPiece {
  
  /*
   * A constructor that initializes a knight piece.
   * @param label the label of the piece.
   * @param side the side the piece belongs to.
   */
  public KnightPiece(String label, Side side) {
    super("N", side);
  }
  
  /**
   * Determines the legality of a move that does not capture.
   * The legality of a knight is if it moves in an L, vertically one spot and horizonally two spots, or vice versa, in any direction.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalNonCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == false) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() + 2 || toRow == piece.getRow() + 2 && toColumn == piece.getColumn() + 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() - 2 || toRow == piece.getRow() - 2 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() - 2 || toRow == piece.getRow() + 2 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 2 || toRow == piece.getRow() - 2 && toColumn == piece.getColumn() + 1) {
      return true;
      }
    }
    return false;
  }
  
  /**
   * Determines the legality of a knight move, except it captures.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() + 2 || toRow == piece.getRow() + 2 && toColumn == piece.getColumn() + 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() - 2 || toRow == piece.getRow() - 2 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() - 2 || toRow == piece.getRow() + 2 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 2 || toRow == piece.getRow() - 2 && toColumn == piece.getColumn() + 1) {
      return true;
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