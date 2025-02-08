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
            stack.push(0);
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
        if (!stack.isEmpty()) {
            int diff = stack.peek();
            if (diff < 0) {
                return min;
            } else {
                return min + diff;
            }
        }
        return -1;
    }

    public int getMin() {
        return min;
    }
}

class MinStack1 {

    private LinkedList<Integer> stack = new LinkedList<>();
    private PriorityQueue<Integer> min = new PriorityQueue<>();

    void push(int val) {
        stack.push(val);
        min.add(val);
    }

    void pop() {
        if(!stack.isEmpty()) {
            int val = stack.pop();
            min.remove(val);
        }
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return min.peek();
    }

}

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String[] line1 = scanner.nextLine().trim().split(",");
        String[] line2 = scanner.nextLine().trim().split(",");

        int length = line1.length;
        MinStack1 stack = new MinStack1();
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
