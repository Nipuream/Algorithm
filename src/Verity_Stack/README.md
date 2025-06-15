# 题目描述

给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。

示例 ：

输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
输出：true
解释：我们可以按以下顺序执行：
push(1), push(2), push(3), push(4), pop() -> 4,
push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1


leetcode 946.


# 解题思路

以 示例 来说下我的思路：

new 一个 stack 出来，接着遍历 pushed。
- 如果当前 pushed[index1] 等于 poped[index2] 则表示一押入栈中就弹出的元素，不去处理它，直接 index2++, index1 会随着遍历递增。
- 如果当前 pushed[index1] 不等于 poped[index2] 呢，那么有两种情况了：
  - 当前 `stack` 的栈顶元素是等于 poped[index2] 的，那么弹出 `stack` 中的栈顶元素， index1--, index2++
  - 否则则将此元素押入栈 `stack` 中。 



