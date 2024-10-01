package Delete_Invalid_Brackets;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 删除无效的括号
 */
public class Main {

    private static String Delete_Invalid_Backets(String letters) {
        
        StringBuilder sb = new StringBuilder(letters);
        LinkedList<Integer> stack = new LinkedList<>();
                
        for(int i = 0; i < sb.length(); i++) {
          if(sb.charAt(i) == '(') stack.push(i);
          if(sb.charAt(i) == ')') {
              if(stack.isEmpty()) {
                  sb.deleteCharAt(i);
                  i--;
              } else {
                  stack.pop();
              }
          }  
        }

        while(!stack.isEmpty()) {
            sb.deleteCharAt(stack.pop());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String last = Delete_Invalid_Backets(input);
        System.out.println(last); 
    }
    
}
