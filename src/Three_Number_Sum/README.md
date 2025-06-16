# 三数之和
给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

LeetCode 15.


```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int j = i + 1;
        int k = nums.length - 1;
        while (j < k) {
            while (j > i + 1 && j < nums.length - 1 && nums[j] == nums[j - 1]) j++;
            if (j >= k) break;
            int sum = nums[i] + nums[j] + nums[k];
            if (sum == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[i]);
                tmp.add(nums[j]);
                tmp.add(nums[k]);
                list.add(tmp);
                j++;
            } else if (sum < 0) {
                j++;
            } else {
                k--;
            }
        }
    }
    return list;
}
```