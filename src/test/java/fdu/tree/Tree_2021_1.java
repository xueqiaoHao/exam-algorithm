package fdu.tree;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * Description  TODO
 * 题目描述：给定一颗二叉树，树的每个节点的值为一个正整数。
 * 如果从根节点到节点 N 的路径上不存在比节点 N 的值大的节点，那么节点 N 被认为是树上的关键节点。
 * 求树上所有的关键节点的个数。请写出程序，并解释解题思路。
 * 输入
 * 3,1,4,3,null,1,5
 * 输出
 * 4
 * Author hao
 * Date 2023/3/17 21:08
 */
public class Tree_2021_1 {
    private int keyWordNum = 0;

    @Test
    public void process(){
        //第一步先二叉树建树
        Scanner scanner = new Scanner(System.in);
        System.out.println("start input ========");
        Queue<TreeNode> queue = new LinkedList<>();
        String line = scanner.nextLine();
        String[] strings = line.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.offer(root);
        for (int i = 1; i < strings.length; i++) {
            TreeNode node = queue.poll();
            String leftString = strings[i++];
            if (!leftString.equals("null")&&leftString.length()>0){
                int leftVal = Integer.parseInt(leftString);
                TreeNode left = new TreeNode(leftVal);
                queue.offer(left);
                node.left = left;
            }
            String rightString = strings[i];
            if (!rightString.equals("null")&&leftString.length()>0){
                int rightVal = Integer.parseInt(rightString);
                TreeNode right = new TreeNode(rightVal);
                queue.offer(right);
                node.right = right;
            }
        }
        System.out.println("建树完成======");
        //完成建树操作
        scanner.close();
        process(root,0);
        System.out.println(keyWordNum);
    }

    @Test
    public void process_backup(){
        //第一步先二叉树建树
        Scanner scanner = new Scanner(System.in);
        System.out.println("start input ========");
        Queue<TreeNode> queue = new LinkedList<>();
        String line = scanner.nextLine();
        String[] strings = line.split(",");
        TreeNode root = new TreeNode(scanner.nextInt());
        queue.offer(root);
        while (scanner.hasNext()&&!queue.isEmpty()){
            System.out.println("enter "+scanner.hasNext());
            TreeNode node = queue.poll();
            String leftString = scanner.next();
            if (!leftString.equals("null")&&leftString.length()>0){
                int leftVal = Integer.parseInt(leftString);
                TreeNode left = new TreeNode(leftVal);
                queue.offer(left);
                node.left = left;
            }
            String rightString = scanner.next();
            if (!rightString.equals("null")&&leftString.length()>0){
                int rightVal = Integer.parseInt(rightString);
                TreeNode right = new TreeNode(rightVal);
                queue.offer(right);
                node.left = right;
            }
        }
        System.out.println("建树完成======");
        //完成建树操作
        scanner.close();
        process(root,0);
        System.out.println(keyWordNum);
    }

    /*
     * @Description //TODO  统计树中关键结点的个数
     * @Date 21:26 2023/3/17
     * @param root
     * @param curMax  当前位置之前的路径中结点最大值
     * @return int
     **/
    private void process(TreeNode root,int curMax){
        if(root==null){
            return ;
        }
        //当前位置元素的大小比之前路径的所有都大，则记录个数
        if (root.val>=curMax){
            keyWordNum++;
            curMax = root.val;
        }
        process(root.left,curMax);
        process(root.right,curMax);
    }

}
