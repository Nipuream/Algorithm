package Str_EditLen;

import java.util.Scanner;

/*
 * 
 * horse ros
 * 
 * dp[i][j] 表示 m前i个字符 和 n前j个字符最小编辑次数
 * 
 * dp[i][j] = dp[i][j-1] + 1 ==> 增
 * dp[i][j] = dp[i-1][j] + 1 ==> 减
 * dp[i][j] = dp[i-1][j-1] + 1 ==> 改
 * 
 */
public class Main {


    public static int GetMaxEditLen(String m, String n) {

        int[][] dp = new int[m.length() + 1][n.length() + 1];
        
        for(int i = 0; i < m.length() + 1; i++) {
            dp[i][0] = i;
        }

        for(int j = 0; j < n.length() +1; j++) {
            dp[0][j] = j;
        }

        for(int i = 1; i < m.length() + 1; i++) {
            for(int j = 1; j < n.length() + 1; j++) {
                if(m.charAt(i - 1) != n.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                } else {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }

        return dp[m.length()][n.length()];
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        System.out.println(GetMaxEditLen(input[0], input[1]));
    }
    
}
