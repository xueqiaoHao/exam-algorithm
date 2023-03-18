package com.course.basic.class02;

public class MinSum {
    public static void main(String[] args) {
        int[] arr={1,5,3,7,9,2};//5+10+6+7
        System.out.println(smallSum(arr));
    }
    /*
    * 求小和问题。借助归并排序
    * */
    private static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr,int l,int r){
        if (l==r){
            return 0;
        }
        int mid = l + ((r-l)>>1);
        return mergeSort(arr,l,mid)+
               mergeSort(arr,mid+1,r)+
                merge(arr,l,mid,r);


    }

    private static int merge(int[] arr,int l,int m,int r){
        int[] tmp = new int[r-l+1];
        int sum=0;
        int i=0;
        int p1=l;
        int p2=m+1;
        while (p1<=m&&p2<=r){
            sum+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1]:0;

            tmp[i++]=arr[p1]<arr[p2]?arr[p1++]:arr[p2++];
        }
        while (p1<=m){
            tmp[i++]=arr[p1++];
        }
        while (p2<=r){
            tmp[i++]=arr[p2++];
        }
        for (i=0;i<tmp.length;i++){
            arr[l+i]=tmp[i];
        }
        return sum;
    }
}
