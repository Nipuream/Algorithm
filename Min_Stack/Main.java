package Min_Stack;

import java.util.*;


/**
 * 不额外占用数据结构解法，像 stack 内 push diff 值.
 */

class MinStack {

    private int min;
    private Stack<Integer> stack;

    public MinStack() {
        min = 0;
        stack = new Stack<>();
    }

    public void push(int val) {

        if(stack.isEmpty()) {
            stack.push(val);
            min = val;
            return ;
        }

        int diff = val - min;
        stack.push(diff);
        if(diff < 0) {
            min = val;
        }
    }

    public void pop() {
        if(stack.peek() > 0) {
            stack.pop();
        } else {
            min = min - stack.pop();
        }
    }

    public int top() {
        if(stack.peek() >= 0) {
            return min + stack.peek();
        } else {
            return min - stack.peek();
        }
    }

    public int getMin() {
        return min;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(",");
        String[] line2 = scanner.nextLine().trim().split(",");

        int length = line1.length;
        MinStack stack = new MinStack();
        for(int i = 0; i < length; i++) {
            switch (line1[i]) {
                case "push":
                {
                    stack.push(Integer.parseInt(line2[i]));
                    System.out.print("null");
                }
                break;
                case "pop":
                {
                    stack.pop();
                    System.out.print("null");
                }
                break;
                case "getMin":
                {
                    System.out.print(String.valueOf(stack.getMin()));
                }
                break;
                case "top": 
                {
                    System.out.print(String.valueOf(stack.top()));
                }
                break;
                default:
                    break;  
            }
            if(i != (length - 1)) {
                System.out.print(",");
            } else {
                System.out.println();
            }
        }
    }
}
