package Press_Letters;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private static String Press_Letters(String input) {
        StringBuilder sb = new StringBuilder();
        char[] input_char_array = input.toCharArray();
        for(char c : input_char_array) {
            if(sb.length() == 0 || c != sb.charAt(sb.length() - 1)) {
                sb.append(c);
            }
        }
        return sb.toString();    
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(Press_Letters(input));
    }
    
}
