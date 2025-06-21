package Common_Struct;

import java.util.Stack;

public class Main {

  public static  String decodeString(String s) {

      Stack<Character> stack = new Stack<>();
      StringBuilder sb = new StringBuilder();
      for (char c : s.toCharArray()) {
          if (c != ']') stack.push(c);
          else {
            while (!stack.isEmpty() && stack.peek() != '[') {
              sb.append(stack.pop());
            }
            stack.pop(); // '[' 
            int repeat = (stack.pop() - '0');
            String tmp = sb.toString();
            while (repeat-- > 1) {
              sb.append(tmp);
            }
          }
      }
      return sb.toString();
  }
  
  public static void main(String[] args) {
    String str = "3[a]2[bc]";
    System.out.println(decodeString(str));
  }
}
