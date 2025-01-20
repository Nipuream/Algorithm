package Skip_Distance;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static boolean skip(int[] nums, int start) {

        if(nums.length == 0) return false;
        if(start > nums.length - 1) return false;
        if(start + nums[start] >= nums.length - 1) return true;

        for(int i = 1; i < nums[start]; i++) {
            return skip(nums, start + i);
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        boolean result = skip(nums, 0);
        System.out.println(result ? "true" : "false");
    }
}
