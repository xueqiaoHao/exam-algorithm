package com.course.dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/10 10:40
 */
public class Code07_IntegerBreak {
    public int integerBreak(int n) {
        return dp(n);
    }
    private int dp(int n){
        //确定dp数组的含义，dp[i]表示i可获得的最大值
        int[] dp=new int[n+1];
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i-1; j++) {
                dp[i]=Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
