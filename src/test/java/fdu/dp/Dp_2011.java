package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO 复旦11年机试dp真题  -- 输入3个子串， 输出这3个子串的最大公共子串 。
 * <p>
 * Author hao
 * Date 2023/3/15 17:20
 */
public class Dp_2011 {
    /**
     * @Description //TODO
     * 问题描述：输入3个子串， 输出这3个子串的最大公共子串
     * 输入：abcd acb abc
     * 输出：ab
     * @Date 17:26 2023/3/15
     * param args
     **/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("进入程序");
        //定义String数组来接受三个字符串
        String[] strings = new String[3];
        int i = 0;
        while (scanner.hasNext()) {
            strings[i++] = scanner.next();
        }
        scanner.close();
        System.out.println(processDp(strings[0], strings[1], strings[2]));
    }

    private static String processDp(String s1, String s2, String s3) {
        //求三个元素的最长公共子序列,先求两个在求第三个
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        char[] chars3 = s3.toCharArray();
        int ln1 = chars1.length;
        int ln2 = chars2.length;
        int ln3 = chars3.length;


        //做一个三维dp数组来求最长子序列
        //来存储s1与s2与s3的最长公共子序列
        String[][][] dp = new String[ln1][ln2][ln3];
        for (char aChars1 : chars1) {
            //如果三个元素的0位置都相等，那么dp[0][0][0]
            if (chars1[0] == chars2[0] && chars1[0] == chars3[0]) {
                dp[0][0][0] = chars1[0] + "";
            }
        }
        //初始化这个三维的坐标轴
        //来记录 s1和s2中已有的公共子序列
        StringBuilder builder1 = new StringBuilder();
        //三层for循环
        for (int i = 1; i < ln1; i++) {
            for (int j = 1; j < ln2; j++) {
                for (int k = 1; k < ln3; k++) {
                    dp[0][j][k] = dp[0][0][0];
                    dp[i][0][k] = dp[0][0][0];
                    dp[i][j][0] = dp[0][0][0];
                    int i1 = dp[i][j][k - 1].length();
                    int i2 = dp[i][j - 1][k].length();
                    int i3 = dp[i - 1][j][k].length();
                    if (i1 >= i2 && i1 >= i3) {
                        dp[i][j][k] = dp[i][j][k - 1];
                    } else if (i2 >= i1 && i2 >= i3) {
                        dp[i][j][k] = dp[i][j - 1][k];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                    if (chars1[i] == chars2[j] && chars1[i] == chars3[k]) {

                        dp[i][j][k] += chars1[i];
                    }
//                    else {
//                        dp[i][j][k] = dp[i][j][k - 1];
//                    }
                }
            }
        }
        for (int i = 0; i < ln1; i++) {
            for (int j = 0; j < ln2; j++) {
                for (int k = 0; k < ln3; k++) {
                    System.out.print(dp[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[ln1 - 1][ln2 - 1][ln3 - 1];
    }
}
