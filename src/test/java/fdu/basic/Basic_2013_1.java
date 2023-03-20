package fdu.basic;

import java.util.Scanner;

/**
 * Description  TODO 【2013-1】字符串匹配
 题目描述：对于主串M和模式串P，找到P在M中出现的所有子串的第一个字符在P中的位置。
 P中第一个字符所在的位置为0。首行的数字表示有多少组字符串。
 输入：
 2
 ababababa
 ababa
 aaa
 aa
 输出：
 0 2 4
 0 1
 (相邻位置之间用一个空格隔开)
 * Author hao
 * Date 2023/3/19 19:25
 */
public class Basic_2013_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int mainIndex;
        for (int i = 0; i < n; i++) {
            String mainString = scanner.next();
            String subString = scanner.next();
            for (int j = 0; j < mainString.length()-subString.length()+1; j++) {
                mainIndex = j;
                for (int k = 0; k < subString.length(); k++) {
                    if (mainString.charAt(mainIndex)==subString.charAt(k)){
                        mainIndex++;
                    }else {
                        break;
                    }
                }
                if (mainIndex-j==subString.length()){
                    System.out.print(j+" ");
                }
            }
            System.out.println();
        }
    }
}
