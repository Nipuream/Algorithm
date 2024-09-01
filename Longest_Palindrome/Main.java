package Longest_Palindrome;

import java.util.Scanner;


public class Main {

    public static String GetLongestPalindrome(String input) {

        int length = input.length();
        if(length < 2) return input;

        int maxLen = 0;
        int start = 0;
        boolean[][] dp = new boolean[length][length];
        for(int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        for(int L = 2; L <= length; L++) {
            for(int i = 0; i < length; i++) {
                int j = i + L - 1;

                if(j >= length) break;
                if(input.charAt(i) != input.charAt(j)) {
                   dp[i][j] = false;
                } else {
                    if(j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return input.substring(start, start + maxLen);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toLowerCase();
        String last = GetLongestPalindrome(input);
        System.out.println(last);
    }

}
