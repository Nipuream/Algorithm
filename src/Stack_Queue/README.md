# 用两个栈来实现队列

请你仅使用两个栈实现先入先出队列。


# 解题思路

`inStack` 负责输入数据，当需要弹出数据的时候将 `inStack` 的数据重新输入到 `outStack`
这样从 `outStack` 中拿到的数据就和原先输入的数据顺序保持一致了。