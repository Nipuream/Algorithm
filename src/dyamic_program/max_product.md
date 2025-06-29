# 乘积最大子数组

Leetcode 152

给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

测试用例的答案是一个 32-位 整数。


示例 1:

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。


## 题解

先做完前序题 [最大子数组和](./src/Common_Arrays/max_sub_array.md) ，发现它的公示套用在这里会是错的。
原因是子元素有可能是负数，所以需要记录下之前遍历最小的负数，如果当前是负数 那么就得到最大值了。

```java
public int maxProduct(int[] nums) {
    if (nums.length == 1) return nums[0];
    long maxF = nums[0], minF = nums[0];
    int ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
        long max = maxF, min = minF;
        maxF = Math.max(max * nums[i], Math.max(nums[i], nums[i] * min));
        minF = Math.min(min * nums[i], Math.min(nums[i], nums[i] * max));
        ans = Math.max(ans, (int)maxF);
    }
    return ans;
}
```


