
public class Point {
  private final int x;
  private final int y;
  private final int numBlock;
  private final String turn;

  public Point(int x, int y, int numBlock, String turn) {
      this.x = x;
      this.y = y;
      this.numBlock = numBlock;
      this.turn = turn;
  }

  public int getX() {
      return x;
  }

  public int getY() {
      return y;
  }

  public int getNumBlock() {
      return numBlock;
  }

  public String getTurn() {
      return turn;
  }


}