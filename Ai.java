import java.util.Random;

public class Ai extends Player {

    public Point choose(Game game) {
        MapGame map = new MapGame();

        Random rand = new Random();

        clearScreen();
        map.printMap(game.getArr());

        System.out.println("White turn:");

      

        int x = rand.nextInt(6);
        int y = rand.nextInt(6);

        if (map.check(x, y) && map.check(x, y, game)) {
            game.addMarble(x, y, -1);
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

                x = rand.nextInt(6);
                y = rand.nextInt(6);

                if (map.check(x, y) && map.check(x, y, game)) {
                    game.addMarble(x, y, -1);
                    c = false;
                }
            }
        }

        clearScreen();
        map.printMap(game.getArr());

        int numBlock = rand.nextInt(4) + 1;
        clearScreen();
        map.printMap(game.getArr());

        
        int random = rand.nextInt(2);
        String turn ;
        if(random == 0)
        turn = "s";
        else
        turn = "p";
      
        Point point = new Point(x, y, numBlock, turn);
        return point;

    }
}