package Search_Tree;

import java.util.*;
/*
 * 判断是否是二叉搜索树
 * 左边叶节点比中间节点小，右边节点比中间大
 * 返回 true or false.
 * 
 * 例如:
 * 20,null,40,34,70,21,null,55,78
 * return true.  
 */



 class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public boolean leftSet;
    public boolean rightset;
    TreeNode(int val) {
        this.val = val;
    }
 }


public class Main {


    public static boolean checkbfs(TreeNode root) {
        return checkbfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkbfs(TreeNode node, int min, int max) {

        if(node == null) {
            return true;
        }

        if(node.val < min || node.val > max) {
            return false;
        }

        return checkbfs(node.left, min, node.val) && checkbfs(node.right, node.val, max);
    }


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(",");
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        for(int i = 1; i < input.length; i++) {

            TreeNode parent = queue.peek();
            TreeNode node = null;

            if(!input[i].equals("null")) {
                node = new TreeNode(Integer.parseInt(input[i]));
            }

            if(!parent.leftSet) {
                parent.left = node;
                parent.leftSet = true;
            } else if(!parent.rightset) {
                parent.right = node;
                parent.rightset = true;
            }

            if(parent.leftSet && parent.rightset) {
                queue.poll();
            }

            if(node != null) {
                queue.offer(node);
            }
        }

        boolean result = checkbfs(root);
        System.out.println(result);
    }


    
}
