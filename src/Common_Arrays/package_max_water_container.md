# 盛最多水的容器

给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

返回容器可以储存的最大水量。

说明：你不能倾斜容器。

![alt text](image-1.png)

Leetcode 11

```java
public int maxArea(int[] height) {
    int ans = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
        int width = right - left;
        int area = height[left] < height[right] ? width * height[left++] : width * height[right--];
        ans = Math.max(ans, area);
    }
    return ans;
}
```