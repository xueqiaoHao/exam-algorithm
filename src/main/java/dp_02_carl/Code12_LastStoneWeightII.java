package dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/13 10:55
 */
public class Code12_LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        return process(stones);
    }
    public int process(int[] stones){
        if(stones.length==0){
            return 0;
        }
        int len=stones.length;
        int sum=0;
        for(int num:stones){
            sum+=num;
        }
        //二分之一向下取整
        int target=sum/2;
        //定义dp数组，若dp[target]为容量为target的背包所能装的最大容量。装满最好，不满越多越好
        int[] dp=new int[target+1];
        //一维数组要从后向前遍历
        for(int i=0;i<len;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-2*dp[target];
    }
}
