# 最长回文子串

Leetcode 5

给你一个字符串 s，找到 s 中最长的 回文 子串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"

## 题解

```java
public String longestPalindrome(String s) {

    if (s.length() < 2) return s;

    char[] s1 = s.toCharArray();
    int length = s1.length;
    int maxLen = 1, begin = 0;
    boolean[][] dp = new boolean[length][length];
    for (int i = 0; i < length; i++) {
        dp[i][i] = true;
    }

    for (int L = 2; L <= length; L++) {
        for (int i = 0; i < length; i++) {
            int j = L + i - 1;
            if (j >= length) break;
            if (s1[i] == s1[j]) {
                if (j - i <= 2) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
            } else {
                dp[i][j] = false;
            }

            if (dp[i][j] && j - i + 1 > maxLen) {
                begin = i;
                maxLen = j - i + 1;
            }
        }
    }

    return s.substring(begin, begin + maxLen);
}
```