
public class Game {
    int[][] arr = new int[6][6];

    public Game() {

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = 0;
            }
        }

    }
    

   

    public int[][] getArr() {
        return arr;
    }

  
    public void addMarble(Point point , Player player){
       arr[point.getX()][point.getY()]= player.getPlayer();
    }

}