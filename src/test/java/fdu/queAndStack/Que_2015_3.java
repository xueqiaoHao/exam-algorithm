package fdu.queAndStack;

import org.junit.Test;

import java.util.*;

/**
 * Description  TODO
 * 【2015-3】优先队列
 题目描述：给出优先队列的实现，实现4个操作

 • ADD（N,P）：往队列里加入id为N的优先级为P的任务
 • NEXT:输出下一个最高优先级的任务的id，如果优先级相同输出id小的任务，若队列中没有任务输出-1   ---约束的是大根堆实现中的比较器
 • REMOVE（N）：移除id为N的任务
 • COUNT：输出队列中的任务数量
 输入样例：

 10
 ADD 1 1
 ADD 2 3
 ADD 3 2
 ADD 4 3
 NEXT
 REMOVE 3
 COUNT
 NEXT
 NEXT
 NEXT

 输出样例：

 2
 2
 4
 1
 -1

 * Author hao
 * Date 2023/3/18 13:47
 */
public class Que_2015_3 {
    //用一个优先级队列来实现
    private static PriorityQueue<int[]> pq = new PriorityQueue<>(
            (o1, o2) -> {
                //返回正数，交换位置，返回负数，不交换
                //先按照优先级比，然后按照id
                return (o1[1] - o2[1] != 0) ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
            }
    );
    //存储任务id 与队列中任务数组的对应关系
    private static Map<Integer,int[]> map =new HashMap<>();


    @Test
    public void process(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        while (scanner.hasNext()){
//
////        }
        for (int i = 0; i < n; i++) {
            //输入的每行第一个元素是字符

            String s = scanner.next();
            switch (s) {
                case "ADD": {
                    int id = scanner.nextInt();
                    int priority = scanner.nextInt();
                    add(id, priority);
                    break;
                }
                case "NEXT":
                    System.out.println(next());
                    break;
                case "REMOVE": {
                    int id = scanner.nextInt();
                    remove(id);
                    break;
                }
                case "COUNT":
                    System.out.println(count());
                    break;
            }
        }
    }

    /*
     * @Description //TODO  队列中加入id为n优先级为p的任务
     * @Date 14:17 2023/3/18
     * @param id
     * @param priority

     **/
    private static void add(int id,int priority){
        int[] taskArr = {id, priority};
        pq.offer(taskArr);
        map.put(id,taskArr);
    }

    private static int next(){
        return !pq.isEmpty()?pq.poll()[0]:-1;
    }

    private static void remove(int id){
        pq.remove(map.get(id));
    }
    
    private static int count(){
        return !pq.isEmpty()?pq.size():-1;
    }
}
