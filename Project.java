import java.util.Scanner;

public class Project {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Game game = new Game();
        clearScreen();
        game.printMenu();

        while (true) {
            game = new Game();

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();

            if (choose == 1) {

                game.game(game, 1);

            } else if (choose == 2) {
                game.game(game, 2);
            } else if (choose == 3) {
                System.out.println("End Game.");
                break;
            }
        }
    }
}