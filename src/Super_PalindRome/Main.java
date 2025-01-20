package Super_PalindRome;

import java.util.*;

class Main {

    public static String superPalindromesInRange(String left, String right) {
        long L = Long.valueOf(left);
        long R = Long.valueOf(right);
        int MAGIC = 100000;
        List<Long> list = new ArrayList<>();

        for(int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for(int i = sb.length() - 2; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            System.out.println("odd:" + v);
            v *= v;
            if(v > R) break;
            if(v >= L && isPalindrome(v)) {
                list.add(v);
            }
        }

        for(int k = 1; k < MAGIC; k++) {
            StringBuilder sb = new StringBuilder(Integer.toString(k));
            for(int i = sb.length() - 1; i >= 0; i--) {
                sb.append(sb.charAt(i));
            }
            long v = Long.valueOf(sb.toString());
            System.out.println("even:" + v);
            v *= v;
            if(v > R) break;
            if(v >= L && isPalindrome(v)) {
                list.add(v);
            }
        }
        Collections.sort(list);
        return list.toString();
    }

    private static boolean isPalindrome(long x) {
        return x == reverse(x);
    }

    private static long reverse(long x) {
        long ans = 0;
        while(x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        String result = superPalindromesInRange(input[0], input[1]);
        System.out.println(result);
    }
}