package Climb_Stairs_Problem;

import java.util.Scanner;

/*
 * 爬阶梯问题
 */
public class Main {

    private static int Climb_Stairs_Problem(int n) {
        if(n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i - 2];
        }
        return dp[n];
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int n = Integer.parseInt(input);
        int resolve_num = Climb_Stairs_Problem(n);
        System.out.println(resolve_num);
    }


}
