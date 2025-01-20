package Length_Of_LIS;

import java.util.*;

public class Main {

    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 1;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        //abcabcbb
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        HashSet<Character> set = new HashSet<>();
        int left = 0, ans = 0;
        for(char ch : input) {
            while(set.contains(ch)) set.remove(input[left++]);
            set.add(ch);
            ans = Math.max(ans, set.size());
        }
        System.out.println(ans);
    }
}
