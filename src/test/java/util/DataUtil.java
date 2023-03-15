package util;

public class DataUtil {
    public static void swap(int[] arr,int i,int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void printArray(int[] arr){
        for (int num:arr
             ) {
            System.out.println(num+" ");
        }
    }
    public boolean judgeIsInt(double val){
        return val % 1 == 0;
    }

}
