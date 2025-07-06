# 找到字符串中所有字母异位词

给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。


## 题解

问题的难点在于，异位词并非并非相等就可以，比如示例 case 中的 `af` 和 `be`。
所以需要使用两个数组来记录 字符出现的次数，还有你是否知道 Arrays.equals() 来判断数组是否相等？

```java
public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new ArrayList<>();
    int[] CNP = new int[26];
    int[] CNS = new int[26];
    for (Character c : p.toCharArray()) {
        CNP[c - 'a']++;
    }
    for (int right = 0; right < s.length(); right++) {
        CNS[s.charAt(right) - 'a'] ++;
        int left = right - p.length() + 1;
        if (left < 0) continue;
        if (Arrays.equals(CNP, CNS)) {
            res.add(left);
        }
        CNS[s.charAt(left) - 'a']--;
    }
    return res;
}
```
