package Replenish_Sort;

import java.util.*;
/**
 * 按照补数升序排序
 * 
 * input: 5,10,4,2
 * output: 2,5,4,10
 * 
 * input: 7(0),8(7),9(6),10(5)
 * output: 7,10,9,8
 * 
 * input: 7,7,9,10
 * output: 77,10,9
 * 
 * input: 0(1), 7(0), 5(2), 2(1)
 * output: 7,0,2,5
 * 
 * input: 22,35,101,45
 * output: 22,45,101,35
 */


class Node {
    int origin;
    int last;
    Node(int origin, int last) {
        this.origin = origin;
        this.last = last;
    }
}

public class Main {

    private static int calReplenish(int number) {
        StringBuilder sb = new StringBuilder();
        String binary = Integer.toBinaryString(number);
        char[] array = binary.toCharArray();
        for(int i = 0; i < array.length; i++) {
            sb.append(array[i] == '0' ? '1' : '0');
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);    
        List<Node> list = new ArrayList<>();
        int[] array = Arrays.stream(scanner.nextLine().trim().split(","))
        .mapToInt(Integer::parseInt).toArray();

        for(int i = 0; i < array.length; i++) {
            Node node = new Node(array[i], calReplenish(array[i]));
            list.add(node);
        }

        list.sort((a, b) -> {
            if(a.last < b.last) {
                return -1;
            } else if(a.last > b.last) {
                return 1;
            } else {
                return a.origin - b.origin;
            }
        });


        StringBuilder sb = new StringBuilder();
        list.forEach(val -> {
            sb.append(val.origin).append(",");
        });
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }

}
