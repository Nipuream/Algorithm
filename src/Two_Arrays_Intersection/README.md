# 求两个数组的交集

## 题目描述 

给两个整型数组 nums1 和 nums2 ，返回 它们的交集 。

输出结果中的每个元素一定是 唯一 的。输出结果按照从小到大排列。

__例如__ <br/>
nums1的内容是[1,2,6,5,9,8]，nums2的内容是[3,9,6]，最后输出的结果是[6,9]。

## 题解
只要考虑到重复字符，就考虑数据结构 Set ，依次推入集合中，只要返回 false ，即是重复元素，另外最后集合内元素需要转化为数组再排序。