# 完全平方数

LeetCode 279.

给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

示例 1：

输入：n = 12
输出：3 
解释：12 = 4 + 4 + 4
示例 2：

输入：n = 13
输出：2
解释：13 = 4 + 9


## 题解

思路和 [兑换零钱](./coins_change.md) 类似。

```java
public int numSquares(int n) {
    int max = n + 1;
    int[] dp = new int[max];
    Arrays.fill(dp, max);
    
    dp[0] = 0;
    for (int i = 1; i < max; i++) {
        for (int j = 1; j * j <= i; j++) {
            dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
        }
    }
    return dp[n];
}
```