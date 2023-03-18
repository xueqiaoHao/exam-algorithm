package fdu.tree;

import org.junit.Test;

import java.util.*;

/**
 * Description  TODO 【2014-3】二叉树前中后序遍历
 题目描述：
 输入一棵二叉树，输出树的前、中、后序遍历结果。
 输入一个整数N（N<= 10000)，表示树中有N个结点（编号0~N-1）。
 接下来N行，依次为结点0~结点N-1的左右孩子情况。
 每行3个整数，F,L,R。L,R为F的左右孩子。L,R如果为-1表示该位置上没有孩子。
 分三行分别输出树的前中后序遍历。
 同一行中的数字，用一个空格间隔。
 输入：
 5
 0 3 1
 1 2 -1
 2 -1 4
 3 -1 -1
 4 -1 -1
 输出：
 0 3 1 2 4
 3 0 2 4 1
 3 4 2 1 0
 * Author hao
 * Date 2023/3/17 16:04
 */
public class Tree_2014_3 {
    //用map来存储val与node的关系，方便定位
    private Map<Integer,TreeNode> map =  new HashMap<>();
    //三个list分别存储前中后序的遍历
    private List<Integer> preList = new ArrayList<>();
    private List<Integer> inList = new ArrayList<>();
    private List<Integer> postList = new ArrayList<>();
    /*
     * @Description //TODO  1、读取输入来建树  2、分别遍历
     * @Date 16:16 2023/3/17


     **/
    @Test
    public void process(){
        //先读取输入来进行建树
        Scanner scanner = new Scanner(System.in);
        //结点总数，也即输入的行数
        int n = scanner.nextInt();
        //先将第一行读出并记录对应值进map
        int rootVal = scanner.nextInt();
        //每行输入的第一个元素为根节点，且不为空   构造前两行，并计入map
        TreeNode root = new TreeNode(rootVal);
        int leftVal = scanner.nextInt();
        TreeNode left = new TreeNode(leftVal);
        map.put(leftVal,left);
        root.left = left;
        int rightVal = scanner.nextInt();
        TreeNode right = new TreeNode(rightVal);
        map.put(rightVal,right);
        root.right = right;

        //每行三个字符
        for (int i = 1; i < n; i++) {
            //这里出现的第一个字符都是之前出现过的值，直接根据值拿到对应的TreeNode结点
            TreeNode node = map.get(scanner.nextInt());
            //判断输入的元素是否为-1，即对应位置是否为空
            int valLeft = scanner.nextInt();
            int valRight = scanner.nextInt();
            if (valLeft!=-1){
                TreeNode nodeLeft = new TreeNode(valLeft);
                map.put(valLeft,nodeLeft);
                node.left = nodeLeft;
            }
            if (valRight!=-1){
                TreeNode nodeRight = new TreeNode(valRight);
                map.put(valRight,nodeRight);
                node.right = nodeRight;
            }
        }
        //建树结束
        scanner.close();
        //开始三次遍历
        preOrder(root);
        inOrder(root);
        postOrder(root);
        //打印数组
        printList(preList);
        printList(inList);
        printList(postList);

    }

    /*
     * @Description //TODO 前序遍历  中左右
     * @Date 17:37 2023/3/17
     * @param root

     **/
    private void preOrder(TreeNode root){
        if (root==null){
            return;
        }
        preList.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    /*
     * @Description //TODO 中序遍历  左中右
     * @Date 17:39 2023/3/17
     * @param root

     **/
    private void inOrder(TreeNode root){
        if (root==null){
            return;
        }
        inOrder(root.left);
        inList.add(root.val);
        inOrder(root.right);
    }

    /*
     * @Description //TODO  后序遍历，左右中
     * @Date 17:40 2023/3/17
     * @param root

     **/
    private void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        postList.add(root.val);
    }

    /*
     * @Description //TODO 负责打印list数组
     * @Date 17:42 2023/3/17
     * @param list

     **/
    private void printList(List<Integer> list){
        for (int ele:list
             ) {
            System.out.print(ele+" ");
        }
        System.out.println();
    }

}
