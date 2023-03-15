package dp_01;


public class Code01_RobotMove {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        System.out.println(ways3(5, 2, 4, 6));
//        System.out.println(moveWay_1(2, 20, 15, 500));
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        long spend = endTime - startTime;
        System.out.println("耗时--" + spend);

    }

    private static int moveWay_1(int cur, int rest, int K, int N) {
        if (rest == 0) {
            return cur == K ? 1 : 0;
        }
        if (cur == 1) {
            return moveWay_1(2, rest - 1, K, N);
        }
        if (cur == N) {
            return moveWay_1(N - 1, rest - 1, K, N);
        }
        return moveWay_1(cur + 1, rest - 1, K, N) + moveWay_1(cur - 1, rest - 1, K, N);
    }

    private static int moveWayCache(int cur, int rest, int K, int N) {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++)
                dp[i][j] = -1;
        }
        return moveWay_2(cur,rest,K,N,dp);
    }

    //傻瓜式缓存表，传入缓存表dp
    private static int moveWay_2(int cur, int rest, int K, int N, int[][] dp) {
        System.out.println(cur+" "+rest);
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        } else {
            int ans;
            if (rest == 0) {
                ans = cur == K ? 1 : 0;
            } else if (cur == 1) {
                ans = moveWay_1(2, rest - 1, K, N);
            } else if (cur == N) {
                ans = moveWay_1(N - 1, rest - 1, K, N);
            } else {
                ans = moveWay_1(cur + 1, rest - 1, K, N) + moveWay_1(cur - 1, rest - 1, K, N);
            }
            dp[cur][rest] = ans;
            return ans;
        }
    }
    //根据以来关系来确定
    private static int ways3(int N,int start,int aim,int K){
        if (N < 2 || start < 1 || start > N || aim < 1 || aim > N || K < 1) {
            return -1;
        }
        int[][] dp = new int[N + 1][K + 1];
        dp[aim][0] = 1;
        for(int rest=1;rest<=K;rest++){
            dp[1][rest]=dp[2][rest-1];
            for (int cur=2;cur<N;cur++){
                dp[cur][rest]=dp[cur-1][rest-1] + dp[cur+1][rest-1];
            }
            dp[N][rest]=dp[N-1][rest-1];
        }
        return dp[start][K];
    }

}
