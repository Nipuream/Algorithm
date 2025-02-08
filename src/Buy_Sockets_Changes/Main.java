package Buy_Sockets_Changes;

import java.util.Scanner;

/**
 * 买卖股票的最佳时机
 */
public class Main {
    
    /**
     * 暴力解法 时间O(n2) 空间O(1)
     * @param prices
     * @return
     */
    private static int Buy_Sockets_Changes(int[] prices) {

        if(prices == null || prices.length == 0) {
            return 0;
        }
        int max_ans = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j ++) {
                if(prices[j] - prices[i] > max_ans)
                    max_ans = prices[j] - prices[i]; 
            }
        }
        return max_ans;
    }

    // 动态规划 时间复杂度O(n), 空间O(n)
    private static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //dp[i][0]表示第i天不持有股票的最大收益，dp[i][1]表示第[i]天持有股票最大收益
        int[][] dp = new int[prices.length][2];
        //init
        dp[0][0] = 0; 
        dp[0][1] = -prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // 第i天不持有股票的情况，要么是第i-1天不持有，今天依旧不持有，
            // 要么是第i-1天持有，今天卖出。取最大值
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有股票的情况，要么是第i-1天不持有，今天买了，
            // 要么是第i-1天持有，今天不动
            dp[i][1] = Math.max(-prices[i], dp[i - 1][1]);
        }
        return dp[prices.length - 1][0];
    }

    private static int maxProfile1(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price: prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        int[] prices = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }

        int max_ans = Buy_Sockets_Changes(prices);
        System.out.println(max_ans);
        
    }
}
