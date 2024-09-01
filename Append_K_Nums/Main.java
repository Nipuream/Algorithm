package Append_K_Nums;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static long Append_K_Nums(int[] numbers, int k) {

        Arrays.sort(numbers);
        long sum = 0;
        int insert_num = 1;
        int mx = k;
        for(int i = 0; i < numbers.length && mx > 0; i++) {
            do {
                if(insert_num < numbers[i]) {
                    sum += insert_num;
                    insert_num ++;
                    mx--;
                } else {
                    boolean equal = false;
                    if(i > 0 && numbers[i] == numbers[i-1]) {
                        equal = true; 
                    }
                    if(!equal)
                        insert_num ++;
                    break;
                }
            } while (mx > 0);
        }

        if(mx > 0) {
            sum += ((long)insert_num * 2 + mx - 1) * mx / 2; // header + tail + offset
        }
        return sum;
    }

    private static int[] StrToIntArray(String[] input) {
        int[] array = new int[input.length];
        for(int i = 0; i < input.length; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        return array;
    }

    
    public static void main(String[] args) {
        
        //case 1
        //int[] numbers = { 51,81,63,45,14,10,3,60,48,6,35,21,41,27,7,49,47,24,39,16,27,28,37,19,47,5,42,27,2,11,12,9,4,49,18,17,22,53,36,26,75,30,46,29,43,44,90,1,13,33,34,95,52,45,25,57,41,55,23,52,58,15,20,38,12,50,23,8,30,32,56,59,31,54,22,15,61,40,3 };
        //int k = 32;

        //case 2
        //int[] numbers = { 1 };
        //int k = 100000000;

        //case 3
        //int[] numbers = { 5, 6 };
        //int k = 6;

        //case 4
        // int[] numbers = {1, 4, 10, 25};
        // int k = 2;

        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine().trim();
        String line2 = scanner.nextLine().trim();

        int[] numbers = StrToIntArray(line1.split(" "));
        int k = Integer.parseInt(line2);

        long sum = Append_K_Nums(numbers, k);
        System.out.println(sum);
    }
}
