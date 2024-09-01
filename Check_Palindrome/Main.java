package Check_Palindrome;

import java.util.Scanner;

/**
 * 检测一个字符串是不是回文串
 */
public class Main {

    public static int checkPalindrome (String input) {
        int front = 0;
        int rear = input.length() - 1;
        while(front < rear) {
            if(input.charAt(front) != input.charAt(rear)) {
                return 0;
            }
            front++;
            rear--;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase().replaceAll("[,:\\s]", "");
        int result = checkPalindrome(input);
        System.out.println(result);
    }    
}
