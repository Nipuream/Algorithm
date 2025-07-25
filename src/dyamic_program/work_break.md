# 单词拆分

LeetCode 139

给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。

注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false


## 题解

类似的题目： [兑换零钱](./coins_change.md) [完全平方数](./num_squares.md)

```java
public boolean wordBreak(String s, List<String> wordDict) {
    int max = s.length() + 1;
    boolean[] dp = new boolean[max];
    dp[0] = true;
    for (int i = 1; i < max; i++) {
        for (String word: wordDict) {
            if (i >= word.length()) {
                if (dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                    dp[i] = true;
                }
            }
        }
    }
    return dp[s.length()];
}
```