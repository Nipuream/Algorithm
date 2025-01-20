package Find_Area_Num;

import java.util.Scanner;

public class Main {
    
    private static int Find_Area_Num(int[] nums, int lower, int upper) {

        int area_nums = 0;
        for(int i = 0; i < nums.length; i++) {
            int sum = 0;
            for(int j = i; j < nums.length; j++) {
                if(i == j) {
                    sum = nums[j];
                } else {
                    sum += nums[j];
                }
                if(sum >= lower && sum <= upper) {
                    area_nums++;
                }
            }
        }
        return area_nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums_str= scanner.nextLine().trim().split(" ");
        String lower_str = scanner.nextLine();
        String upper_str = scanner.nextLine();

        int[] nums = new int[nums_str.length];
        for(int i = 0; i < nums_str.length; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        int lower = Integer.parseInt(lower_str);
        int upper = Integer.parseInt(upper_str);
        int area_nums = Find_Area_Num(nums, lower, upper);
        System.out.println(area_nums);
    }
}
