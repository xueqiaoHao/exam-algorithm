package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO 【2015-1】长方形中的正方形
 题目描述：给出长方形的长和宽，每次从长方形里撕去最大的正方形，输出最后能得到多少正方形
 输入：
 3 4
 输出：
 4
 * Author hao
 * Date 2023/3/19 20:14
 */
public class Basic_2015_1 {
    private static int result =0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        scanner.close();
        int count=0;
//        process(length,width);
        while (length!=width){
            count++;
            if (length<width){
                int tmp = length;
                length=width;
                width=tmp;
            }
            length-=width;
        }
        System.out.println(count+1);
    }

    /*
     * @Description //TODO
     * @Date 20:19 2023/3/19
     * @param length 原始长方形的长
     * @param width  宽
     * @return int 最多多少个正方形
     **/
    private static void process(int length, int width){
        if (length==0||width==0){
            return;
        }
        if(length<width){
            process(length,width-length);
        }else {
            process(width,length-width);
        }
        result++;
    }


}
