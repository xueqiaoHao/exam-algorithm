package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 *
 给定一个数字序列A1,A2…An，求i,j(1<=i<=j<=n)，使得Ai+…+Aj最大，输出这个最大和。
 第一行输入一个整数n，表示数列大小
 第二行输入n个整数
 输入样例：6
 -2 11 -4 13 -5 -2
 输出样例：20
 类似题目
 复旦只要输出最大连续子列的值
 * Author hao
 * Date 2023/3/16 15:51
 */
public class Dp_2019_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //开始输入
        System.out.println("开始进行键盘输入");
        //第一行为数组大小n
        int n=scanner.nextInt();
        //依次读取第二行的内容进入数组
        int[] nums = new int[n];
        int index = 0;
        while (scanner.hasNext()){
            nums[index++] = scanner.nextInt();
        }
        System.out.println(processDp(n,nums));
    }

    /*
     * @Description //TODO
     * @Date 16:03 2023/3/16
     * @param nums
     * @return int
     **/
    private static int processDp(int n, int[] nums){
        //dp[i]表示到达i位置时可取得的最大值
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i]=(dp[i-1]>0)?dp[i-1]+nums[i]:nums[i];
            max=Math.max(max,dp[i]);
        }
        return max;
    }

}
