# 前 K 个高频元素

给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


LeetCode 347.

```java
public int[] topKFrequent(int[] nums, int k) {

    Map<Integer, Integer> maps = new HashMap<>();
    for (int x : nums) {
        maps.put(x, maps.getOrDefault(x, 0) + 1);
    }
    List<Map.Entry<Integer, Integer>> list = new ArrayList<>(maps.entrySet());
    Collections.sort(list, (a, b) -> {
        return b.getValue() - a.getValue();
    });

    int[] res = new int[k];
    int index = 0;
    for (int i = 0; i < k; i++) {
        res[i] = list.get(i).getKey();
    }
    return res;
}
```