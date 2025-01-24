# 最小栈

## 题目描述

设计一个支持 `push` ，`pop` ，`top` 操作，并能在常数时间内检索到最小元素的栈。

实现 `MinStack` 类:

- `MinStack()` 初始化堆栈对象。
- `void push(int val)` 将元素val推入堆栈。
- `void pop()` 删除堆栈顶部的元素。
- `int top()` 获取堆栈顶部的元素。
- `int getMin()` 获取堆栈中的最小元素。

__case__
> input: <br/>
> push,push,push,getMin,pop,top,getMin <br/>
> -2,0,-3,,,, <br/>
> output: <br/>
> null,null,null,-3,null,0,-2


## 解题思路
- 创建一个 `stack` 和一个 `priorityQueue` 来实现。
- 不创建额外的数据结构，使用 `stack` 来保存和 `min` 之间的 `diff`，设计更为巧妙。
