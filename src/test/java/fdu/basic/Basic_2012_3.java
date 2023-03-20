package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO  【2012-3】字符串的重复输出
 * 题目描述：给一个字符串比如ABC 再给一个整数比如3输出AAABBBCCC就行了。
 * Author hao
 * Date 2023/3/19 19:18
 */
public class Basic_2012_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int n = scanner.nextInt();
        String[] strings = s.split("");
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            for (int j = 0; j < n; j++) {
                builder.append(string);
            }
        }
        System.out.println(builder.toString());
    }

}
