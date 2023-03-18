package fdu.dp;

import java.util.Scanner;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/15 20:46
 */
public class Dp_2014_2 {
    /**
     * @Description //TODO
     * 题目描述：
     * 把两个字符串变成相同的三个基本操作定义如下：
     * 1.修改一个字符（如把a 变成b）
     * 2.增加一个字符(如abed 变成abedd)
     * 3.删除一个字符（如jackbllog 变成jackblog）
     * 针对于jackbllog 到jackblog 只需要删除一个或增加一个l 就可以把两个字符串变为相同。
     * 把这种操作需要的最小次数定义为两个字符串的编辑距离L。
     * 编写程序计算指定文件中字符串的距离。输入两个长度不超过512 字节的ASCII 字符串，在
     * 屏幕上输出字符串的编辑距离。
     * 输入：
     * Helloworld!
     * Helloword!
     * 输出：
     * 1
     **/
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
     * @Description //TODO
     * @Date 21:33 2023/3/15
     * @param s1
     * @param s2
     * @return int 编辑距离
     **/
    private static int processDp(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int n1 = chars1.length;
        int n2 = chars2.length;
        //定义dp数组，dp[i][j]代表当前位置保持一致所需的最小步数
        int[][] dp = new int[n1][n2];
        boolean flag1 = false, flag2 = false;
        if (chars1[0] == chars2[0]) {
            dp[0][0] = 0;
            flag1 = flag2 = true;
        } else {
            dp[0][0] = 1;
        }
        //初始化第一列
        for (int i = 1; i < n1; i++) {
            //与第二个字符串0位置相等的元素第一次出现
            if (dp[i][0] == chars2[0] && !flag1) {
                flag1 = true;
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = dp[i - 1][0] + 1;
            }
        }
        //初始化第一行
        for (int i = 1; i < n2; i++) {
            //与第二个字符串0位置相等的元素第一次出现
            if (dp[0][i] == chars1[0] && !flag2) {
                flag2 = true;
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = dp[0][i - 1] + 1;
            }
        }
        //开始两层for循环递推
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (chars1[i] == chars2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //最后一步是替换操作，所以考虑都缩回一个字符后，只对最后一个元素替换的情况
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]),dp[i-1][j-1]) + 1;
                }
            }
        }
        return dp[n1 - 1][n2 - 1];
    }
}
