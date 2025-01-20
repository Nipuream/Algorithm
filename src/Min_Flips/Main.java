package Min_Flips;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小翻转次数
 */
public class Main {
    
    private static int Min_Flips(int a, int b, int c) {
        int ans = 0;
        for(int i = 0; i < 31; i++) {
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;
            int c_bit = (c >> i) & 1;
            if(c_bit == 0) {
                ans += (a_bit + b_bit);
            } else {
                if(a_bit + b_bit == 0) 
                    ans ++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int ret = Min_Flips(input[0], input[1], input[2]);
        System.out.println(ret);
    }
}
