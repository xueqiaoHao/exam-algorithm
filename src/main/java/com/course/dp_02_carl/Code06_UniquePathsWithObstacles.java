package com.course.dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/9 20:49
 */
public class Code06_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return process_dp(obstacleGrid);
    }
    private int process_dp(int[][] obstacleGrid){
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        int[][] dp=new int[N][M];
        // [[0,0,0],[0,1,0],[0,0,0]]
        //还是看第一行与第一列
        for (int i = 0; i < N&&obstacleGrid[i][0]==0; i++) {
                dp[i][0]=1;
        }
        for (int j = 0; j < M&&obstacleGrid[0][j]==0; j++) {
                dp[0][j]=1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                dp[i][j]=(obstacleGrid[i][j]==0)?dp[i-1][j]+dp[i][j-1]:0;
            }
        }
        //返回dp[m-1][n-1]
        return dp[N-1][M-1];

    }
}
