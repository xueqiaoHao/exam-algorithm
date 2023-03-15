package dp_02_carl;

import java.util.HashSet;
import java.util.List;

/**
 * @Description TODO
 * @Author hao
 * @Date 2023/2/17 15:09
 */
public class Code20_WordBreak {
    public static void main(String[] args) {
        System.out.println();
    }
    public boolean process(String s,List<String> wordDict){
        int len = s.length();
        //当前位置是否可被list组合拼接
        boolean[] valid = new boolean[len +1];
        //0下标初始为0
        valid[0]=true;
        //新建hashSet来存储list中的元素
        HashSet<String> wordSet = new HashSet<String>(wordDict);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i&&!valid[i]; j++) {
                //从j到i的位置包含在set中，且j之前的位置均包含在set中，则可正常向后运行
                if (wordSet.contains(s.substring(j,i))&&valid[j]){
                    valid[i]=true;
                }
            }
        }
        return valid[len];
    }
}
