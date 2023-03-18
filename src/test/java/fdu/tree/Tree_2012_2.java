package fdu.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description  TODO  二叉树最大叶子间距
 * 二叉树问题。比如节点是ABCDE编号是01234，给出每个左右子树的编号。求最大叶子间距。
 输入样例1

 3
 1 2
 -1 -1
 -1 -1
 输出样例1：

 2

 1 2 3  4  5  6  7
 3 1 2 -1 -1 -1 -1
 输入样例2

 6
 1 -1
 2 3
 4 -1
 -1 5
 -1 -1
 -1 -1
 输出样例2：

 4
 1 2  3 4 5 6  7  8 9  11 12 13 14
 6 1 -1 2 3 4 -1 -1 5 -1 -1 -1 -1
 * Author hao
 * Date 2023/3/17 12:30
 */
public class Tree_2012_2 {

    private int maxDis = 0;
    /*
     * @Description //TODO  一边读控制台输入，一边建树
     * @Date 16:31 2023/3/17
     **/
    @Test
    public void process(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("start input ======");
        //控制台读入的第一个树是根节点
        TreeNode root = new TreeNode(scanner.nextInt());
        //使用辅助队列，边读入边建树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()&&scanner.hasNext()){
            TreeNode node = queue.poll();
            int leftVal = scanner.nextInt();
            if (leftVal!=-1){
                node.left = new TreeNode(leftVal);
                queue.offer(node.left);
            }
            int rightVal = scanner.nextInt();
            if (rightVal!=-1){
                node.right = new TreeNode(rightVal);
                queue.offer(node.right);
            }
        }
        //完成建树，求最大叶子间距
        getMaxDis(root);
        System.out.println(maxDis);
    }

    /*
     * @Description //TODO 求最大深度要从下往上走，所以左右中，后序遍历
     * @Date 16:47 2023/3/17
     * @param root
     * @return int 因为要求出所有结点中左右子树的深度和的最大值，所以必须有返回值，用作比较。
     * 若求最大深度，则不用返回值
     **/
    private int getMaxDis(TreeNode root){
        //递归终止
        if (root==null){
            return 0;
        }
        int leftDep = getMaxDis(root.left);
        int rightDep = getMaxDis(root.right);
        //最大树深度
        maxDis = Math.max(leftDep+rightDep, maxDis);
        return Math.max(leftDep,rightDep)+1;
    }
}
