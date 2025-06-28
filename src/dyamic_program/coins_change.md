# 零钱兑换

LeetCode 332

给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。


示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3 
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0



## 题解

动态规划的思路，x 从 0 -> amount 来观察，每次得到最优解。

1) f(0) = 0，肯定没有对应的 coins 。
2) 可以从爬楼梯的思路来思考，每上一层楼梯，就找对应每种上来方式的前序最小次数 + 1.

```java
public int coinChange(int[] coins, int amount) {
    int max = amount + 1;
    int[] dp = new int[max];
    Arrays.fill(dp, max);

    dp[0] = 0;
    for (int i = 1; i < max; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (i >= coins[j]) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}
```
