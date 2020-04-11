/**
 * Point class represent a input in game.
 * it holds a map coordinate , a block number to twist and a turn.
 * 
 * @author sevda imany
 * @version 0.0 
 */
public class Point {
  private final int x;
  private final int y;
  private final int numBlock;
  //"s" to turn clockwise and "p" to turn counter clockwise
  private final String turn;

  /**
   * to create a new point with given x, y, block number and turn
   * @param x
   * @param y
   * @param numBlock
   * @param turn "s" to turn clockwise and "p" to turn counter clockwise
   */
  public Point(int x, int y, int numBlock, String turn) {
      this.x = x;
      this.y = y;
      this.numBlock = numBlock;
      this.turn = turn;
  }

  
  /** 
   * get x of maps coordinate
   * @return x
   */
  public int getX() {
      return x;
  }

  
  /** 
   * get y of maps coordinate
   * @return  y
   */
  public int getY() {
      return y;
  }

  
  /** 
   * get a block number
   * @return block number
   */
  public int getNumBlock() {
      return numBlock;
  }

  
  /** 
   * get turn to twist clockwise or counter clock wise
   * @return String
   */
  public String getTurn() {
      return turn;
  }


}