package Continuout_Sequence;

import java.util.*;

/**
 * 连续数列:
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 *  -2,1,-3,4,-1,2,1,-5,4
 *  6
 */
public class Main {
    
    private static int findMaxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currentNum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            currentNum = Math.max(nums[i], currentNum + nums[i]);
            max = Math.max(currentNum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int result = findMaxSum(nums);
        System.out.println(result);
    }
}
