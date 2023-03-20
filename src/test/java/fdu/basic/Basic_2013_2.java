package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO 【2013-2】A Famous ICPC Team
 题目描述：给出四个正方体箱子的边长，问能装下这四个正方体箱子的大正方体边长最小要多大，要求边长最小且必须能装下四个箱子。
 输入：
 2 2 2 2
 输出：
 4
 * Author hao
 * Date 2023/3/19 19:44
 */
public class Basic_2013_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("start input====");
        //记录四个正方体的体积和
        int volume = 0;
        for (int i = 0; i < 4; i++) {
            int anInt = scanner.nextInt();
            volume += anInt*anInt;
        }
        scanner.close();
        //对体积开根号
        double sqrt = Math.sqrt(volume);
        int result;
        //判断double是否为整数
        if (Math.abs(sqrt-Math.round(sqrt))<Double.MIN_VALUE){
            result = (int)sqrt;
        }else {
            result = (int)sqrt+1;
        }
        System.out.println(result);

    }
}
