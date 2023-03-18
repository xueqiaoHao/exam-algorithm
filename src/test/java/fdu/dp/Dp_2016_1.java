package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 * 【2016-1】DP-求最大连续公共字串长度
 题目描述：给定两个字符串，求最大公共字串的长度，长度小于1000
 分为两种问题：要求计算连续最长字串的长度
 如下按照寻找连续的字串理解
 输入：
 1111hello2222
 1133hello444
 输出：
 5
 注意：公共子串是连续的，如果求不连续
 * Author hao
 * Date 2023/3/16 11:38
 */
public class Dp_2016_1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始接收键盘输入");
        String[] strings = new String[2];
        int index = 0;
        while (scanner.hasNext()){
            strings[index++] = scanner.next();
        }
        System.out.println(processDp(strings[0],strings[1]));
    }

    private static int processDp(String s1, String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;
        //dp[i][j]  i、j位置的最长公共子序列，连续的这是
        int[][] dp = new int[n1][n2];
        //初始化
        //行和列未匹配成功
//        boolean row = false,column=false;
        if (chars1[0]==chars2[0]){
            dp[0][0]=1;
        }
        for (int i = 1; i < n1; i++) {
            if(chars1[i]==chars2[0]){
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < n2; i++) {
            if(chars2[i]==chars1[0]){
                dp[0][i] = 1;
            }
        }

        //获取dp[i][j]数组中的最大值
        int max = 0;
        //递推公式
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if(chars1[i]==chars2[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        //打印dp数组
        //递推公式
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return max;

    }
}
