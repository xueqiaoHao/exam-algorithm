package com.course.dp_02_carl;

/**
 * @Description TODO 给你一个 只包含正整数 的 非空 数组 nums 。
 * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * @Author hao
 * @Date 2023/2/11 13:10
 */
public class Code11_CanPartition {
    /**
     * @Description //TODO 翻译成重量全部是1，value各不相等的背包问题
     * @Date 13:10 2023/2/11
     * @param nums 数组
     * @return boolean
     **/
    public boolean canPartition(int[] nums) {
        return process(nums);
    }
    /**
     更改思考方式为求和问题，若总和是偶数，则可能存在两个子集合和相等
     */
    public boolean process(int[] nums){
        if(nums.length==0){
            return false;
        }
        int len=nums.length;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        //和为奇数，一定不存在
        if(sum%2!=0){
            return false;
        }
        //和为偶数，可能存在，试一下
        int target=sum/2;
        //定义dp数组，若dp[target]=target则说明存在，即背包容量为半个sum的背包刚好存在被装满的情况
        //那么剩下的一半就是不相交且和相等的另一个 子集
        int[] dp=new int[target+1];
        //一维数组要从后向前遍历
        for(int i=0;i<len;i++){
            for(int j=target;j>=nums[i];j--){
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
}
