/**
 * A class that finalizes certain game mechanics for Indo-European chess.
 * @author Victor Majestic
 */

public class EuropeanChess implements ChessGame {
 
  /* An address to represent the row. */
  private final int row = 7;              
  
  /* An address to represent the column. */
  private final int column = 7;              
  
  /* An address to represent the side who currently has a turn. */
  private Side side;                         
  
  /* An address to represent the player who has a turn. Assume SOUTH side is the white pieces, which always move first. */
  private Side turn = Side.SOUTH;      
  
  /*
   * Returns the side.
   * @return the side.
   */
  public ChessGame.Side getSide() {
    return side;
  }
  
  /*
   * Returns the number of rows.
   * @return the number of rows.
   */
  public int getNumRows() {
    return row;
  }

  /*
   * Returns the number of columns.
   * @return the number of columns.
   */
  public int getNumColumns() {
    return column;
  }
  
  /*
   * Determines if the piece can be legally played.
   * In this class, the method checks if it is the particular side's turn that the piece corresponds to.
   * @param piece the piece.
   * @param toRow the row that the piece is intended to move.
   * @param toColumn the column that the piece is intended to move.
   */
  public boolean legalPieceToPlay(ChessPiece piece, int toRow, int toColumn) {
    if (piece == null) {
      return false;
    }
    if (turn == Side.SOUTH && getSide() == Side.NORTH) {
      return false;
    }
    if (turn == Side.NORTH && getSide() == Side.SOUTH) {
      return false;
    }
    return true;
  }
 
  /*
   * Checks to make sure the piece can be legally played and moves the piece.
   * After, the turn is switched.
   * @param piece the piece.
   * @param toRow the row that the piece is moved.
   * @param toColumn the column that the piece is moved.
   */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (legalPieceToPlay(piece, toRow, toColumn) == true) {
      makeMove(piece, toRow, toColumn);
      if (turn == Side.NORTH) {
        turn = Side.SOUTH;
      }
      else if (turn == Side.SOUTH) {
        turn = Side.NORTH;
      }
      return true;
    }
    return false;
  }
  
  /**
   * Places the pieces in their appropriate spots, and starts the game.
   * @param board the chessboard that the game is played on.
   */
  public void startGame(ChessBoard board) {
    ChessPiece rook1n = new RookPiece("R", Side.NORTH);
    ChessPiece knight1n = new KnightPiece("N", Side.NORTH);
    ChessPiece bishop1n = new BishopPiece("B", Side.NORTH);
    ChessPiece queenn = new QueenPiece("Q", Side.NORTH);
    ChessPiece kingn = new KingPiece("K", Side.NORTH);
    ChessPiece bishop2n = new BishopPiece("B", Side.NORTH);
    ChessPiece knight2n = new KnightPiece("N", Side.NORTH);
    ChessPiece rook2n = new RookPiece("R", Side.NORTH);
    ChessPiece pawn1n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn2n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn3n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn4n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn5n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn6n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn7n = new PawnPiece("P", Side.NORTH);
    ChessPiece pawn8n = new PawnPiece("P", Side.NORTH);
    ChessPiece rook1s = new RookPiece("R", Side.NORTH);
    ChessPiece knight1s = new KnightPiece("N", Side.SOUTH);
    ChessPiece bishop1s = new BishopPiece("B", Side.SOUTH);
    ChessPiece queens = new QueenPiece("Q", Side.SOUTH);
    ChessPiece kings = new KingPiece("K", Side.SOUTH);
    ChessPiece bishop2s = new BishopPiece("B", Side.SOUTH);
    ChessPiece knight2s = new KnightPiece("N", Side.SOUTH);
    ChessPiece rook2s = new RookPiece("R", Side.SOUTH);
    ChessPiece pawn1s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn2s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn3s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn4s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn5s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn6s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn7s = new PawnPiece("P", Side.SOUTH);
    ChessPiece pawn8s = new PawnPiece("P", Side.SOUTH);
    rook1n.setLocation(0, 0);
    knight1n.setLocation(0, 1);
    bishop1n.setLocation(0, 2);
    queenn.setLocation(0, 3);
    kingn.setLocation(0, 4);
    bishop2n.setLocation(0, 5);
    knight2n.setLocation(0, 6);
    rook2n.setLocation(0, 7);
    pawn1n.setLocation(1, 0);
    pawn2n.setLocation(1, 1);
    pawn3n.setLocation(1, 2);
    pawn4n.setLocation(1, 3);
    pawn5n.setLocation(1, 4);
    pawn6n.setLocation(1, 5);
    pawn7n.setLocation(1, 6);
    pawn8n.setLocation(1, 7);
    pawn1s.setLocation(6, 0);
    pawn2s.setLocation(6, 1);
    pawn3s.setLocation(6, 2);
    pawn4s.setLocation(6, 3);
    pawn5s.setLocation(6, 4);
    pawn6s.setLocation(6, 5);
    pawn7s.setLocation(6, 6);
    pawn8s.setLocation(6, 7);
    rook1s.setLocation(7, 0);
    knight1s.setLocation(7, 1);
    bishop1s.setLocation(7, 2);
    queens.setLocation(7, 3);
    kings.setLocation(7, 4);
    bishop2s.setLocation(7, 5);
    knight2s.setLocation(7, 6);
    rook2s.setLocation(7, 7);
  }
}