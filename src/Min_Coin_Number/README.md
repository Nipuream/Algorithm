# 最小硬币个数

## 题目描述
假设现在有一堆硬币，其中有足够个1元硬币、足够个2元硬币和足够个5元硬币。现在需要用这些硬币凑出总价值为n元的钱，求最少需要多少枚硬币？

__case1__
> input: 0 <br/>
> output: 0

__case2__
> input: 100
> output: 20 

## 解题思路
非常简单的贪心题目

```java
long num = number/5 + number%5/2 + number%5%2;
return num;
```