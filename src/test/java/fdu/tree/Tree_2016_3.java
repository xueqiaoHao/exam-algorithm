package fdu.tree;

import org.junit.Test;

import java.util.*;

/**
 * Description  TODO 第三题 是给定一个字符串，求哈夫曼编码的最短长度：
 * 输入样例：
 aaaaabbbbcccdde
 输出样例：
 33
 * Author hao
 * Date 2023/3/18 16:49
 */
public class Tree_2016_3 {

//    public static void main(String[] args){
//        Map<String,Integer> map = new HashMap<>();
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder builder = new StringBuilder();
//        while (scanner.hasNext()){
//            builder.append(scanner.next());
//        }
//        String[] strings = builder.toString().split("");
//        //计入map统计频次
//        for (String s:strings
//             ) {
//            map.put(s,map.containsKey(s)?(map.get(s)+1):1);
//        }
//        //根据map建立优先队列
//        PriorityQueue<Integer> pq= new PriorityQueue<>(
//                (o1, o2) -> o1-o2
//        );
//        for (Map.Entry<String,Integer> entry: map.entrySet()
//             ) {
//            pq.offer(entry.getValue());
//        }
//        //根据优先队列来创建二叉树
//        TreeNode left = new TreeNode(pq.poll());
//        TreeNode right = new TreeNode(pq.poll());
//        TreeNode node = new TreeNode();
//        node.left = left;
//        node.right = right;
//        TreeNode root =node ;
//        //只要规定好空结点放哪侧，后面都统一放置就行了
//        while (!pq.isEmpty()){
//            //统一放在右侧
//            TreeNode tmpLeft = new TreeNode(pq.poll());
//            TreeNode tmpRoot = new TreeNode();
//            tmpRoot.left = tmpLeft;
//            tmpRoot.right = root;
//            tmpLeft.val = tmpLeft.val+tmpRoot.right.val;
//            root = tmpRoot;
//        }
//        //建树完成
//        //开始统计哈夫曼结果值
//        System.out.println(countResult(root,0));
//    }

    public static void main(String[] args){
        Map<String,Integer> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNext()){
            builder.append(scanner.next());
        }
        String[] strings = builder.toString().split("");
        //计入map统计频次
        for (String s:strings
                ) {
            map.put(s,map.containsKey(s)?(map.get(s)+1):1);
        }
        //根据map建立优先队列
        PriorityQueue<TreeNode> pq= new PriorityQueue<>(
                Comparator.comparingInt(o -> o.val)
        );
        for (Map.Entry<String,Integer> entry: map.entrySet()
                ) {
            pq.offer(new TreeNode(entry.getValue()));
        }
        //根据优先队列来创建二叉树
        TreeNode left = pq.poll();
        TreeNode right = pq.poll();
        TreeNode node = new TreeNode(left,right,left.val+right.val);
//        node.left = left;
//        node.right = right;
        pq.offer(node);
        //只要规定好空结点放哪侧，后面都统一放置就行了   队列中元素个数等于1 的时候，建树完成，剩下的就是根节点
        while (pq.size()>1){
            //统一放在右侧
            //每次取出最上面的两个结点，放在左右两侧，可以保证每次取到的都是最小的两个结点
            TreeNode tmpLeft = pq.poll();
            TreeNode tmpRight = pq.poll();
//            TreeNode tmpRoot = new TreeNode();
//            tmpRoot.left = tmpLeft;
//            tmpRoot.right = tmpRight;
//            tmpRoot.val = tmpLeft.val+tmpRoot.right.val;
            pq.offer(new TreeNode(tmpLeft,tmpRight,tmpLeft.val+tmpRight.val));
        }
        //建树完成
        //开始统计哈夫曼结果值
        System.out.println(countResult(pq.poll(),0));
    }
    private static int countResult(TreeNode root,int depth){
        if (root==null){
            return 0;
        }
        if (root.left==null&&root.right==null){
                return root.val*depth;
        }
        int left = countResult(root.left, depth + 1);
        int right = countResult(root.right,depth+1);
        return  left + right;
    }
}
