package com.fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 * 给定两个单词 word1 和 word2，求将 word1 转化为 word2 的最少“操作”步
 数（该步数又称为两个单词的编辑距离）。这里的“操作”可以是插入一个字符、删
 除一个字符、替换一个字符。
 输入样例：

 word1 = “horse”，word2 = “ros”
 输出样例：

 3（即用 r 替换 h、删除 r、删除 e）
 * Author hao
 * Date 2023/3/16 22:05
 */
public class Dp_2022_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始接收键盘输入========");
        String[] strings = new String[2];
        int index=0;
        while (scanner.hasNext()){
            strings[index++]=scanner.next();
        }
        System.out.println(processDp(strings[0],strings[1]));
    }
    /*
     * @Description //TODO  最短编辑距离
     * @Date 22:10 2023/3/16
     * @param word1
     * @param word2
     * @return int
     **/
    private static int processDp(String word1, String word2){
        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;
        int[][] dp = new int[n1][n2];
        boolean flag1=false,flag2=false;
        if (chars1[0]==chars2[0]){
            dp[0][0]=0;
            flag1 = flag2 =true;
        }else {
            dp[0][0]=1;
        }
        for (int i = 1; i < n1; i++) {
            if (chars1[i]==chars2[0]&&!flag1){
                dp[i][0]=dp[i-1][0];
                flag1 = true;
            }else {
                dp[i][0]=dp[i-1][0]+1;
            }

        }
        for (int i = 1; i < n2; i++) {
            if (chars1[0]==chars2[i]&&!flag2){
                dp[0][i]=dp[0][i-1];
                flag2 = true;
            }else {
                dp[0][i]=dp[0][i-1]+1;
            }
        }
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (chars1[i]==chars2[j]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    //三个操作，对应删除，添加，替换
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                }
            }
        }
        return dp[n1-1][n2-1];
    }
}
