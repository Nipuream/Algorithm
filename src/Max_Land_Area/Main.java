package Max_Land_Area;

import java.util.*;

class Main {

    private static boolean isArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length && 0 <= c && c <grid[0].length;
    }

    private static int area(int[][] grid, int r, int c) {

        if(!isArea(grid, r, c)) {
            return 0;
        }

        if(grid[r][c] != 1) {
            return 0;
        }

        grid[r][c] = 2;
        
        return 1 + area(grid, r - 1, c) + 
            area(grid, r + 1, c) +
            area(grid, r, c - 1) + 
            area(grid, r, c + 1);
    }

    private static int Number_Of_Mountains(int[][] mountains) {
        int maxArea = 0;
        for(int r = 0; r < mountains.length; r++) {
            for(int c = 0; c <mountains[0].length; c++) {
                if(mountains[r][c] == 1) {
                    maxArea = Math.max(maxArea, area(mountains, r, c));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(";");
        int[][] grid = null;
        for(int i = 0; i < input.length; i++) {
            int[] temp = Arrays.stream(input[i].replaceAll("\\[|\\]", "").split(",")).mapToInt(Integer::parseInt).toArray();
            if(grid == null) {
                grid = new int[input.length][temp.length];
            }
            grid[i] = temp;
        }

        int number = Number_Of_Mountains(grid);
        System.out.println(number);
    }
}