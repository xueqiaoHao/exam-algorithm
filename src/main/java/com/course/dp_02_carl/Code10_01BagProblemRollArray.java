package com.course.dp_02_carl;

/**
 * @Description TODO 一维滚动数组实现0/1背包问题
 * @Author hao
 * @Date 2023/2/11 12:41
 */
public class Code10_01BagProblemRollArray {

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        System.out.println(bagProblemRollArray(weight, value, bagSize));
        testWeightBagProblem(weight,value,bagSize);
    }
    /**
     * @Description //TODO 滚动数组解决，从后向前遍历
     * @Date 12:45 2023/2/11
     * @param weight 重量数组
     * @param value 价值数组
     * @param bagSize  背包容量
     * @return int
     **/
    private static int bagProblemRollArray(int[] weight, int[] value, int bagSize) {
        int goods=weight.length;
        int[] dp=new int[bagSize+1];
        for (int i = 0; i < goods; i++) {
            //从后向前遍历
            for (int j = bagSize; j >= weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        for (int i = 0; i <= bagSize; i++) {
            System.out.println("dp["+i+"]="+dp[i]+"\t");
        }
        return dp[bagSize];
    }

    /**
     * @Description //TODO 01背包滚动数组-Carl版本
     * @Date 12:50 2023/2/11
     * @param weight
     * @param value
     * @param bagWeight

     **/
    public static void testWeightBagProblem(int[] weight, int[] value, int bagWeight){
        int wLen = weight.length;
        //定义dp数组：dp[j]表示背包容量为j时，能获得的最大价值
        int[] dp = new int[bagWeight + 1];
        //遍历顺序：先遍历物品，再遍历背包容量
        for (int i = 0; i < wLen; i++){
            for (int j = bagWeight; j >= weight[i]; j--){
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.print(dp[j] + " ");
        }
    }
}