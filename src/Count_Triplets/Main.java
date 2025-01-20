package Count_Triplets;

import java.util.Arrays;
import java.util.Scanner;

/**
 * input: 2,1,3
 * output: 12
 */
public class Main {
    
    private static int countTriplets(int[] nums) {

        int[] cnt = new int[1 << 16];
        for(int x : nums) {
            for(int y : nums) {
                ++cnt[x & y];
            }
        }

        int ans = 0;
        for(int k : nums) {
            for(int mask = 0; mask < (1 << 16); mask++) {
                if((k & mask) == 0) {
                    ans += cnt[mask];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int result = countTriplets(nums);
        System.out.println(result);
    }

}
