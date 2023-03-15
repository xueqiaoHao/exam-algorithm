package com.course.dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/18 22:21
 */
class TreeNode {
    private int val;
    final ThreadLocal<TreeNode> left = new ThreadLocal<TreeNode>();
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left.set(left);
        this.right = right;
    }
}
