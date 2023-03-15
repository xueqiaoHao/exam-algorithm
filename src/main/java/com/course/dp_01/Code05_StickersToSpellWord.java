package com.course.dp_01;

/** https://leetcode.cn/problems/stickers-to-spell-word/
 * @Description TODO 我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。

您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。
如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。
返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。
注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。
 * @Author hao
 * @Date 2023/2/8 11:38
 */
public class Code05_StickersToSpellWord {
    public static void main(String[] args) {

    }
    /**
     * @Description //TODO
     * @Date 11:41 2023/2/8
     * @param stickers 字符数组，每一张的都有无穷多张可用
     * @param target  目标字符
     * @return int 所需的最少张数
     **/
    private static int process1(String[] stickers,String target){
        //目标字符匹配结束，返回0
        if(target.length()==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for (String first:stickers
             ) {
            String rest=minus(target,first);
            //确实切除掉了部分字符，证明当前这个字符可选做第一个单词卡片
            if (rest.length()!=target.length()){
                min=Math.min(min,process1(stickers,rest));
            }
        }
        return min+(min == Integer.MAX_VALUE?0:1);
    }
    /**
     * @Description //TODO
     * @Date 11:45 2023/2/8
     * @param target 即将进行切割的目标字符，母字符
     * @param first  即将切割掉的字符，子字符
     * @return String
     **/
    private static String minus(String target,String first){
        char[] str1s=target.toCharArray();
        char[] str2s=first.toCharArray();
        int[] count=new int[26];
        //将target字符以及对应个数记录入数组
        for (char str1:str1s
             ) {
            count[str1-'a']++;
        }
        //将first中在target内包含的字符从target中删除
        for (char str2:str2s
             ) {
            count[str2-'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                sb=sb.append((char)i+'a');
            }
        }
        return sb.toString();
    }
}
