package Split_Max_Number;

import java.util.*;

public class Main {

    private static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[0];
        for(int i = 0; i <= k && i < nums1.length; i++) { //从nums1中选出长为i的子序列
            if(k - i >=0 && k - i <= nums2.length) { //从nums2中选出长为 k-i 的子序列
                //合并
                int[] tmp = merge(subMaxNumber(nums1, i), subMaxNumber(nums2, k - i));
                //取最大值
                if(compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }
    
    private static int[] subMaxNumber(int[] nums, int len) {
        int[] subNums = new int[len];
        int cur = 0, remain = nums.length - len;
        for(int i = 0; i < nums.length; i++) {
            while (cur > 0 && subNums[cur-1] < nums[i] && remain > 0) {
                cur--;
                remain--;
            }
            if(cur < len) {
                subNums[cur++] = nums[i];
            } else {
                remain--;
            }
        }
        return subNums;
    }

    private static int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int cur = 0, p1 = 0, p2 = 0;
        while (cur < nums1.length + nums2.length) {
            if(compare(nums1, p1, nums2, p2)) {
                res[cur++] = nums1[p1++];
            } else {
                res[cur++] = nums2[p2++];
            }
        }
        return res;
    }

    private static boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;
        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] num1 = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine().trim());
        int[] res = maxNumber(num1, num2, k);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            sb.append(res[i] + ",");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
