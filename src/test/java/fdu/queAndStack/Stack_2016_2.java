package fdu.queAndStack;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Description  TODO 第二题 给定一个后缀序列，要求求值，只有加减（后缀倒是无所谓）
 * 输入：
 123++4-

 输出：
 2
 * Author hao
 * Date 2023/3/18 15:30
 */
public class Stack_2016_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //定义一个栈
        Deque<Integer> stack = new LinkedList<>();
        String s = scanner.nextLine();
        scanner.close();
        String[] inputs = s.split("");
        for (String in:inputs
             ) {
            switch (in) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    //先出栈的是被减数，加个负号就好了
                    stack.push(-stack.pop() + stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(in));
                    break;
            }
        }
        System.out.println(stack.pop());
    }

}
