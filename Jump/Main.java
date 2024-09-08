package Jump;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static boolean skip(int[] steps, int index, boolean[] cover) {
        if(index >= steps.length || index < 0) return false;
        if(cover[index]) return false;
        if(steps[index] == 0) return true;

        cover[index] = true;
        int skip_step = steps[index];
        return skip(steps, index + skip_step, cover) || skip(steps, index - skip_step, cover);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine().trim());
        int[] arrays = Arrays.stream(scanner.nextLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int origin_index = Integer.parseInt(scanner.nextLine().trim());
        boolean[] cover = new boolean[length];
        boolean result = skip(arrays, origin_index, cover);
        System.out.println(result ? "True" : "False");
    }
}
