package dp_02_carl;

/**
 * @Description TODO  https://leetcode.cn/problems/ones-and-zeroes/
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * @Author hao
 * @Date 2023/2/13 18:57
 */
public class Code14_FindMaxFrom {
    public static void main(String[] args) {
        String goods=args[0].split(" ")[0];
        String contain=args[0].split(" ")[1];

        System.out.println();
    }

    public int findMaxForm(String[] strs, int m, int n) {
        return findMaxForm(strs,m,n);
    }
    private int process_dp(String[] strs, int m, int n){
        //定义两个变量来记录已有的0、1个数
        int num_0=0;
        int num_1=0;
        if (strs.length==0||m==0||n==0){
            return 0;
        }
        int len=strs.length;
        //dp数组，表示加入了第几个字符后的字符串数组长度
        int[][] dp=new int[m+1][n+1];
        //递推公式
        for (String str : strs) {
            for (char ch : str.toCharArray()
                    ) {
                if (ch == '1') {
                    num_0++;
                } else {
                    num_1++;
                }
            }
            for (int j = m; j >= num_0; j--) {
                for (int k = n; k >= num_1; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-num_0][k-num_1]);
                }
            }
        }
        return dp[m][n];
    }

}
