package fdu.basic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Description  TODO 【2017-1】中位数
 题目描述：给定一个整数序列，求中位数。
 如果序列个数为奇数，中位数为升序的中间位置，如果是偶数，这位升序的中间两个数的平均值。
 输入
 输入包含多组测试数据，每一组第一行为n(n<104)表示这个序列的个数，接下来有n个整数k(0<k<231-1)
 输出
 输出这个序列的中位数
 输入1：
 5
 2 1 4 3 5
 输出1：
 3
 输入2：
 4
 1 4 3 2
 输出2：
 3
 * Author hao
 * Date 2023/3/19 20:51
 */
public class Basic_2017_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]= scanner.nextInt();
        }
        scanner.close();

        quickSort(nums,0,n-1);
        //奇数
        if (n%2!=0){
            System.out.println(nums[n/2]);
        }else {
            int tmp = nums[n / 2] + nums[n / 2 - 1];
            if(tmp%2==0){
                System.out.println(tmp/2);
            }else {
                //中间两个数的和是奇数
                float tmpDou = (float) tmp / (float) 2;
                int round = Math.round(tmpDou);
                System.out.println(round);
            }
        }
    }

    @Test
    public void test(){
        int tmp = 5;
        //中间两个数的和是奇数
        float tmpDou = (float) tmp / (float) 2;
        int round = Math.round(tmpDou);
        System.out.println(round);
    }


    /*
     * @Description //TODO 手写快排
     * @Date 20:55 2023/3/19
     * @param nums
     * @return int[]
     **/
    private static void quickSort(int[] nums,int start,int end){
        if (start>=end){
            return ;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums,start,pivot-1);
        quickSort(nums,pivot+1,end);
    }

    /*
     * @Description //TODO 完成一次枢轴左右两侧的元素划分
     * @Date 21:07 2023/3/19
     * @param nums
     * @param start
     * @param end
     * @return int  返回此次分区后枢轴的位置
     **/
    private static int partition(int[] nums,int start,int end){
        if (start>end){
            return -1;
        }
        if (start==end){
            return start;
        }
        int pivot = nums[start];
        //左侧比右侧小就一直走
        while (start<end){
            while (nums[end]>pivot&&start<end){
                end--;
            }
            nums[start] = nums[end];
            while (nums[start]<pivot&&start<end){
                start++;
            }
            //交换左右两元素
            nums[end] = nums[start];
            //交换完成后，继续走
        }
        //走完一轮，确定枢轴
        nums[start] = pivot;
        //返回的是枢轴的位置
        return start;
    }
}
