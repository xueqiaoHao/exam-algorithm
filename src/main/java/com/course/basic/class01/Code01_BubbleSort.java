package com.course.basic.class01;


import com.course.util.DataUtil;

public class Code01_BubbleSort {
    public static void main(String[] args) {
        int[] arr={1,5,3,7,9,2};
        bubbleSort(arr);
        for (int num:arr
             ) {
            System.out.print(num+",");
        }
    }
    private static void bubbleSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    DataUtil.swap(arr,j,j+1);
                }
            }
        }

    }
}
