#  二叉搜索树中第 K 小的元素


给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 小的元素（从 1 开始计数）。

Leetcode 230


1) 使用优先队列

```java
class Solution {

    PriorityQueue<TreeNode> queue = new PriorityQueue<>((a, b) -> {return a.val - b.val;});

    private void dfs(TreeNode node) {
        if (node == null) return;
        queue.offer(node);
        dfs(node.left);
        dfs(node.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        while (k-- > 1) {
            queue.poll();
        }
        TreeNode min = queue.peek();
        return min.val;
    }
}
```

2) 二叉树的中序遍历是递增序列

```java
class Solution {
    int res, k;
    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (k == 0) return;
        if (--k == 0) res = root.val;
        dfs(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
}
```

