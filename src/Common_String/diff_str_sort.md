# 字母异位词分组

给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

 

示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]

输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

解释：

在 strs 中没有字符串可以通过重新排列来形成 "bat"。
字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。

思路：可以考虑将每个字符串重新排序，作为 key 来记录每个 value 所在的分组。

```java
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> res = new HashMap<>();

        for (String str: strs) {
            char[] val = str.toCharArray();
            String key = new String(Arrays.sort(val));
            if (res.containsKey(key)) {
                res.get(key).add(str);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(str);
                res.add(tmp);
            }
        }
        return new ArrayList<List<String>>(res.values());
    }
```