import java.util.Scanner;

public class Project {
    public static void main(String[] args) {
        Game game = new Game();
        game.game(game);

        while (true) {
            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();

            if (choose == 1) {
                game = new Game();
                game.game(game);
            } else if (choose == 2) {
                System.out.println("End Game.");
                break;
            }
        }
    }
}