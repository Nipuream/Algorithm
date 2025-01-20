package Same_Construct_Str;

import java.util.*;

/**
 * input: paper,title
 * output: 1
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");

        char[] origin = input[0].toCharArray();
        char[] dest = input[1].toCharArray();

        char start = origin[0];
        char end = dest[0];

        int result = 1;
        for(int i = 0; i < input[0].length(); i++) {
            if(origin[i] - start != dest[i] - end) {
                result = 0;
            }
        }
        System.out.println(result);
    }

}
