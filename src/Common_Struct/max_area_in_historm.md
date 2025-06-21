# 柱状图中最大的矩形

给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。

![alt text](image.png)

输入：heights = [2,1,5,6,2,3]
输出：10
解释：最大的矩形为图中红色区域，面积为 10


题解思路: 单调栈来实现，遍历数组中元素。发现当前元素`height[index]`要小于当前栈顶元素`height[stack.peek()]`，则可计算出之前 `index - 1` 最大面积。

```java
public int largestRectangleArea(int[] heights) {
    Deque<Integer> stack = new LinkedList<>();
    int area = 0;
    int n = heights.length;
    for (int i = 0; i <= n; i++) {
        int currentHeight = (i == n) ? 0 : heights[i]; 
        while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
            int height = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            area = Math.max(area, width * height);
        }
        stack.push(i);
    }
    return area;
}
```