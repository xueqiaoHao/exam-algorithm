package dp_02_carl;

/**
 * @Description TODO 01背包问题基础理论篇
 * @Author hao
 * @Date 2023/2/11 11:10
 */
public class Code09_01BagProblemBasic {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(bagProblem(weight, value, bagSize));
        testWeightBagProblem(weight, value, bagSize);
    }

    /**
     * @param weight  代表物品重量的数组
     * @param value   代表各个物品价值的数组
     * @param bagSize 背包容量
     * @return int
     * @Description //TODO
     * @Date 11:13 2023/2/11
     **/
    private static int bagProblem(int[] weight, int[] value, int bagSize) {
        //定义二维dp数组，行代表物品，列代表当前容量0~bagSize。值为可容纳物品的最大价值
        int wl = weight.length;
        //dp数组初始化
        int[][] dp = new int[wl][bagSize + 1];
        //第0列都是0.啥也装不下,满足初始化，无需更改
        //第0行，比weight[0]大的元素才需要更改内容
        for (int i = weight[0]; i <= bagSize; i++) {
            dp[0][i] = value[0];
        }
        //dp[i][j]位置的元素的值为 dp[i-1][j](不选择第i个元素)
        // 和dp[i-1][j-weight[i]]+value[i](选择第i个元素)的中大的一个
        //先遍历个数，再遍历容量
        for (int i = 1; i < wl; i++) {
            for (int j = 1; j <= bagSize; j++) {
                //完全装不下这个
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < wl; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[wl - 1][bagSize];
    }

    /**
     * 动态规划获得结果-Carl版本
     *
     * @param weight  物品的重量
     * @param value   物品的价值
     * @param bagSize 背包的容量
     */
    private static void testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组
        // 创建数组后，其中默认的值就是0
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i]) {
                    /*
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {
                    /*
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i
                     *    2、放物品i
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(dp[goods - 1][bagSize]);
//        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
