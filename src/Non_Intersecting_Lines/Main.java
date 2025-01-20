package Non_Intersecting_Lines;

import java.util.*;


public class Main {
    
    

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int[] num1 = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] num2 = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int[] num1_new_array = new int[num1.length - 1];
        System.arraycopy(num1, 1, num1_new_array, 0, num1.length - 1);
        int[] num2_new_array = new int[num2.length - 1];
        System.arraycopy(num2, 1, num2_new_array, 0, num2.length - 1);

    }
}
