package Longest_Sub_List;

import java.util.Scanner;

/**
 * case1:
 * abcfbcab
 * bdcabdfcab
 * 
 * case2:
 * ABCBDAB
 * BDCAB
 */
public class Main {
    
    private static int Find_Longest_Sub_List(String input1, String input2) {

        int m = input1.length(), n = input2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= input1.length(); i++) {
            for(int j = 1; j <= input2.length(); j++) {
                if(input1.charAt(i-1) == input2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine().trim();
        String input2 = scanner.nextLine().trim();
        int result = Find_Longest_Sub_List(input1, input2);
        System.out.println(result);
    }

}
