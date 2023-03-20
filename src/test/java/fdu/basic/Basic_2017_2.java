package fdu.basic;

import org.junit.Test;

import java.util.Collections;
import java.util.Scanner;

/**
 * Description  TODO  【2017-2】9位ISBN，求其校验位
 题目描述：给定一个9位数字的ISBN，求其校验位。ISBN格式为2-02-033598，
 校验位的计算方法如下：从左到右依次将各位数字乘10，9，8，……，2，求出其和S，作模运算得M=S mod 11。
 若11-M在1和9之间，校验位即为该数字；若11-M等于10，校验位为X；11-M等于11，校验位为0。
 输出添加校验位的ISBN，如2-02-033598-0。
 输入1：
 2-02-033598
 输出1：
 2-02-033598-0
 输入2：
 7-309-04547
 输出2：
 7-309-04547-5

 *
 * Author hao
 * Date 2023/3/20 10:24
 */
public class Basic_2017_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        //拿到纯数字集合
        String[] split = next.replaceAll("-", "").split("");
        int sum = 0;
        for (int i = 0; i < split.length; i++) {
            sum+=Integer.parseInt(split[i])*(10-i);
        }
        int m = sum %11;
        String check = null;
        if (m<=10&&m>=2){
            check=m+"";
        }else if (m==1){
            check = "X";
        }else if (m==0){
            check = "0";
        }
        System.out.println(next+"-"+check);
    }

}
