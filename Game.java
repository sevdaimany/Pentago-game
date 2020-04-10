
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

    public void addMarble(int x, int y, int player) {
        arr[x][y] = player;
    }

    public int[][] twist(Point point, Game game) {
        int[][] arr = new int[3][3];
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
        if (point.getTurn().equals("s")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    arr[j][2 - i] = game.getArr()[i + (3 * k)][j + (3 * l)];
            }
        } else if (point.getTurn().equals("p")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++)
                    arr[2 - j][i] = game.getArr()[i + (3 * k)][j + (3 * l)];
            }
        }
        return arr;
    }

    public void game(Game game, int choose) {
        Player player = null;
        Player player2 = null;
        if (choose == 1) {
             player = new Player();
             player.setPlayer(1);
             player2 = new Player();
             player2.setPlayer(-1);
        }
        else if(choose == 2){
            player = new Player();
            player.setPlayer(1);
            player2 = new Ai();
            player2.setPlayer(-1);
        }
        MapGame map = new MapGame();

        while (true) {
            if (checkEqual(game)) {
                System.out.println("Equal");
                return;
            } else {
                map.printMap(game.getArr());
                boolean EndOfGame = map.select(player, game);
                if (EndOfGame == false) {
                    printMenu();
                    break;
                }

                map.printMap(game.getArr());
                EndOfGame = map.select(player2, game);
                if (EndOfGame == false) {
                    printMenu();
                    break;
                }

            }

        }

    }

    private boolean checkEqual(Game game) {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (game.getArr()[i][j] == 0)
                    return false;
            }
        }
        return true;
    }

    public int winner(Game game) {
        MapGame map = new MapGame();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (game.getArr()[i][j] != 0) {
                    int turn = game.getArr()[i][j];
                    for (int k = -1; k < 2; k++) {
                        for (int l = -1; l < 2; l++) {
                            if (k == 0 && l == 0)
                                break;
                            int count2 = 1;
                            for (int count = 1; count < 5; count++) {
                                if (map.check(i + k * (count), j + l * (count))) {
                                    if (game.getArr()[i + k * (count)][j + l * (count)] == turn) {
                                        count2++;
                                    }
                                } else
                                    break;

                            }
                            if (count2 == 5) {
                                return turn;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public void printMenu() {
        System.out.println("\t\t\t\t\t\t\t\t\t\t   1)Play with friend\n\t\t\t\t\t\t\t\t\t\t   2)Play online\n\t\t\t\t\t\t\t\t\t\t   3)End game");
    }

}