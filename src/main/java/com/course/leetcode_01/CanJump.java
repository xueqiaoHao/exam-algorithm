package com.course.leetcode_01;

/**
 * @Description TODO
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * @Author hao
 * @Date 2023/2/6 22:35
 */
public class CanJump {

    public static void main(String[] args) {
        int[] nums={8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5};
        System.out.println(canJump(nums));
    }
    /**
     * @Description //TODO 存在相加之和>=N的组合，即为成功
     * @Date 22:54 2023/2/6
     * @param nums  初始数组
     * @return boolean
     **/
    private static boolean canJump(int[] nums) {
        if (nums.length==0||nums.length==1){
            return true;
        }
        int N=nums.length;
        int result= jumpWays(nums,0,N-1);
        return result != 0;
    }
    private static int jumpWays(int[] nums, int i, int N){
        if (i>=N){
            return 1;
        }
        //走到了下标为0的位置了，以此处为出发点了，那就失败了
        if (nums[i]==0){
            return 0;
        }
        int result=0;
        int val=nums[i];
        for (int j = 1; j <=val ; j++) {
            result+=jumpWays(nums,i+j,N);
        }
        return result;
    }
    /**
     * @Description //TODO 此处都是长度大于一的nums
     * @Date 23:22 2023/2/6
     * @param nums  待处理数组
     * @return int
     **/
    private static int dp(int[] nums,int N){
        int[] dp=new int[N];
        dp[N-1]=1;
        for (int i = N-2; i >0 ; i--) {
            int temp=nums[i];

        }

        return dp[0];
    }
}
