import java.util.Scanner;


/**
 * Pentago class represent a pentago game
 * 
 * @author sevda imany
 * @version 0.0
 */
public class Pentago {

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
            else if(choose == 4){
                clearScreen();
                System.out.println("\n\t\t\t\t\t\t\t\t   Pentago:\n");
                System.out.println("\n\t\t\t\t\t\t\t\t   Pentago is a two-player abstract strategy game invented by Tomas Floden in 2004 \n\t\t\t\t\t\t\t\t   This game is also a fast and fun game that is both simple ans sophisticated at\n\t\t\t\t\t\t\t\t   the same time. The object of the game to create a row of five mirable is any\n\t\t\t\t\t\t\t\t   direction but mind twistingpart is that you will also twist one of the four game\n\t\t\t\t\t\t\t\t   blocks as part of your move This causes.The game board to constantly change,\n\t\t\t\t\t\t\t\t   making for a perpetually chanllenging game experience both for a perpetaully\n\t\t\t\t\t\t\t\t   challenging game experience, both for beginners and master alike.\n\n");
                sc.nextLine();
                sc.nextLine();
                clearScreen();
                game.printMenu();
               }
        }
    }
}