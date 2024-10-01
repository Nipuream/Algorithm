package Serial_Array_Sum;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    /**
     * 暴力解法
     */
    private static int Serial_Array_Sum(int[] array, int k) {
        int sum = 0;
        for(int i = 0; i < array.length - 1; i++) {
            sum = array[i];
            for(int j = i+1; j < array.length; j++) {
                sum += array[j];
                if(sum % k == 0) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine().trim());
        int ret = Serial_Array_Sum(array, k);
        System.out.println(ret);
    }
}
