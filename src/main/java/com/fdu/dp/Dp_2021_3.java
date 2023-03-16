package com.fdu.dp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description  TODO
 * 给定一个非负整数序列 x1, x2, …, xn，可以给每一个整数取负数或者取原值，
 求有多少种取法使得这些整数的和等于期望值 E。请写出程序，并解释解题思路。
 输入样例
 非负整数序列为 1 1 1 1 1 3 （期望值 E 为 3）
 输出样例
 5
 输出描述：
 5 种取法分别为：
 -1+1+1+1+1 = 3
 1-1+1+1+1 = 3
 1+1-1+1+1 = 3
 1+1+1-1+1 = 3
 1+1+1+1-1 = 3
 * Author hao
 * Date 2023/3/16 20:09
 */
public class Dp_2021_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始接收键盘输入");
        int E = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNext()){
            list.add(scanner.nextInt());
        }
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i]=list.get(i);
        }
        System.out.println(process(E, nums));
    }
    /*
     * @Description //TODO  让其中一部分的元素取负值。剩余的取正值，看看那部分取负值的1有多少种取法
     * @Date 20:21 2023/3/16
     * @param E
     * @param nums
     * @return int
     **/
    public static int process(int E,int[] nums){
        //先对nums数组求和，求出总值
        int sum=0;
        for (int num:nums
             ) {
            sum+=num;
        }
        //不存在可以拼凑出的negative可能性
        if ((sum-E)%2!=0){
            return 0;
        }
        int neg = (sum-E)/2;
        //dp[i][j]  到达第i个位置的时候，元素和为j的组合数共有多少种
        int[][] dp = new int[nums.length+1][neg+1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            //取当前元素，与不取当前元素
//            dp [i] = dp[i-1];
            //加上了nums[i]后组成了neg,那么就是找neg-nums[i]位置
            for (int j = 0; j < neg+1; j++) {
                   dp[i][j]=dp[i-1][j];
                   //nums[i-1] i位置在dp中是第i个位置，在数组nums中要回收一个单位
                   if (j>=nums[i-1]){
                       dp[i][j]+=dp[i-1][j-nums[i-1]];
                   }
            }
        }
        return dp[nums.length][neg];
    }

}
