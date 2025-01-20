package Longest_Valid_Backets;

import java.util.*;

/**
 * input: (()
 * output: 2
 * 
 * input: )()(()))
 * output: 6
 * 
 * input: (()())
 * (())))()
 * 
 * input: 
 * output: 0
 */
public class Main {

    public static int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int result = longestValidParentheses(input);
        System.out.println(result);
    }

}
