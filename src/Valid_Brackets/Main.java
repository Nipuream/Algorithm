package Valid_Brackets;

import java.util.*;

public class Main {
    
    private static int Valid_Bracket(String input) {

        if(input == null || input.equals("") || input.length() % 2 != 0) {
            return 0;
        }

        HashMap<Character, Character> char_match = new HashMap<Character, Character>();
        char_match.put('(', ')');
        char_match.put('{', '}');
        char_match.put('[', ']');
        
        char[] input_chars = input.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0; i < input_chars.length; i++) {
            if(i < input_chars.length / 2) {
                stack.push(input_chars[i]);
            } else {
                char pop_char = stack.pop();
                if(!char_match.containsKey(pop_char)) return 0;
                if(char_match.get(pop_char) == input_chars[i]) {
                    continue;
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int match_num = Valid_Bracket(input);
        System.out.println(match_num);
    
    }
}
