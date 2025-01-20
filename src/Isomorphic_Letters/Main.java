package Isomorphic_Letters;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 同构字符串
 */
public class Main {

    private static int isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) {
            return 0;
        }
        HashMap<Character, Character> maps = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(maps.containsKey(s.charAt(i))) {
                if(maps.get(s.charAt(i)) != t.charAt(i)) 
                    return 0;
            } else {
                maps.put(s.charAt(i), t.charAt(i));
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        int ret = isIsomorphic(input[0], input[1]) * isIsomorphic(input[1], input[0]);
        System.out.println(ret);
    }
    
}
