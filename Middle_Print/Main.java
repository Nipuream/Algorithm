package Middle_Print;

import java.util.*;
import java.util.stream.Collectors;


class Node {

    String value;
    Node left = null;
    Node right = null;

    Node(String value) {
        this.value = value;
    }
}

/**
 * 二叉树的中序遍历
 */
public class Main {

    private static Node buildTree(String[] array) {

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(array[0]);
        queue.offer(root);

        int i = 1;
        while(i < array.length && !queue.isEmpty()) {
            Node parent = queue.poll();
            if(!"null".equals(array[i])) {
                Node left = new Node(array[i]);
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if(i < array.length && !"null".equals(array[i])) {
                Node right = new Node(array[i]);
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }
        return root;
    }


    private static void Middle_Print(Node parent, List<String> list) {
        if(parent == null || "null".equals(parent.value)) return;
        Middle_Print(parent.left, list);
        list.add(parent.value);
        Middle_Print(parent.right, list);
    }
     

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().trim().split(",");
        Node root = buildTree(array);
        List<String> list = new ArrayList<>();
        Middle_Print(root, list);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if(i < list.size() - 1) 
                System.out.print(",");
        }
    }

}
