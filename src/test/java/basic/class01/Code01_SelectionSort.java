package basic.class01;

import util.DataUtil;

public class Code01_SelectionSort {
    public static void main(String[] args) {
        int[] arr={1,5,3,7,9,2};
        selectionSort(arr);

        for (int num:arr
             ) {
            System.out.print(num+",");
        }
    }
    //    选择排序逻辑代码
    private static void selectionSort(int[] arr) {
        if (arr == null || arr.length<2){
            return;
        }
        for (int i=0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j=i+1;j<arr.length;j++){
                minIndex = arr[j]<arr[minIndex] ? j:minIndex;
            }
            DataUtil.swap(arr,i,minIndex);
        }
    }

}
