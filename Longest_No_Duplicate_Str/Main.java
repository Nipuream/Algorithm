package Longest_No_Duplicate_Str;

import java.util.*;

class Main {

    private static int Find_Longest_Str(String input) {
        Set<Character> set = new HashSet<>();
        char[] array = input.toCharArray();
        int n = input.length();
        int right = -1, ans = 0;
        for(int left = 0; left < n; left++) {
            if(left != 0) {
                set.remove(array[left - 1]);
            }
            while (right + 1 < n && !set.contains(array[right + 1])) {
                set.add(array[right + 1]);
                right ++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    private static int test(String input) {
        Set<Character> set = new HashSet<>();
        int left = 0, ans = 0;;
        for(Character ch : input.toCharArray()) {
            while(set.contains(ch)) set.remove(input.charAt(left++));
            set.add(ch);
            ans = Math.max(ans, set.size());
        }
        return ans;
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim(); 
        //int num = Find_Longest_Str(input);
        int num = test(input);
        System.out.println(num);
    }
}