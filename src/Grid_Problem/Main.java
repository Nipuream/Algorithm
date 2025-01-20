package Grid_Problem;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    private static int Unique_Paths(int m, int n) {

        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }

        for(int i = 0; i < n; i++) {
            grid[0][i] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mn = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int path = Unique_Paths(mn[0], mn[1]);
        System.out.println(path);
    }
}
