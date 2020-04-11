import java.util.Scanner;

/**
 * player class represent a player in class
 * it holds an int number that is 1 for black player and -1 for white
 * 
 * @author sevda imany
 * @version 0.0
 */
public class Player {
    //1 for black player and -1 for white
    private int player;

   
    
    /** 
     * @return int
     */
    public int getPlayer() {
        return player;
    }

    
    /** 
     * @param player
     */
    public void setPlayer(int player) {
        this.player = player;
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    
    /**
     * this method get a coordinate, block number and turn from user
     * check if the coordinate is acceptable
     * @param game
     * @return Point 
     */
    public Point choose(Game game) {
        MapGame map = new MapGame();

        clearScreen();
        map.printMap(game.getArr());

        if (player == 1)
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Black turn:");
        else
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t   White turn:");

        Scanner sc = new Scanner(System.in);
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Please enter a coordinate: (x, y)");
        String input = sc.nextLine();
        String[] inputs = input.split(", ");
        String input1 = inputs[0].substring(1, inputs[0].length());
        String input2 = inputs[1].substring(0, inputs[1].length() - 1);

        int x = Integer.parseInt(input1);
        int y = Integer.parseInt(input2);

        if (map.check(x, y) && map.check(x, y, game)) {
            game.addMarble(x, y, player);
            int winner = game.winner(game);

            if (winner != 0) {
                clearScreen();
                map.printMap(game.getArr());
                Point point = new Point(-1, -1, -1, "s");
                map.printWinner(winner);
                return point;
            }
          
        } else {
            boolean c = true;
            while (c) {
                clearScreen();
                map.printMap(game.getArr());

                System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Wrong input . Please enter another coordinate: (x, y)");
                input = sc.nextLine();
                inputs = input.split(", ");
                input1 = inputs[0].substring(1, inputs[0].length());
                input2 = inputs[1].substring(0, inputs[1].length() - 1);

                x = Integer.parseInt(input1);
                y = Integer.parseInt(input2);

                if (map.check(x, y) && map.check(x, y, game)) {
                    game.addMarble(x, y, player);
                    c = false;
                }
            }
        }

        clearScreen();
        map.printMap(game.getArr());

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Please enter a block number to twist: ");
        int numBlock = sc.nextInt();
        sc.nextLine();
        clearScreen();
        map.printMap(game.getArr());

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t   Please enter 's' to twist clockwise and 'p' for counter clockwise: ");
        String turn = sc.next();
        sc.nextLine();

        Point point = new Point(x, y, numBlock, turn);
        return point;

    }

}