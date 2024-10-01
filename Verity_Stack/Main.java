package Verity_Stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 
pushed =
[2,1,0]
popped =
[1,2,0]

pushed =
[1,2,3,0]
popped =
[2,1,3,0]
 */
public class Main {
    
    private static boolean Verfity_Stack(int[] input1, int[] input2) {
        if(input1.length != input2.length) return false;
        Stack<Integer> stack = new Stack<>();
        int input1_index = 0, input2_index = 0;
        for(input1_index = 0; input1_index < input1.length; input1_index++) {

            if(input1[input1_index] == input2[input2_index]) {
                input2_index++;
            } else {
                if(!stack.isEmpty() && stack.peek() == input2[input2_index]) {
                    stack.pop();
                    input2_index++;
                    input1_index--;
                } else {
                    stack.push(input1[input1_index]);
                }
            }
        }

        while(!stack.isEmpty()) {
            if(stack.pop() != input2[input2_index++]) 
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input1 = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] input2 = Arrays.stream(scanner.nextLine().trim().split(",")).mapToInt(Integer::parseInt).toArray();
        boolean result = Verfity_Stack(input1, input2);
        System.out.println(result);
    }
}
