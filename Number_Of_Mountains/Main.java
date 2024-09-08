package Number_Of_Mountains;

import java.util.*;

/**
 * 大山的数量
 * dfs 遍历网格
 */
public class Main {

    private static boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c <grid[0].length;
    }

    private static void area(int[][] grid, int r, int c) {

        if(!isArea(grid, r, c)) {
            return ;
        }

        if(grid[r][c] != 1) {
            return ;
        }

        grid[r][c] = 2;
        area(grid, r - 1, c);
        area(grid, r + 1, c);
        area(grid, r, c - 1);
        area(grid, r, c + 1);
    }


    private static int Number_Of_Mountains(int[][] mountains) {

        int number = 0;
        for(int r = 0; r < mountains.length; r++) {
            for(int c = 0; c <mountains[0].length; c++) {
                if(mountains[r][c] == 1) {
                    area(mountains, r, c);
                    number ++;
                }
            }
        }
        return number;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] line1 = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int column = line1[0];
        int row = line1[1];

        int[][] grid = new int[column][row];
        for(int i = 0; i < column; i++) {
            grid[i] = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int number = Number_Of_Mountains(grid);
        System.out.println(number);
    }
    
}
