# 二叉树的直径

Leetcode 543.

```java
class Solution {

    private int ans = 0;

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans = Math.max(ans, L + R);
        return Math.max(L, R) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }
}
```