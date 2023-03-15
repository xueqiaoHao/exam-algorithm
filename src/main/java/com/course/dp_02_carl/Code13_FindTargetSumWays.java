package com.course.dp_02_carl;

/**
 * @Description TODO https://leetcode.cn/problems/target-sum/
 * @Author hao
 * @Date 2023/2/13 10:56
 */
public class Code13_FindTargetSumWays {

    public static void main(String[] args) {
        int[] nums = {1, 0};
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));
        System.out.println("=====");
        System.out.println(process_dp_v2(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
        return process_dp_v1(nums, target);
    }

    /**
     * @param nums
     * @param target
     * @return int
     * @Description //TODO v1二维数组dp版本
     * @Date 11:45 2023/2/13
     **/
    private static int process_dp_v1(int[] nums, int target) {
        //取负号的放在一起，绝对值为neg
        //取正号的放在一起，为sum-neg
        int len = nums.length;
        int sum = 0;
        for (int num : nums
                ) {
            sum += num;
        }
        //target应该是正号的绝对值之和减去负号的绝对值之和 target=sum-2*neg

        //否则定义dp数组,行为所有元素，列为目标和。dp[i][j]为统计出来的前i个元素中，目标和为j的方法数
        int neg = (sum - target) / 2;
        //neg是所有取负号元素的绝对值之和了，所以要求neg必须为正
        //target已知，求neg=(sum-target)/2;
        if ((sum - target) % 2 != 0 || neg < 0) {
            return 0;
        }
        int[][] dp = new int[len + 1][neg + 1];
        dp[0][0] = 1;
        //放或者不放有两种方式
        // 第一种放不下便不放，j<nums[i]，dp[i][j]=dp[i-1][j]
        //第二种，放的下，放与不放的方法数加一起，dp[i][j]=dp[i-1][j]+dp[i-1][j-num[i]]
        for (int i = 1; i < len + 1; i++) {
            for (int j = 0; j < neg + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for (int i = 0; i < len + 1; i++) {
            for (int j = 0; j < neg + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[len][neg];
    }

    /**
     * @param nums   数组
     * @param target 目标值
     * @return int
     * @Description //TODO 滚动数组模式解决
     * @Date 12:02 2023/2/13
     **/
    private static int process_dp_v2(int[] nums, int target) {
        int sum = 0;
        for (int num : nums
                ) {
            sum += num;
        }
        int neg = (sum - target) / 2;
        if (neg < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = neg; j >= 0; j--) {
                dp[j] = dp[j];
                if (j >= nums[i - 1]) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        return dp[neg];
    }
}
