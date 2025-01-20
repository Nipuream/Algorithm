package Longest_Beautiful_Str;

import java.util.*;

/**
 * 1322
 */
public class Main {

    private static int perttySubStr(String val) {
        HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
        int ans = 1, status = 0;
        maps.put(status, -1);
        for(int i = 0; i < val.length(); i++) {
            int ch = val.charAt(i) - '0';
            status ^= (1 << ch);

						//如果某个数只存在奇数次
            for(int j = 0; j < 10; j++) {
                int index = status ^ (1 << j);
                if(maps.containsKey(index)) {
                    ans = Math.max(ans, i - maps.get(index));
                }
            }

            if(!maps.containsKey(status)) {
                maps.put(status, i);
            } else {
                ans = Math.max(ans, i - maps.get(status));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int result = perttySubStr(input);
        System.out.println(result);
    }
}
