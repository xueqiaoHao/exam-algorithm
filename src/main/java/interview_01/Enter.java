package interview_01;

import java.util.HashMap;

/**
 * @Description TODO 调用入口类
 * @Author hao
 * @Date 2023/2/7 17:05
 */
public class Enter {

    public static void main(String[] args) {
        HashMap<User,String> hashMap=new HashMap<User, String>();
        hashMap.put(new User("todo"),"go");
        System.out.println(hashMap.get(new User("todo")));
    }
}
