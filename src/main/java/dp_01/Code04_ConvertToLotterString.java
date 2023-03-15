package dp_01;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/6 10:55
 */
public class Code04_ConvertToLotterString {

    /**
     * @Description 暴力递归
     * //TODO  str[0,i]已处理完成，[i,n]无法返回
     * @Date 11:20 2023/2/6
     * @param str str[i...n]
     * @param index  数组下标
     * @return int 方法数
     **/
    private static int process(char  [] str,int index){
        if (index==str.length){
            return 1;
        }
        //为0表示之前的决定有问题
        if (str[index]=='0'){
            return 0;
        }
        //不为0
        //可能性一，此字符单独转化
        int poss=process(str,index+1);
        //可能性二，与其后的数值一起转化
        if (index+1<str.length&&(str[index]-'0')*10+str[index+1]-'0'<27){
            poss+=process(str,index+2);
        }
        return poss;
    }
    private static int getNumber(String str){
        if (str.length() == 0){
            return 0;
        }
        return process(str.toCharArray(),0);
    }

    /**
     * @Description //TODO 观察递归发现依赖后面的位置，所以从右向左填，填到0位置停
     * @Date 12:27 2023/2/6
     * @param str
     * @return int
     **/
    private static int dp(String str){
        if (str.length()==0){
            return 0;
        }
        char[] strs=str.toCharArray();
        int length=strs.length;
        int[] dp=new int[length];
        if (strs[0]!='0'){
            dp[0]=1;
            //分析第二位
            if (strs.length>1){
                if (strs[1]!='0'){
                    //拆开来计数
                    dp[1]=1;
                }
                //两位合在一起计数
                if ((strs[0]-'0')*10+strs[1]-'0'<27){
                    dp[1]+=1;
                }
            }
        }
        for (int i=2;i<length;i++){
            if (dp[i-1]==0){
                break;
            }
            //不为0时候单个拆分
            if (strs[i]!='0'){
                dp[i]=dp[i-1];
                //两位合在一起计数，小于27时
                if ((strs[i-1]-'0')*10+strs[i]-'0'<27){
                    dp[i]+=1;
                }
            }else {
                //两位合在一起计数，小于27时
                if ((strs[i-1]-'0')*10+strs[i]-'0'<27){
                    dp[i]=dp[i-1];
                }
            }
            System.out.println("第"+i+"次输出结果==="+dp[i]);
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        System.out.println(getNumber("72325"));
        System.out.println(dp("72325"));
        //723152310
    }
}
