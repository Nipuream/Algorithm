# 滑动窗口最大值

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 ## 题解

 滑动窗口 加上 单调栈

 ```java
public int[] maxSlidingWindow(int[] nums, int k) {

    Deque<Integer> deque = new LinkedList<Integer>();
    int[] res = new int[nums.length - k + 1];
    for (int i = 0; i < nums.length; i++) {
        int left = i - k + 1;
        while (i > 0 && !deque.isEmpty() && deque.peekLast() < nums[i]) {
            deque.removeLast();
        }
        deque.addLast(nums[i]);
        if (left >= 0) {
            res[left] = deque.peekFirst();
        }
        if (left >= 0 && deque.peekFirst() == nums[left]) {
            deque.removeFirst();
        }
    }
    return res;
}
 ```