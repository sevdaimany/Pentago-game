
public class Point {
  private final int x;
  private final int y;
  private int numBlock;
  private String turn;

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


}