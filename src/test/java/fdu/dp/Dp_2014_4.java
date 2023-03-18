package fdu.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description  TODO
 * Author hao
 * Date 2023/3/15 22:12
 */
public class Dp_2014_4 {
    /**
     * DP-Hanoi 塔
     问题描述
     Hanoi 塔问题是印度的一个古老的传说。开天辟地的神勃拉玛在一个庙里留下了 TODO 三根金刚石的棒，
     第一根上面套着64 个圆的金片，最大的一个在底下，其余一个比一个小，依次叠上去，
     庙里的众僧不倦地把它们一个个地从这根棒搬到另一根棒上，规定可利用中间的一根棒作为帮助，但每次只能搬一个，而且大的不能放在小的上面。
     请编写程序，把A 柱上的n 个金片，搬动到C 柱（中间可以使用B 柱），使得搬动的次数最少。
     输入金片的个数n（1<=n<=64），输出总搬动次数，以及最后100 次搬动。
     如果搬动次数小于等于100 则全部输出；每个搬动占一行，加上是这第几次搬动的数字和”:”，格式见示例。
     输入：
     2
     输出：
     3
     1:A->B
     2:A->C
     3:B->C
     *
     **/
    //key-value 第n次移动:移动记录     1:A->B
    private static List<String> list = new ArrayList<>();

    private static int moveCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("开始接收控制台输入");
        int n = scanner.nextInt();
        processDp(n,'A','B','C');
        if(list.size()<=100){
            list.forEach(System.out::println);
        }else {
            //否则输出后一百次
            for (int i = list.size()-100; i <list.size() ; i++) {
                System.out.println(list.get(i));
            }
        }
    }
    /*
     * @Description //TODO 基于分治和递归解决
     * @Date 10:49 2023/3/16
     * @param n 总盘数
     * @param a 一号柱子
     * @param b
     * @param c

     **/
    private static void processDp(int n, char a,char b,char c){
        //只剩最后一个盘子
        if(n==1){
            //将盘子从出发点A，移动到目的地C
            list.add(++moveCount+":"+a+"->"+c);
            return;
        }
        //将上面的n-1个盘子从A移动到B
        processDp(n-1,a,c,b);
        //将最下面的盘子从A移动到c
        list.add(++moveCount+":"+a+"->"+c);
        //将剩下的n-1个盘子从B移动到C
        //而后重新开始 n-1个盘子从A移动到C的过程
        processDp(n-1,b,a,c);
    }
}
