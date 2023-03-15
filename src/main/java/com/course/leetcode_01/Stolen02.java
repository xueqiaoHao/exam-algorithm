package com.course.leetcode_01;

/**
 * @Description TODO 打家劫舍||
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * @Author hao
 * @Date 2023/2/3 15:54
 */
public class Stolen02 {
    public static void main(String[] args) {
        int[] nums={2,3,2};
        System.out.println(process(nums));
    }

    private static int process(int[] nums){
        if (nums.length == 0){
            return 0;
        }
        int length=nums.length;
        if (length==1){
            return nums[0];
        }
        int tmp;
        int[] dp=new int[length];
        //可以人为规定让它抢与不抢nums[1]
        //不抢
        dp[0]=nums[0];
        dp[1]=nums[0];
        for (int i=2;i<length-1;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        tmp=dp[length-2];
        //抢
        dp[1]=nums[1];
        dp[2]=Math.max(nums[2],nums[1]);
        for (int i=3;i<length;i++){
            dp[i]=Math.max(nums[i]+dp[i-2],dp[i-1]);
        }
        return Math.max(tmp,dp[length-1]);
    }
}
