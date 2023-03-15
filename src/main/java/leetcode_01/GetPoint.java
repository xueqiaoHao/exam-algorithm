package leetcode_01;

/**
 * @Description TODO
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
 * 之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * @Author hao
 * @Date 2023/2/6 10:24
 */
public class GetPoint {



    /**
     * @Description //TODO 将所有数值相同的数统一收集计数，比它大一小一的数不能被选中，类似打家劫舍
     * @Date 21:37 2023/2/6
     * @param nums 初始nums数组
     * @return int 最终结果
     **/
    private static int process(int[] nums){
        if (nums.length==0){
            return 0;
        }
        int maxValue=0;
        for (int val:nums
             ) {
            maxValue=Math.max(val,maxValue);
        }
        int[] sum=new int[maxValue+1];
        for (int val:nums
             ) {
            sum[val]+=val;
        }
        return rob(sum);
    }
    /**
     * @Description //TODO 打家劫舍直接copy一下就ok了
     * @Date 21:45 2023/2/6
     * @param nums  已结果为下标的数组
     * @return int
     **/
    private static int rob(int[] nums){
        int size = nums.length;
        //第i个元素的之前两个元素
        int first=nums[0];
        //第i个元素的前一个元素
        int second=Math.max(nums[0],nums[1]);
        for (int i = 2; i <size ; i++) {
            int temp=second;
            second=Math.max(nums[i]+first,temp);
            first=temp;
        }
        return second;
    }
}
