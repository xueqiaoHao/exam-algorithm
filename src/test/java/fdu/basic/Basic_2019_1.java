package fdu.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description  TODO 【2019-1】日期处理
 题目描述：输入日期格式:YYYYMMDD，求与20190205的相隔的天数。
 输入：20190208
 输出：3
 * Author hao
 * Date 2023/3/20 15:30
 */
public class Basic_2019_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        scanner.close();
        int todayCount = 2018*365 + 2019/4 +1 + 31+5;
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(4, 6));
        int day = Integer.parseInt(date.substring(6, 8));
        int yearDays,monthDays=0,dayDays=0;
        List<Integer> longMonth = new ArrayList<>();
        List<Integer> shortMonth = new ArrayList<>();
        longMonth.add(1);
        longMonth.add(3);
        longMonth.add(5);
        longMonth.add(7);
        longMonth.add(8);
        longMonth.add(10);
        longMonth.add(12);
        shortMonth.add(4);
        shortMonth.add(6);
        shortMonth.add(9);
        shortMonth.add(11);
        //计算一下从 公元元年开始，到当前日期的总天数
        //迄今为止的闰年个数
        yearDays = (year-1)*365+year / 4 +1;
        for (int i = 1; i < month; i++) {
            if (longMonth.contains(i)){
                monthDays += 31;
            }else if (shortMonth.contains(i)){
                monthDays +=30;
            }else if (year%4==0){
                monthDays +=29;
            }else {
                monthDays +=28;
            }
        }
        int inputCount = yearDays + monthDays +day;
        System.out.println(Math.abs(inputCount-todayCount));

    }

    @Test
    public void test(){
        String a = "abcd";
        System.out.println(a.substring(0,2));
    }
}
