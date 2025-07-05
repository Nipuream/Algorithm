# 多数元素

给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

示例 1：

输入：nums = [3,2,3]
输出：3
示例 2：

输入：nums = [2,2,1,1,1,2,2]
输出：2


```java
public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> maps = new HashMap<>();
    int key = 0, max = 0;
    for (int x : nums) {
        int count = maps.getOrDefault(x, 0);
        maps.put(x, count + 1);
        if (maps.get(x) > max) {
            max = count;
            key = x;
        }
    }
    return key;
}
```
