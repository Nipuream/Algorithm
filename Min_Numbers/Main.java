package Min_Numbers;

import java.util.*;

/**
 * 
 */
public class Main {


    private static String Min_Numbers(List<String> list, boolean negate) {
        Collections.sort(list, (a, b) -> {
            if(negate) {
              return (b + a).compareTo(a + b);
            } else {
              return (a + b).compareTo(b + a);
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        List<String> input_without_negate = new ArrayList<>();
        String negate_number = "";
        for(int i = 0; i < input.length; i++) {
            if(!input[i].contains("-")) input_without_negate.add(input[i]);
            else negate_number = input[i];
        }
        
        String result = Min_Numbers(input_without_negate, !negate_number.equals(""));
        System.out.println(negate_number + result);
    }
}
