package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO A、斗牛
 题目描述：给定五个 0~9 范围内的整数 a1, a2, a3, a4, a5。
 如果能从五个整数中选出三个并且这三个整数的和为10 的倍数（包括 0），
 那么这五个整数的权值即为剩下两个没被选出来的整数的和对 10 取余的结果，显然如果有多个三元组满⾜和是 10 的倍数，
 剩下两个数之和对 10 取余的结果都是相同的；
 如果
 选不出这样三个整数，则这五个整数的权值为 -1。
 现在给定 T 组数据，每组数据包含五个 0~9 范围内的整数，分别求这 T 组数据中五个整数的权值。
 【输入格式】 第一行一个整数 T (1<=T<=1000)，表⽰数据组数。 接下来 T 行，每行 5 个 0~9 的整数，表示一组数据。
 【输出格式】输出 T 行，每行一个整数，表⽰每组数据中五个整数的权值。
 【样例输⼊】
 4
 1 0 0 1 0
 1 0 0 8 6
 3 4 5 6 7
 4 5 6 7 8
 【样例输出】
 2
 -1
 -1
 0
 * Author hao
 * Date 2023/3/20 16:20
 */
public class Basic_2020_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] strings = line.split(" ");

        }
    }

}
