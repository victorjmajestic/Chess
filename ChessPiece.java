/**
 * A class that represents a chess piece.
 * @author Victor Majestic
 */

public abstract class ChessPiece implements ChessGame {
  
  /* Indicates the type of piece. */
  private String label;     
  
  /* Indicates the side the piece is owned by. */
  private Side side;                        
  
  /* The row of the piece. */
  private int row;         
  
  /* The column of the piece. */
  private int column;      
  
  /* The board the piece is on. */
  private ChessBoard board;   
  
  /* The display of the board the piece is on. */
  private SwingChessBoardDisplay boardDisplay;
  
  /* The rules of the game. */
  private ChessGame gameRules;    
  
  /**
   * Initializes a piece.
   * @param label the label of the piece.
   * @param side the side of the piece.
   */
  public ChessPiece(String label, Side side) {
    this.label = label;
    this.side = side;
    this.row = row;
    this.column = column;
    this.board = board;
    this.boardDisplay = boardDisplay;
    this.gameRules = gameRules;
  }

  /**
   * Returns the board display.
   * @return the board display.
   */
  public SwingChessBoardDisplay getChessBoardDisplay() {
    return boardDisplay;
  }
  
  /**
   * Returns the rules of the game.
   * @return the rules of the game.
   */
  public ChessGame getGameRules() {
    return gameRules;
  }
  
  /**
   * Returns the side of the piece.
   */
  public ChessGame.Side getSide() {
    return side;
  }
  
  /**
   * Returns the label of the piece.
   */
  public String getLabel() {
    return label;
  }
  
  /**
   * Returns the icon of the piece.
   * @return the icon of the piece, null for the moment.
   */
  public Object getIcon() {
    return null;
  }
 
  /**
   * Changes the location of a piece.
   * @row the row the piece is moved to.
   * @column the column the piece is moved to.
   */
  public void setLocation(int row, int column) {
    this.row = row;
    this.column = column;
  }

  /**
   * Returns the game board.
   * @return the game board.
   */
  public ChessBoard getChessBoard() {
    return board;
  }
  
  /**
   * Returns the row of the piece.
   * @return the row of the piece.
   */
  public int getRow() {
    return row;
  }
  
  /**
   * Returns the column of the piece.
   * @return the column of the piece.
   */
  public int getColumn() {
    return column;
  }
  
  /* Checks if a non-capture move is legal.
   * @param toRow the intended row the piece is moved to.
   * @param toColumn the intended column the piece is moved to.
   * @return true if the move is legal, false if it is not.
   */
  public boolean isLegalNonCaptureMove(int toRow, int toColumn) {
    return true;
  }
  
  /* Checks if a capture move is legal.
   * @param toRow the intended row the piece is moved to.
   * @param toColumn the intended column the piece is moved to.
   * @return true if the move is legal, false if it is not.
   */
  public boolean isLegalCaptureMove(int toRow, int toColumn) {
    return true;
  }
  
  /* Checks if a move is legal.
   * @param toRow the intended row the piece is moved to.
   * @param toColumn the intended column the piece is moved to.
   * @return true if the move is legal, false if it is not.
   */
  public boolean legalPieceToPlay(int toRow, int toColumn) {
    if (isLegalNonCaptureMove(toRow, toColumn) == true || isLegalCaptureMove(toRow, toColumn) == true) {
      return true;
    }
    return false;
  }
  
  /**
   * Makes the move.
   * First, it checks if the piece can legally be moved.
   * Next, it checks if it is a capture or non-capture move.
   * If it is a non-capture move, the piece will move to the spot and return true.
   * If it is a capture move, the opponent's piece is removed.
   * @param piece the piece to be moved.
   * @param toRow the row the piece moves to.
   * @param toColumn the column the piece moves to.
   * @return true if the move was made successfully, false if it was not.
   */
  public boolean makeMove(ChessPiece piece, int toRow, int toColumn) {
    if (legalPieceToPlay(piece, toRow, toColumn) == true) {
      if (getChessBoard().hasPiece(toRow, toColumn) == false) {
        this.row = toRow;
        this.column = toColumn;
        return true;
      }
      if (getChessBoard().hasPiece(toRow, toColumn) == true) {
        getChessBoard().removePiece(piece, toRow, toColumn);
        this.row = toRow;
        this.column = toColumn;
        return true;
      }
    }
    return false;
  }
}