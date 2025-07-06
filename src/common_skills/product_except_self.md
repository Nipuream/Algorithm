# 除自身以外数组的乘积

给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。

题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。

请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]


## 题解

res[i] = nums[0] * nums[1] * .... nums[i - 1] * nums[i + 1] * nums[n];
分别用两个数组存储 前缀乘积数组和后缀乘积数组

```java
public int[] productExceptSelf(int[] nums) {

    int n = nums.length;
    int[] res = new int[n];
    res[0] = 1;
    for (int i = 1; i < n; i++) {
        res[i] = res[i - 1] * nums[i]; 
    }

    int temp = 1;
    for (int i = n - 2; i >= 0; i--) {
        temp *= nums[i + 1];
        res[i] *= temp;
    }
    return res;
}
```