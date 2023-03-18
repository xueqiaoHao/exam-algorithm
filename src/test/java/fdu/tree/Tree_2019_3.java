package fdu.tree;

import org.junit.Test;

import java.util.Scanner;

/**
 * Description  TODO
 * 题目3：有向树的行态
 求N个结点能够组成的二叉树的个数。 1<=n<=20
 输入样例3，输出样例5
 * Author hao
 * Date 2023/3/17 18:04
 */
public class Tree_2019_3 {
    @Test
    public void process(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(getDistinctNum(n));
    }

    /*
     * @Description //TODO
     * @Date 18:12 2023/3/17
     * @param n
     * @return int
     **/
    private int getDistinctNum(int n){
        //n个结点的二叉树种类，是n-1个结点的二叉树推来的
        int[] dp = new int[n+1];
        dp[0] =1;
        dp[1] =1;
        //统计n-1个结点中左右子树为空的位置总数。并在最后＋1来表示可在根节点上方插入
        //n个结点有n+2个满足可插入的空指针
        for (int i = 2; i < n+1; i++) {
            //每次传进来的i用作顶点，左边可以有0~i-1个顶点，对应右侧一样
            for (int j = 0; j < i; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
