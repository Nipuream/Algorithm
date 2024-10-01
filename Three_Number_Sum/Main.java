package Three_Number_Sum;

import java.util.Arrays;

public class Main {

    private static int threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                while (j > i + 1 && j < n && nums[j] == nums[j - 1]) j++;
                if(j >= k) break;
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0) {
                    ans ++;
                    j++;
                } else if ( sum > 0) {
                    k--;
                } else if(sum < 0) {
                    j ++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        
    }
}
