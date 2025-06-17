# 二叉搜索树

给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

有效 二叉搜索树定义如下：

节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

Leetcode 98.


思路： 二叉搜索树下沉下去，每个节点的取值都是有边界范围的。


```java
class Solution {

    private boolean dfs (TreeNode node, long L, long R) {
        if (node == null) return true;
        if (node.val <= L || node.val >= R) return false;
        return dfs(node.left, L, node.val) && dfs(node.right, node.val, R);
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
```