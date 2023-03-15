package dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/10 22:11
 */
public class Code08_NumTrees {
    public int numTrees(int n) {
        return process(n);
    }
    private int process(int n){
        if (n<1){
            return 1;
        }
        //确定dp数组，dp数组是整数n对应的二叉搜索树的种数
        int[] dp=new int[n+1];
        dp[0]=1;
        // dp[1]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //j做顶点结点，以j做顶点，左侧有j个比顶点小的，右侧有i-j个
                dp[i]+=dp[j-1]*dp[i-j];
                // System.out.println("dp["+i+"]="+"dp["+j+"]="+dp[j]+"*dp["+(i-j)+"]="+dp[i-j]);
            }
            // System.out.println("dp"+i+"=>"+dp[i]);
        }
        return dp[n];
    }
}
