package fdu.basic;

import java.util.*;

/**
 * Description  TODO 【2018-1】求众数
 题目描述：众数就是一个序列中出现次数最多的数字。 如果不唯一，则输出小的那个值。
 样例输入：
 第一行给出N（1<=n<=10^5 ），第二行给出N个数字，每个数字在int范围内
 输入1：
 8
 10 3 8 8 3 2 2 2
 输出1：
 2
 输入2：
 5
 3 3 2 4 2
 输出2：
 2
 * Author hao
 * Date 2023/3/20 11:05
 */
public class Basic_2018_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nextInt = scanner.nextInt();
            if (map.containsKey(nextInt)){
                map.put(nextInt,map.get(nextInt)+1);
            }else {
                map.put(nextInt,1);
            }
        }
        //换个存法
        Map<Integer,List<Integer>> mapTmp = new HashMap<>();
        int max = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            int val = entry.getValue();
            max = Math.max(max,val);
            if (mapTmp.containsKey(val)){
                List<Integer> integers = mapTmp.get(val);
                integers.add(entry.getKey());
                mapTmp.put(val,integers);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(entry.getKey());
                mapTmp.put(val,list);
            }
        }
        List<Integer> integers = mapTmp.get(max);
        Collections.sort(integers);
        System.out.println(integers.get(0));
    }
}
