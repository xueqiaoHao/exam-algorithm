package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO 【2015-2】a与b得到c
 * 题目描述：给出a,b,c（3个整数），判断a,b能否通过±乘除得到c，ab可以交换位置，可以输出YES，不行输出NO
 * 输入：
 * 3 8 2
 * 输出：
 * NO
 * Author hao
 * Date 2023/3/19 20:40
 */
public class Basic_2015_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();
        System.out.println(checkResult(a, b, c));
    }

    private static String checkResult(int a, int b, int c) {
        if (Math.abs(a - b) == c || a + b == c || b * c == a || a * c == b || a * b == c) {
            return "YES";
        }
        return "NO";

    }
}
