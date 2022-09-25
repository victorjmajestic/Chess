import javax.swing.*;

/**
 * A class that represents a pawn piece.
 * @author Victor Majestic
 */

public class PawnPiece extends ChessPiece {
  
  /*
   * The current turn of the pawn.
   */
  int turn = 1;           
  
  /*
   * A constructor that initializes a ___ piece.
   * @param label the label of the piece.
   * @param side the side the piece belongs to.
   */
  public PawnPiece(String label, Side side) {
    super("P", side);
  }
  
  /**
   * Determines the legality of a move that does not capture.
   * The legality of a pawn is if it moves forward one space, or two spaces if it is the first move.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalNonCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == false && super.getSide() == Side.SOUTH) {
      if (toRow == piece.getRow() - 1 && toColumn == piece.getColumn() || turn == 1 && toRow == piece.getRow() - 2 && toColumn == piece.getColumn()) {
        return true;
      }
    }
    if (super.getChessBoard().hasPiece(toRow, toColumn) == false && super.getSide() == Side.NORTH) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() || turn == 1 && toRow == piece.getRow() + 2 && toColumn == piece.getColumn()) {
        return true;
      }
    }
    return false;
  }
  
  /**
   * Determines the legality of a pawn move, except it captures.
   * A pawn can only capture one spot diagonally.
   * @param toRow the row the piece is to move.
   * @param toColumn the column the piece is to move.
   * @return true if the move can be made legally, false if it cannot.
   */
  public boolean isLegalCaptureMove(ChessPiece piece, int toRow, int toColumn) {
    if (super.getChessBoard().hasPiece(toRow, toColumn) == true && super.getSide() == Side.SOUTH) {
      if (toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() - 1) {
        return true;
      }
    }
    if (super.getChessBoard().hasPiece(toRow, toColumn) == true && super.getSide() == Side.NORTH) {
      if (toRow == piece.getRow() + 1 && toColumn == piece.getColumn() - 1 || toRow == piece.getRow() - 1 && toColumn == piece.getColumn() + 1) {
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
   * If the piece reaches the other side, a dialog box will pop up that allows you to upgrade the piece.
   * Typing the label into the dialog box will change the pawn into the desired piece.
   * Parameter piece refers to the piece, toRow refers to the row the piece moves to, and toColumn refers to the column the piece moves to. */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (legalPieceToPlay(piece, toRow, toColumn) == true) {
      makeMove(piece, toRow, toColumn);
      turn = turn + 1;
      if (super.getSide() == Side.SOUTH && toRow == 0 || super.getSide() == Side.NORTH && toRow == super.getChessBoard().numRows()) {
        String s = JOptionPane.showInputDialog("Select piece to upgrade to! (Q, R, B, N)");
        getChessBoard().removePiece(piece, toRow, toColumn);
        if (s.equals("Q")) {
          ChessPiece queen = new QueenPiece("Q", super.getSide());
          getChessBoard().addPiece(queen, toRow, toColumn);
        }
        if (s.equals("R")) {
          ChessPiece rook = new RookPiece("R", super.getSide());
          getChessBoard().addPiece(rook, toRow, toColumn);
        }
        if (s.equals("B")) {
          ChessPiece bishop = new BishopPiece("B", super.getSide());
          getChessBoard().addPiece(bishop, toRow, toColumn);
        }
        if (s.equals("N")) {
          ChessPiece knight = new KnightPiece("N", super.getSide());
          getChessBoard().addPiece(knight, toRow, toColumn);
        }
      }
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