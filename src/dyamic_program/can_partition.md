# 分割等和子集

Leetcode 416

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

示例 1：

输入：nums = [1,5,11,5]
输出：true
解释：数组可以分割成 [1, 5, 5] 和 [11] 。
示例 2：

输入：nums = [1,2,3,5]
输出：false
解释：数组不能分割成两个元素和相等的子集。


## 题解

从题目得知，需要从数组中找到若干的元素的值等于总值的一半，并且总值必须是偶数。那么就转换为 0 - 1 背包问题。

1) 如果不选择： dp[i][j] = dp[i - 1][j]
2) 如果选择：
    - nums[i] == j, dp[i][j] = true.
    - nums[j] == j, dp[i][j] = dp[i - 1][j - nums[i]]
 
```java
public boolean canPartition(int[] nums) {
    int len = nums.length;
    int sum = 0;
    for (int x : nums) {
        sum += x;
    }
    if ((sum & 1) == 1) {
        return false;
    }

    int target = sum / 2;
    boolean[][] dp = new boolean[len][target + 1];

    if (nums[0] <= target) {
        dp[0][nums[0]] = true;
    }

    for (int i = 1; i < len; i++) {
        for (int j = 0; j <= target; j++) {
            dp[i][j] = dp[i - 1][j];

            if (nums[i] == j) {
                dp[i][j] = true;
            }

            if (nums[i] < j) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }
    }

    return dp[len - 1][target];
}
```