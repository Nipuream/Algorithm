# 最长公共子序列

Leetcode 1143

给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。

例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

示例 1：

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace" ，它的长度为 3 。
示例 2：

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。
示例 3：

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。

## 题解

```java
public int longestCommonSubsequence(String text1, String text2) {
    
    char[] s1 = text1.toCharArray();
    char[] s2 = text2.toCharArray();

    int[][] dp = new int[s1.length + 1][s2.length + 1];
    for (int i = 0; i < s1.length + 1; i++) {
        dp[i][0] = 0;
    }
    for (int i = 0; i < s2.length + 1; i++) {
        dp[0][i] = 0;
    }

    for (int i = 1; i < s1.length + 1; i++) {
        for (int j = 1; j < s2.length + 1; j++) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i -1][j - 1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i -1][j], dp[i][j - 1]));
            }
        }
    }
    return dp[s1.length][s2.length];
}
```
