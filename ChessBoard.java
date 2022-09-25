/**
 * A class to represent a chess board that does not rely on Swing or FX.
 * @author Victor Majestic
 */

public interface ChessBoard {

  /**
   * Returns the rules of the game.
   * @return the rules of the game.
   */
  public ChessGame getGameRules();
  
  /**
   * Returns the number of rows on the board.
   */
  public int numRows();
  
  /**
   * Returns the number of columns of the board.
   */
  public int numColumns();
  
  /**
   * Adds a piece to the specified position.
   * @param piece the piece to be added.
   * @param row the row for the piece to be added.
   * @param column the column for the piece to be added.
   */
  public void addPiece(ChessPiece piece, int row, int column);
  
  /**
   * Removes a piece from the specified position.
   * @param piece the piece to be added.
   * @param row the row for the piece to be added.
   * @param column the column for the piece to be added.
   * @return the piece that was removed.
   */
  public ChessPiece removePiece(ChessPiece piece, int row, int column);
  
  /**
   *  Returns true if there is a piece at a specific location of the board.
   *  @param row   the row to examine
   *  @param col   the column to examine
   *  @return   true if there is a piece a this row and column and false
   *            if the square is empty
   */
  public boolean hasPiece(int row, int col);
  
  /**
   *  Returns the chess piece at a specific location on the board.
   *  @param row   the row for the piece
   *  @param col   the column for the piece
   *  @return      the piece at the row and column or null if there is no piece there.
   */
  public ChessPiece getPiece(int row, int col);
  
  /**
   * Returns true if the square contains a piece that can be captured in the next move.
   * @return true if the square contains a piece that can be captured in the next move.
   */
  public boolean squareThreatened(int row, int column, ChessPiece piece);  
}