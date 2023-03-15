package com.course.dp_02_carl;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/17 14:06
 */
public class Code19_NumSquares {
    private int process(int n){
        //和为整数n的完全平方数的最少个数
        int[] dp=new int[n+1];
        dp[1]=1;
        if(n<2){
            return 1;
        }
        dp[2]=2;
        double sqrt=0;
        int sqrt_int=0;
        int pow=0;
        for(int i=3;i<=n;i++){
            sqrt=Math.sqrt(i);
            //  System.out.print(sqrt+" ");
            if(sqrt%1==0){
                dp[i]=1;
            }
            else{
                //所包含的最大完全平方数，而后加一
                sqrt_int=(int)Math.sqrt(i);
                dp[i]=dp[i-1]+1;
                for(int j=sqrt_int;j>0;j--){
                    pow=j*j;
                    // pow=(int)Math.pow(sqrt_int,sqrt_int);
                    System.out.print("i="+i+"&pow="+pow);
                    dp[i]=Math.min(dp[i],dp[i-pow]+1);
                }

            }
        }
        // for(int val:dp){
        //     System.out.print(val+" ");
        // }
        return dp[n];
    }
}
