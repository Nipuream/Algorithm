# 二叉树的右视图

给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

LeetCode 199.

```java
class Solution {

    private List<Integer> res = new ArrayList<>();

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (res.size() == depth) {
            res.add(node.val);
        }
        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return res;
    }
}
```