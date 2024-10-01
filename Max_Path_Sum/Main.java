package Max_Path_Sum;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
    }
}

public class Main {

    private static int ans = 0;

    private static int maxPathSum(Node node) {
        if(node == null) 
            return 0;
        int leftGain = Math.max(maxPathSum(node.left), 0);
        int rightGain = Math.max(maxPathSum(node.right), 0);
        ans = Math.max(ans, leftGain + rightGain + node.val);
        return node.val + Math.max(leftGain, rightGain);
    }
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        Queue<Node> queue = new LinkedList<>();
        
        if(input.length == 0) {
            System.out.println("0");
            return;
        }

        //build tree.
        Node root = new Node(Integer.parseInt(input[0]));
        queue.offer(root);
        
        int i = 1;
        while (i < input.length && !queue.isEmpty()) {
            Node parent = queue.poll();
            if(!"null".equals(input[i])) {
                Node left = new Node(Integer.parseInt(input[i]));
                parent.left = left;
                queue.offer(left);
            }
            i++;
            if(i < input.length && !"null".equals(input[i])) {
                Node right = new Node(Integer.parseInt(input[i]));
                parent.right = right;
                queue.offer(right);
            }
            i++;
        }

        maxPathSum(root);
        System.out.println(ans);
    }
}
