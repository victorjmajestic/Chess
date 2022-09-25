/**
 * A class that represents a king piece.
 * @author Victor Majestic
 */

public class KingPiece extends ChessPiece {
  
  /*
   * Determines if the king has moved yet, which is required information for the castle move.
   */
  public boolean moved = false;          
  
  /*
   * Determines if the king is moving in a castle to the left side.
   */
  public boolean castleleft = false;       
  
  /*
   * Determines if the king is moving in a castle to the right side.
   */
  public boolean castleright = false;  
  
  /*
   * A constructor that initializes a king piece.
   * @param label the label of the piece.
   * @param side the side the piece belongs to.
   */
  public KingPiece(String label, Side side) {
    super("K", side);
  }
  
  /**
   * Determines the legality of a move that does not capture.
   * The legality of a king is if it moves one spot in any direction.
   * Alternatively, the king can castle if there is a rook in the corner that the king moves to, and neither the king nor the rook have moved.
   * In addition, no square in between the king and where it moves to can be threatened.
   * castleleft and castleright are swapped between true or false based on what the desired move is.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalNonCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == false) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() || toRow == piece.getRow() && toColumn == piece.getColumn() + 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() || toRow == piece.getRow() && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() + 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() - 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 1) {
        castleleft = false;
        castleright = false;
        return true;
      }
    }
    if (toColumn == 0 && toRow == piece.getRow()) {
      if (moved = false && toColumn < piece.getColumn() && super.getChessBoard().hasPiece(toRow, 0) && super.getChessBoard().hasPiece(toRow, toColumn - 2) == false) {
        for (int i = 0; i <= toRow; i = i + 1) {
          if (super.getChessBoard().squareThreatened(toRow, toColumn, super.getChessBoard().getPiece(i, toColumn)) || super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
          castleleft = true;
          return true;
        }
      }
    }
    if (toColumn == super.getChessBoard().numColumns() && toRow == piece.getRow()) {
      if (moved = false && toColumn < piece.getColumn() && super.getChessBoard().hasPiece(toRow, 0) && super.getChessBoard().hasPiece(toRow, toColumn + 2) == false) {
        for (int i = toRow; i <= super.getChessBoard().numColumns(); i = i + 1) {
          if (super.getChessBoard().squareThreatened(toRow, toColumn, super.getChessBoard().getPiece(i, toColumn)) || super.getChessBoard().hasPiece(toRow, toColumn) == true) {
            return false;
          }
          castleright = true;
          return true;
        }
      }
    }
    castleleft = false;
    castleright = false;
    return false;
  }
  
  /**
   * Determines the legality of a king move, except it captures.
   * A king cannot capture a piece if it castles.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == true) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() || toRow == piece.getRow() && toColumn == piece.getColumn() + 1
          || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() || toRow == piece.getRow() && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() + 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() - 1
          || toRow == piece.getRow() + 1 && toColumn == piece.getColumn() - 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 1) {
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
   * Castles if the desired move is a castle. This will remove the rook from the original spot and place it in the empty spot between the king's original and desired spot.
   * Parameter piece refers to the piece, toRow refers to the row the piece moves to, and toColumn refers to the column the piece moves to. */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (legalPieceToPlay(piece, toRow, toColumn) == true && castleleft == false && castleright == false) {
      makeMove(piece, toRow, toColumn);
      moved = true;
      return true;
    }
    if (legalPieceToPlay(piece, toRow, toColumn) == true) {
      makeMove(piece, toRow, toColumn);
      if (castleleft == true) {
        getChessBoard().removePiece(piece, toRow, 0);
        ChessPiece rook = new RookPiece("R", super.getSide());
        getChessBoard().addPiece(rook, toRow, toColumn - 1);
      }
      if (castleright == true) {
        getChessBoard().removePiece(piece, toRow, super.getChessBoard().numColumns());
        ChessPiece rook = new RookPiece("R", super.getSide());
        getChessBoard().addPiece(rook, toRow, toColumn + 1);
      }
      moved = true;
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