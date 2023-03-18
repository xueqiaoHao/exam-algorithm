package fdu.tree;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/17 11:07
 */
public class TreeNode {
    //建树的树类
         public TreeNode left;
         public TreeNode right;
         public int val;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

         TreeNode(TreeNode left, TreeNode right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }

}
