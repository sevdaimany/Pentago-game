
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

    public void addMarble(Point point, Player player) {
        arr[point.getX()][point.getY()] = player.getPlayer();
    }

    public int[][] twist(Point point, Game game) {
        int[][] arr = new int[3][3];
        int turn = point.getNumBlock();
        int k = 0;
        int l = 0;
        if (turn == 1) {
            k = 0;
            l = 0;
        }
        else if(turn == 2){
            k = 0;
            l = 1;
        }
        else if(turn == 3){
            k = 1;
            l = 0;
        }
        else if(turn == 4){
            k = 1;
            l = 1;
        }
        if (point.getTurn().equals("s")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    arr[j][2 - i] = game.getArr()[i + (3 * k)][j + (3 * l)];
            }
        } else if (point.getTurn().equals("p")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    arr[2 - j][i] = game.getArr()[i + (3* k)][j + (3* l)];
            }
        }
        return arr;
    }
}