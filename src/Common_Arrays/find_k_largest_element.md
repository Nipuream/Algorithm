# 数组中的第K个最大元素

给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。

请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。


示例 1:

输入: [3,2,1,5,6,4], k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6], k = 4
输出: 4


Leetcode 215.


题解：考虑使用最大堆和快速排序来解决这个问题，有的公司可能需要手写快排和堆排序。
```java
public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
    for (int val : nums) queue.offer(val);
    while (--k > 0) {
        queue.poll();
    }
    return queue.poll();
}
```