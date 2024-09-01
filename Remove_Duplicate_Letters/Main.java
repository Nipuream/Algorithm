package Remove_Duplicate_Letters;

import java.util.Scanner;

//输入: abecbcd
//输出: abecd
public class Main {

    private static String Remove_Duplicate_Letters(String letters) {

        char[] letters_char = letters.toCharArray();
        //一共26个字母，记录他们在 letters 出现的次数
        int[] left = new int[95];
        for(char c : letters_char) {
            left[c - '!'] ++;
        }
        
        boolean[] isAns = new boolean[95];
        StringBuilder ans = new StringBuilder();

        for(char c : letters_char) {

            left[c - '!'] --;
            if(isAns[c - '!']) continue;

            while(!ans.toString().isEmpty() && c < ans.charAt(ans.length() - 1) && left[ans.charAt(ans.length() - 1) - '!'] > 0) {
                isAns[ans.charAt(ans.length() - 1) - '!'] = false;
                ans.deleteCharAt(ans.length() - 1);
            }

            ans.append(c);
            isAns[c - '!'] = true;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = Remove_Duplicate_Letters(input);
        System.out.println(result);
    }

}
