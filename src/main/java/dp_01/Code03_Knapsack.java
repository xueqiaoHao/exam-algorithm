package dp_01;

/**
 * @Description TODO 背包问题
 * @Author hao
 * @Date ${DATE} ${TIME}
 */
public class Code03_Knapsack {


    /**
     * @param w   数组表示所有货物的重量
     * @param v   表示所有货物的价值
     * @param bag 背包的总容量，重量
     * @return int 可装货物最大价值
     * @Description //TODO 获取背包可装货物的最大价值
     * @Date 13:54 2023/2/1
     **/
    private static int getKnapsack_v1(int[] w, int[] v, int bag) {
        if (bag == 0 || w.length == 0 || v.length == 0 || w.length != v.length) {
            return 0;
        }
        //尝试函数
        return process1(w, v, 0, bag);
    }

    /**
     * @param w     数组表示所有货物的重量
     * @param v     表示所有货物的价值
     * @param index 当前位置，向后选择货物，所选择的不能超过货物总数的下标
     * @param rest   背包的当前容量
     * @return int 返回可选择的最大容量
     * @Description //TODO 从当前位置开始向后可获得的
     * @Date 13:57 2023/2/1
     **/
    private static int process1(int[] w, int[] v, int index, int rest) {
        //背包容量大小为0时，可能存在重量为0的货物，可以供选择
        //返回-1，说明上层的选择错误，不可选择
        if (rest < 0) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }

        //bag>=0背包还有容量,且还有货物
        //不选择当前货物
        int p1 = process1(w, v, index + 1, rest);
        //选择当前的货物
        int p2 = 0;
        int flag = process1(w, v, index + 1, rest - w[index]);
        //可进行选择
        if (flag != -1) {
            p2 = v[index] + flag;
        }
        return Math.max(p1, p2);
    }

    /**
     * @param w   数组表示所有货物的重量
     * @param v   表示所有货物的价值
     * @param bag 背包的总容量，重量
     * @return int 可装货物最大价值
     * @Description //TODO 获取背包可装货物的最大价值。
     * //TODO 优化版本。利用二维数组dp存储已有的递归数据，以达到递归次数
     * @Date 13:54 2023/2/1
     **/
    private static int getKnapsack_v2(int[] w, int[] v, int bag) {
        if (bag == 0 || w.length == 0 || v.length == 0 || w.length != v.length) {
            return 0;
        }
        int N=w.length;
        //index从0~N
        //rest 0~bag
        int[][] dp=new int[N+1][bag+1];
        //尝试函数
        return process2(w, v, 0, bag,dp);
    }

    /**
     * @param w     数组表示所有货物的重量
     * @param v     表示所有货物的价值
     * @param index 当前位置，向后选择货物，所选择的不能超过货物总数的下标
     * @param rest   背包的当前容量
     * @param dp   存储已有信息二维数组dp表,傻缓存
     * @return int 返回可选择的最大容量
     * @Description //TODO 从当前位置开始向后可获得的
     * @Date 13:57 2023/2/1
     **/
    private static int process2(int[] w, int[] v, int index, int rest,int[][] dp) {
        //背包容量大小为0时，可能存在重量为0的货物，可以供选择
        //返回-1，说明上层的选择错误，不可选择
        if (rest < 0) {
            return -1;
        }

        if (index == w.length) {
            return 0;
        }
        if (dp[index][rest]!=0){
            return dp[index][rest];
        }else {
            int value;
            //bag>=0背包还有容量,且还有货物
            //不选择当前货物
            int p1 = process2(w, v, index + 1, rest,dp);
            //选择当前的货物
            int p2 = 0;
            int flag = process2(w, v, index + 1, rest - w[index],dp);
            //可进行选择
            if (flag != -1) {
                p2 = v[index] + flag;
            }
            value=Math.max(p1, p2);
            dp[index][rest]=value;
            return value;
        }
    }
    /**
     * @param w   数组表示所有货物的重量
     * @param v   表示所有货物的价值
     * @param bag 背包的总容量，重量
     * @return int 可装货物最大价值
     * @Description //TODO 获取背包可装货物的最大价值。
     * //TODO 优化版本。列出动态规划的递推dp表
     * @Date 13:54 2023/2/1
     **/
    private static int getKnapsack_v3_dp(int[] w, int[] v, int bag) {
        if (bag == 0 || w.length == 0 || v.length == 0 || w.length != v.length) {
            return 0;
        }
        int N=w.length;
        //index从0~N
        //rest 0~bag
        int[][] dp=new int[N+1][bag+1];
        //尝试函数
        for (int index=N-1;index>=0;index--){
            for (int rest=0;rest<=bag;rest++){

                int p1=dp[index+1][rest];

                //选择当前的货物
                int p2 = 0;
                int next=rest-w[index]<0?-1:dp[index+1][rest-w[index]];
                //可进行选择
                if (next != -1) {
                    p2 = v[index] + next;
                }
                dp[index][rest]=Math.max(p1,p2);
            }
        }
        return dp[0][bag];
    }

    public static void main(String[] args) {
        int[] w = {3, 2, 4, 7,3,1,7};
        int[] v = {5, 6, 3, 19,12,4,2};
        int bag = 15;
        long startTime = System.currentTimeMillis();
        System.out.println(getKnapsack_v1(w, v, bag));
        System.out.println(getKnapsack_v2(w, v, bag));
        System.out.println(getKnapsack_v3_dp(w, v, bag));

        long endTime = System.currentTimeMillis();
        long spend = endTime - startTime;
        System.out.println("耗时--" + spend);
    }
}
