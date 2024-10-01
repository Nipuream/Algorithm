package Call_to_your_teacher;

/**
 * 
 * 
input: 
5 5
1 3
2 3
3 4
2 4
4 5

output: 
Yes
 * 
 * 
 * 
input:
4 3
1 2
2 3
4 1

out:
No
 */
import java.util.*;

class Node {
    String pre;
    String last;
    Node(String pre, String last) {
        this.pre = pre;
        this.last = last;
    }
}

public class Main {

    private static boolean find = false;

    private static void call(List<Node> list, String input, String n) {
        list.forEach(node -> {
            if(node.pre.equals(input)) {
                if(node.last.equals(n))
                    find = true;
                else 
                    call(list, node.last, n);
            }
        });
    }

    public static void main(String[] args) {

        List<Node> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().trim().split(" ");
            list.add(new Node(line[0], line[1]));
        }
        call(list, "1", input[0]);
        System.out.println(find ? "Yes" : "No");
    }
}

