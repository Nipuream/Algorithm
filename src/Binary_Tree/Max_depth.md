# 二叉树的最大深度

```java
  public int maxDepth(TreeNode root) {
      if (root == null) return 0;
      return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
```