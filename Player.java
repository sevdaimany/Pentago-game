import java.util.Scanner;

public class Player {
    private int player;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Point choose() {
        if (player == 1)
            System.out.println("Black turn:");
        else
            System.out.println("White turn:");

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a coordinate: (x, y)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter a block number to twist: ");
        int numBlock = sc.nextInt();
        sc.nextLine();
        System.out.println("Please enter 's' to twist clockwise and 'p' for counter clockwise: ");
        String turn = sc.next();
        sc.nextLine();

        Point point = new Point(x, y, numBlock, turn);
        return point;

    }

}