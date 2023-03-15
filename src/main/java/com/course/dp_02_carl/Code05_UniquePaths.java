package com.course.dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/9 14:22
 */
public class Code05_UniquePaths {
    public static void main(String[] args) {

    }
    public int uniquePaths(int m, int n) {
        //想成二维数组，从dp[1][1]到dp[m][n]
        return process1_dfs(1,1,m,n);
    }
    private int process1_dfs(int i, int j, int m, int n){
        if (i>m||j>n){
            return 0;
        }
        //找到了一种方法
        if (i==m&&j==n){
            return 1;
        }
        return process1_dfs(i+1,j,m,n)+ process1_dfs(i,j+1,m,n);
    }
    private int process2_dp(int m,int n){
        int[][] dp=new int[m][n];
        //滤清依赖关系，dp[i][j]由dp[i-1][j]和dp[i][j-1]而来，只能来自这两个方向
        //dp[i][0]和dp[0][j]都只有一种可能到达，走直线
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        //返回dp[m-1][n-1]
        return dp[m-1][n-1];
    }
}
