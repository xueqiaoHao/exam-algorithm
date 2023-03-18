package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 * 有2*n 的地板，用1*2和 2*1 的骨牌进行铺地板。
 问共有多少种情况。结果对 999983 取余，1<=n<=10000
 输入：
 6
 输出：
 13
 * Author hao
 * Date 2023/3/16 14:53
 */
public class Dp_2018_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始接收键盘输入");
        System.out.println(processDp(scanner.nextInt()));
    }

    private static int processDp(int n){
        //对于n的取值要分奇偶讨论
        int[] dp =new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%999983;
        }
        return dp[n];
    }
}
