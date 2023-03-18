package fdu.tree;

import java.util.*;

/**
 * Description  TODO
 * 二叉树遍历
 题目描述

 输入树的中序和后序排列，输出树的层次遍历
 输入样例

 7
 1 2 3 4 5 6 7    左中右

 2 3 1 5 7 6 4    左右中
 输出样例：

 4 1 6 3 5 7 2
 * Author hao
 * Date 2023/3/17 10:36
 */
public class Tree_2011_2 {
    //存放中序数组中的value与index的对应关系
    private static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please start input ========");
        int n = scanner.nextInt();
        int[] inOrder = new int[n];
        int index = 0;
        int[] postOrder = new int[n];
        while (index<n){
            int val = scanner.nextInt();
            inOrder[index] = val;
            map.put(val,index);
            index++;
        }

        index = 0;
        while (index<n&&scanner.hasNext()){
            postOrder[index++] = scanner.nextInt();
        }
        scanner.close();
        int[] levelByTree = getLevelByTree(inOrder,n - 1, postOrder, n - 1);
        for (int le:levelByTree
             ) {
            System.out.print(le+" ");
        }
    }

    private static int[] getLevelByTree(int[] inOrder, int inEnd, int[] postOrder, int postEnd){
        int[] level = new int[inEnd+1];
        int index =0;
        TreeNode root = getTreeByInAndPost(inOrder, 0, inEnd, postOrder, 0,postEnd);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode node ;
        while (!queue.isEmpty()){
            node = queue.poll();
            level[index++]=node.val;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return level;
    }


    private static TreeNode getTreeByInAndPost(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd){
        //先根据中序和后序遍历构造二叉树，构造过程中层序遍历
        if (inStart>inEnd||postStart>postEnd){
            return null;
        }
        if (inStart==inEnd){
            return new TreeNode(inOrder[inStart]);
        }
        if(postEnd==postStart){
            return new TreeNode(postOrder[postEnd]);
        }
        //后序遍历的第一个结点为根节点
        TreeNode root = new TreeNode(postOrder[postEnd]);
        //返回的是根节点在中序遍历中的位置，以此位置分割为两颗子树
        Integer index = map.get(postOrder[postEnd]);
        //TODO 建树的左右子区间分割，要会分割表示
        root.left = getTreeByInAndPost(inOrder,inStart,index-1,postOrder,postStart,postStart+index-1-inStart);
        root.right = getTreeByInAndPost(inOrder,index+1,inEnd,postOrder,postStart+index-inStart,postEnd-1);
        return root;
    }
}
