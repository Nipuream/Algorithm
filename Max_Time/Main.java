package Max_Time;

import java.util.Scanner;

/**
 * 4,2,3,1
 * 23:41
 */
public class Main {

    public static String largestTimeFromDigits(int[] A) {
        
        int ans = -1;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(i != j) {
                    for(int k = 0;  k < 4; k++) {
                        if(k != i && k != j) {
                            int g = 6 - i - j - k;
                            int hours = A[i] * 10 + A[j];
                            int mins = A[k] * 10 + A[g];
                            if(hours < 24 && mins < 60) {
                                int maxTime = hours * 60 + mins;
                                ans = Math.max(ans, maxTime);
                            }
                        }
                    }
                }
            }
        }
        return ans > 0 ? String.format("%02d:%02d", ans/60, ans%60) : "";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        int[] input_int = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            input_int[i] = Integer.parseInt(input[i]);
        }
        String maxTime = largestTimeFromDigits(input_int);
        System.out.println(maxTime);
    }
    
}
