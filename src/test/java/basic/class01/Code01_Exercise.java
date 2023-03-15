package basic.class01;
/*
* 第一堂课课上练习题
* */
public class Code01_Exercise {
    public static void main(String[] args) {
        int[] arr={65535,1,1,3,3,95535};
        findSpecificData_2(arr);
    }
    /*
    * 数组A中，一种数出现了奇数次。其它数出现了偶数次，找到奇数次的数
    * 思路:使用异或操作。所有数都参与一次异或，最后异或变量的值即为所求元素
    * */
    private static void findSpecificData_1(int[] arr){
        int eor=0;
        for (int ele:arr
             ) {
            eor = eor ^ ele;
        }
        System.out.println(eor);
    }
    /*
     * 数组A中，两种数(a,b)出现了奇数次。其它数出现了偶数次，找到奇数次的数
     * 思路:两个eor。第一个得到的结果eor是 a^b
     *     第二个eor_plus将 eor^(a||b)
     *     最后eor^eor_plus，可得到两个值
     * */
    private static void findSpecificData_2(int[] arr){
        int eor=0;
        for (int ele:arr
                ) {
            eor = eor ^ ele;
        }
        //得到a^b
        int rightOne = eor & (~eor+1);//eor与上eor的补码。得到右向左第一个1
        int eorPlus=0;
        for (int ele:arr
             ) {
            if ((ele&rightOne)==rightOne){
                eorPlus = eorPlus^ele;
            }
        }
        //得到了a或者b
        eor=eorPlus^eor;//另一个数
        System.out.println("a="+eor+","+"b="+eorPlus);

    }
}
