package Sort_By_Frequece;

import java.util.*;

public class Main {

    private static String Sort_Letters_By_Frequeuce(String letters) {

        Map<Character, Integer> count = new HashMap<>();
        for(char c : letters.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(count.entrySet());
        list.sort((e1, e2) -> {
            if(e1.getValue() == e2.getValue()) {
                return e1.getKey() - e2.getKey();
            } else {
                return e2.getValue() - e1.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < list.size(); i++) {
            Map.Entry<Character, Integer> c = list.get(i);
            int num = c.getValue();
            for(int j = 0; j < num; j++) {
                sb.append(c.getKey());
            }   
        }

        return sb.toString();
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String result = Sort_Letters_By_Frequeuce(input);
        System.out.println(result);
    }
}
