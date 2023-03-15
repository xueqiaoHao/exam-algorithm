package com.course.dp_01;

public class Code02_CardsInlie {

    /*
     * 采用递归形式的v1版本
     * */
    private static int getMax_v1(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        //先手人物A
        int first = first_v1(arr, 0, arr.length - 1);
        //后手人物B
        int last = last_v1(arr, 0, arr.length - 1);
        return Math.max(first, last);
    }

    //先手函数
    private static int first_v1(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }
        int value1 = arr[L] + last_v1(arr, L + 1, R);
        int value2 = arr[R] + last_v1(arr, L, R - 1);
        return Math.max(value1, value2);
    }

    //后手函数
    private static int last_v1(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }
        //对手拿走了L位置的数
        int value1 = first_v1(arr, L + 1, R);
        //对手拿走了R位置的数
        int value2 = first_v1(arr, L, R - 1);
        return Math.min(value1, value2);
    }


    /**
     * 傻瓜式缓存表，二维数组保存已有结果的dp
     * */

    private static int getMax_v2(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int N = arr.length;
        //二维辅助数组，表示先后手，都在0~N之间
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                fmap[i][j] = -1;
                gmap[i][j] = -1;
            }
        }
        //先手人物A
        int first = first_v2(arr, 0, arr.length - 1, fmap, gmap);
        //后手人物B
        int last = last_v2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(first, last);
    }

    //先手函数
    private static int first_v2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {

        if (fmap[L][R] != -1) {
            return fmap[L][R];
        }
        int ans;
        if (L == R) {
            ans = arr[L];
        } else {
            int value1 = arr[L] + last_v2(arr, L + 1, R, fmap, gmap);
            int value2 = arr[R] + last_v2(arr, L, R - 1, fmap, gmap);
            ans = Math.max(value1, value2);
        }
        fmap[L][R] = ans;
        return ans;
    }

    //后手函数
    private static int last_v2(int[] arr, int L, int R, int[][] fmap, int[][] gmap) {
        if (gmap[L][R] != -1) {
            return gmap[L][R];
        }
        int ans = 0;
        if (L != R) {

            //对手拿走了L位置的数
            int value1 = first_v2(arr, L + 1, R, fmap, gmap);
            //对手拿走了R位置的数
            int value2 = first_v2(arr, L, R - 1, fmap, gmap);
            ans = Math.min(value1, value2);
        }
        gmap[L][R] = ans;
        return ans;
    }

    /**
     * 推出依赖关系后的dp表
     * 源头来自于最开始的递归函数
     * ① 有了最开始的递归函数，后续优化无非是将递归树中重复的部分存入一个二维数组dp，减少重复递归
     * ② 后续递归优化环节，手推依赖关系，将依赖关系计入二维数组
     * */
    private static int getMax_v3(int[] arr) {
        if (arr.length == 0 || arr == null) {
            return 0;
        }
        int N = arr.length;
        //二维辅助数组，表示先后手，都在0~N之间，二维数组默认值都是0
        int[][] fmap = new int[N][N];
        int[][] gmap = new int[N][N];
        /*
        fmap对角线对应的是arr数组中的对应值
         if (L == R) {
            return arr[L];
        }
         */
        for (int i=0;i<N;i++){
            fmap[i][i]=arr[i];
        }

        for (int col=1;col<N;col++){
            int L=0;
            int R=col;
            //溢出是列先溢出，所以是用列来控制。。对角线赋值，先是主对角，继而副对角，次副对角
            while (R<N){
                fmap[L][R]=Math.max(arr[L]+gmap[L+1][R],arr[R]+gmap[L][R-1]);
                gmap[L][R]=Math.min(fmap[L+1][R],fmap[L][R-1]);
                L++;
                R++;
            }
        }
        //先手人物A
        int first = first_v2(arr, 0, arr.length - 1, fmap, gmap);
        //后手人物B
        int last = last_v2(arr, 0, arr.length - 1, fmap, gmap);
        return Math.max(first, last);
    }
    public static void main(String[] args) {
        int[] arr = {5, 7, 4, 5, 8, 1, 6, 0, 3, 4, 6, 1, 7};
//        System.out.println(getMax_v1(arr));
        System.out.println(getMax_v2(arr));
        System.out.println(getMax_v3(arr));


    }
}
