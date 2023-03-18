package com.course.basic.class01;


import com.course.util.DataUtil;

public class Code01_InsertSort {
    public static void main(String[] args) {
        int[] arr={1,5,3,7,9,2};
        insertSort(arr);
        DataUtil.printArray(arr);
    }
    private static void insertSort(int[] arr){
      for (int i=1;i<arr.length;i++){
          for (int j=i-1;j>=0&&arr[j]>arr[j+1];j--){
              DataUtil.swap(arr,j,j+1);
          }
      }
    }
}
