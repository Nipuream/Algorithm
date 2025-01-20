# 向数组追加 K 个整数

## 题目描述

给你一个整数数组 `nums` 和一个整数 `k` 。请你向 `nums` 中追加 `k` 个 **未** 出现在 `nums` 中的、**互不相同** 的 **正** 整数，并使结果数组的元素和 **最小** 。

返回追加到 `nums` 中的 `k` 个整数之和。

## 例子

__case1__
> 输入：nums = [1,4,25,10,25], k = 2 <br/>
> 输出：5

__case2__
> 输入：nums = [5,6], k = 6 <br/>
> 输出：25


## 解体思路

将 `nums` 排序后依次插入 k 个递增整数 `insert_num`

1) 当 nums[i] < insert_num 直接累加 insert_num 即可
2) 当 nums[i] >= insert_num 时， 如果 nums[i] == nums[i - 1] 需要递增 insert_num 的值
3) 当遍历完 nums 数组， k 还不等于0，按照等差公式加上后续的值 (insert_num + insert_num + k - 1) * k / 2
