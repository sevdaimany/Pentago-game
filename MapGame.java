import java.util.ArrayList;

public class MapGame {

    public void printMap(int arr[][]) {
        ArrayList<String> sample = new ArrayList<String>();
        sample.add(0, "______");
        sample.add(1, "   b  ");
        sample.add(2, "   w  ");
        sample.add(3, "      ");
        sample.add(4, "\t\t\t\t\t\t\t\t\t\t   ");
        sample.add(5, "   0  ");

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

    public boolean select(Object player, Game game) {
        Player newPlayer = (Player) player;
        int[][] arr;
        Point point = newPlayer.choose();
        if (check(point) && check(point, game)) {
            game.addMarble(point, newPlayer);
            arr = game.twist(point, game);
            copyArr(arr, game, point);
            return true;
        } else
            return false;
    }

    public boolean check(Point point, Game game) {
        int[][] arr = game.getArr();
        if (arr[point.getX()][point.getY()] == 0)
            return true;
        else
            return false;

    }

    public boolean check(Point point) {
        if (point.getX() >= 0 && point.getX() < 6 && point.getY() >= 0 && point.getY() < 6)
            return true;
        else
            return false;

    }

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
}