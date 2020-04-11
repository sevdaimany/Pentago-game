import java.util.ArrayList;

/**
 * MapGame class represent a map in game
 * 
 * @author sevda imany
 * @version 0.0
 */
public class MapGame {

    
    /** 
     * this method prints map in game
     * @param arr[][]
     */
    public void printMap(int arr[][]) {
        ArrayList<String> sample = new ArrayList<String>();
        sample.add(0, "______");
        sample.add(1, "   b  ");
        sample.add(2, "   w  ");
        sample.add(3, "      ");
        sample.add(4, "\t\t\t\t\t\t\t\t\t\t   ");
        sample.add(5, "   0  ");

        System.out.println(sample.get(4) + "    0     1     2         3     4     5");
        for (int i = 0; i < 6; i++) {
            if (i == 0)
                System.out.print(sample.get(4) + " " + sample.get(0));
            else if (i == 2) {
                System.out.print(sample.get(0) + "_____");
            } else if (i == 5) {
                System.out.print("_____");
            } else {
                System.out.print(sample.get(0));

            }
        }
        System.out.print("\n");
        for (int i = 1; i < 16; i++) {
            int m = 0;
            if (i == 2)
                m = 0;
            else if (i == 4)
                m = 1;
            else if (i == 6)
                m = 2;
            else if (i == 10)
                m = 3;
            else if (i == 12)
                m = 4;
            else if (i == 14)
                m = 5;
            if(i == 2 || i == 4 || i == 6 || i == 10 || i == 12 || i == 14){
                System.out.print("\t\t\t\t\t\t\t\t\t\t "+m+ " |");
            }
            else
            System.out.print(sample.get(4) + "|");
            if (i == 7) {
                for (int j = 0; j < 6; j++) {
                    if (j == 2)
                        System.out.print(sample.get(0) + "|  |");
                    else if (j == 5)
                        System.out.print(sample.get(0) + "|");
                    else {
                        System.out.print(sample.get(0));
                    }
                }
            } else if (i == 8) {
                for (int j = 0; j < 6; j++) {
                    if (j == 2)
                        System.out.print(sample.get(0) + "    ");
                    else if (j == 5) {
                        System.out.print(sample.get(0) + "|");
                    } else {
                        System.out.print(sample.get(0));
                    }
                }
            } else if (i == 15) {
                for (int j = 0; j < 7; j++) {
                    if (j == 6)
                        System.out.print("____" + "|");
                    else
                        System.out.print(sample.get(0));
                }
            }

            else if (i % 2 == 1) {
                System.out.print(sample.get(3) + sample.get(3) + sample.get(3) + "|  |" + sample.get(3) + sample.get(3)
                        + sample.get(3) + "|");
            } else if (i % 2 == 0) {
                int k = 0;
                if (i == 2)
                    k = 0;
                else if (i == 4)
                    k = 1;
                else if (i == 6)
                    k = 2;
                else if (i == 10)
                    k = 3;
                else if (i == 12)
                    k = 4;
                else if (i == 14)
                    k = 5;

                for (int j = 0; j < 6; j++) {
                    if (j == 2) {
                        if (arr[k][j] == 1)
                            System.out.print(sample.get(1) + "|  |");
                        else if (arr[k][j] == -1)
                            System.out.print(sample.get(2) + "|  |");
                        else {
                            System.out.print(sample.get(5) + "|  |");
                        }
                    } else {
                        if (arr[k][j] == 1)
                            System.out.print(sample.get(1));
                        else if (arr[k][j] == -1)
                            System.out.print(sample.get(2));
                        else
                            System.out.print(sample.get(5));

                    }
                }
                System.out.println("|");
                System.out.print(sample.get(4) + "|");
                System.out.print(sample.get(3) + sample.get(3) + sample.get(3) + "|  |" + sample.get(3) + sample.get(3)
                        + sample.get(3) + "|");
            }
            System.out.print("\n");
        }
    }

    
    /** 
     * this method play game with given player
     * @param player
     * @param game
     * @return {@code false} if player won the game otherwise {@code true} 
     */
    public boolean select(Object player, Game game) {
        Player newPlayer = (Player) player;
        int[][] arr;
        Point point = newPlayer.choose(game);
        if (point.getX() == -1) {
            return false;
        } else {
            arr = game.twist(point, game);
            copyArr(arr, game, point);
            int winner = game.winner(game);
            if (winner != 0) {
                newPlayer.clearScreen();
                printMap(game.getArr());
                printWinner(winner);
                return false;

            }

            return true;
        }
    }

    
    /** 
     * thid method check if the given x and y are empty place in map or not 
     * @param x
     * @param y
     * @param game
     * @return {@code true} if the map is empty in given coordinate otherwise {@code false} 
     */
    public boolean check(int x, int y, Game game) {
        int[][] arr = game.getArr();
        if (arr[x][y] == 0)
            return true;
        else
            return false;

    }

    
    /** 
     * this method check that a given coordinate is in the map or not
     * @param x
     * @param y
     * @return {@code true} if the given coordinate is acceptable otherwise {@code false}
     */
    public boolean check(int x, int y) {
        if (x >= 0 && x < 6 && y >= 0 && y < 6)
            return true;
        else
            return false;

    }

    
    /** 
     * this method copy given arr to the main arr in game
     * @param arr
     * @param game
     * @param point
     */
    private void copyArr(int[][] arr, Game game, Point point) {
        int turn = point.getNumBlock();
        int k = 0;
        int l = 0;
        if (turn == 1) {
            k = 0;
            l = 0;
        } else if (turn == 2) {
            k = 0;
            l = 1;
        } else if (turn == 3) {
            k = 1;
            l = 0;
        } else if (turn == 4) {
            k = 1;
            l = 1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                game.getArr()[i + (3 * k)][j + (3 * l)] = arr[i][j];
            }
        }
    }

    
    /** 
     * this method print winner
     * @param turn
     */
    public void printWinner(int turn) {
        if (turn == 1) {

            System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Black win.\n\n");
        } else if (turn == -1) {
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t   White win.\n\n");
        }
        else if(turn == 2){
            System.out.println("Equal");
        }
    }

}