# 接雨水

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

![alt text](image.png)

输入：[1,8,6,2,5,4,8,3,7]
输出：49 
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。



## 题解

和 [装水最多的容器](./package_max_water_container.md) 类似，height[left] 和 height[right] 谁小 谁就往中间靠拢。区别就是，无论左边还是右边都要记录一个最高值，leftMax - height[left] 就是当前进度装出的水量，如果 leftMax - height[left] = 0，那就是自己最高，接不到水了。


```java
public int trap(int[] height) {
    int ans = 0, leftMax = 0, rightMax = 0;
    int left = 0, right = height.length -1;
    while (left < right) {
        leftMax = Math.max(leftMax, height[left]);
        rightMax = Math.max(rightMax, height[right]);
        if (height[left] < height[right]) {
            ans += leftMax - height[left++];
        } else {
            ans += rightMax - height[right--];
        }
    }
    return ans;
}
```