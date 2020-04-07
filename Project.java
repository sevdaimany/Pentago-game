
public class Project{
    public static void main(String[] args){
        int [][] arr = new int[6][6];
        for(int i = 0 ; i < 6 ; i++){
            for(int j = 0 ; j < 6 ; j++){
                arr[i][j] = 0;
            }
        }
        MapGame map = new MapGame();
        map.printMap(arr);
    }
}