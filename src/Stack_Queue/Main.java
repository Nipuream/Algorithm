
package Stack_Queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 用两个栈实现一个队列
 */
class MyQueue {

    Stack<Integer> inStack, outStack;

    public MyQueue() {
        inStack = new Stack<Integer>();
        outStack = new Stack<Integer>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    private void revertQueue() {
       if(outStack.empty()) {
            int size = inStack.size();
            for(int i = 0; i < size; i++) {
                outStack.push(inStack.peek());
                inStack.pop();
            }
        }
    }

    public int pop() {
        revertQueue();
        return (int)outStack.pop();
    }

    public int peek() {
        revertQueue();
        return (int)outStack.peek();
    }

    public boolean empty() {
        revertQueue();
        return outStack.empty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        Scanner in = new Scanner(System.in);
        String[] operator = in.nextLine().split(",");
        String[] value = in.nextLine().split(",");
        for(int i = 0; i < operator.length; i++) {
            switch(operator[i]) {
                case "push": {
                    myQueue.push(Integer.parseInt(value[i]));
                    System.out.print("null");
                }
                break;
                case "peek": {
                    System.out.print(String.valueOf(myQueue.peek()));
                }
                break;
                case "pop": {
                    System.out.print(String.valueOf(myQueue.pop()));
                }
                break;
                case "empty": {
                    System.out.print(String.valueOf(myQueue.empty()));
                }
                break;
            }
            if(i < operator.length -1) {
               System.out.print(","); 
            } else {
                System.out.print("\n");
            }
        }
    }
}