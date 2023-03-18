package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 * 给定⼀个⻓为 n 的序列 A，其中序列中的元素都是 0~9 之间的整数，对于⼀个⻓度同样为 n 整数序列B
   ，定义其权值为 |A_i-B_i| (1<=i<=n) 之和加上 (B_j-B_j+1)^2 (1<=j<n) 之和。
   求所有⻓为 n 的整数序列中，权值最⼩的序列的权值是多少。

 输入描述

 第⼀⾏⼀个整数 n (1<=n<=10^5)，表⽰序列 A 的⻓度。
 第⼆⾏ n 个整数 a1, a2, …, an (0<=ai<=9, 1<=i<=n)，表⽰序列 A 中的元素。

 A 数组是 [1 4 2 8 5 7]
 B 数组可以是 [3 4 4 5 5 6]。
 权值为 |A_i - B_i| (1<=i<=n) 之和加上 (B_j - B_j+1)^2 (1<= j <n) 之和。
 权值第⼀部分|A_i - B_i| (1<=i<=n)之和为：
 |1 - 3| + |4 - 4| + |2 - 4| + |8 - 5| + |5 - 5| + |7 - 6| = 2 + 0 + 2 + 3 + 0 + 1 = 8
 权值第⼆部分(B_j - B_j+1)^2 (1<= j <n) 之和为：
 (3 - 4)^2 + (4 - 4)^2 + (4 - 5)^2 + (5 - 5)^2 + (5 - 6)^2 = 1 + 0 + 1 + 0 + 1 = 3
 所以总权值为 8 + 3 = 11。
 * Author hao
 * Date 2023/3/16 16:26
 */
public class Dp_2020_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始接收键盘输入");
        int n = scanner.nextInt();
        int[] arrA = new int[n];
        int index = 0;
        while (scanner.hasNext()){
            arrA[index++] = scanner.nextInt();
        }
        System.out.println(processDp(n,arrA));
    }

    /*
     * @Description //TODO
     * @Date 17:18 2023/3/16
     * @param n
     * @param a  数组A
     * @return int
     **/
    private static int processDp(int n, int[] arrA){
        //dp数组，n*n
        //dp[i][i]表示长度同时为i的arrA与arrB的最小权值.二维数组只要对角线有意义
        //一维数组就够了
        int[] dp = new int[n];
        int[] arrB = new int[n];
        int min = Integer.MAX_VALUE;
        //同时确定dp[0] 与B[0]  dp[1] 与B[1]
        for (int i = 0; i < 10; i++) {
            //i来确定B【0】，j来确定B【1】
            for (int j = 0; j < 10; j++) {
                int weight = Math.abs(arrA[0] - i) + (i - j)*(i-j) + Math.abs(arrA[1] - j);
                System.out.println("weight="+weight+"  i="+i+"  j="+j);
                if (weight<=min){
                    System.out.println("min由"+min+"更新为"+weight);
                    min = weight;
                    arrB[0] = i;
                    arrB[1] = j;
                }
            }
        }

        dp[1]=min;
        min = Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 10; j++) { //确定B[i]的取值 j
                //对于每个新来的B【i】而言，它所添加的weight由两项构成
                int weight = Math.abs(arrA[i] - j) + (arrB[i-1] - j)*(arrB[i-1] - j) ;
                if (weight<min){
                    System.out.println("min由"+min+"更新为"+weight);
                    min=weight;
                    arrB[i] = j;
                }
            }
            dp[i]=dp[i-1]+min;
            //确定出来了B[i] . 继续确定B[i+1]
            min = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(arrB[i]+"  ");
        }
        return dp[n-1];
    }

}
