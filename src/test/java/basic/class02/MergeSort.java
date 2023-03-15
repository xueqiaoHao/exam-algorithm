package basic.class02;

import util.DataUtil;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={1,5,3,7,9,2};
        int mid = (4+3)/2;
        System.out.println(mid);
    }
    private static void mergeSort(int[] arr){
        if(arr == null||arr.length<2){
            return;
        }
        //
        process(arr,0,arr.length-1);
    }
    private static void process(int[] arr, int L, int R){
        if (L == R){
            return;
        }
        int mid = L + ((R-L)>>1); //之所以不写成L+R,是为了防止溢出。特殊情况L+R太大了
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }
    private static void merge(int[] arr,int L,int M,int R){
        //辅助数组tmp。存储合并后的有序数组
        int[] tmp = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while (p1 <= M && p2<=R){
            tmp[i++] = arr[p1]<=arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=M){
            tmp[i++]=arr[p1++];
        }
        while (p2<=R){
            tmp[i++]=arr[p2++];
        }
        //将已经合并后的有序数组重新复制到arr数组中去
        for (i=0;i< tmp.length;i++) {
            arr[L+i]=tmp[i];
        }
    }
}
