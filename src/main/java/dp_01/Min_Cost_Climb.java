package dp_01;

public class Min_Cost_Climb {
    int totalCost=0;
    public int minCostClimbingStairs(int[] cost) {
        return getResult(cost);
    }
    private int getResult(int[] cost){
        int length=cost.length;
        if(length<=2){
            return min(cost[0],cost[1]);
        }
        //当前位置
        int current_site=length;
        while(current_site>=0){
            if(cost[current_site-1]<cost[current_site-2]){
                current_site-=1;
                totalCost+=cost[current_site-1];
            }else {
                current_site-=2;
                totalCost+=cost[current_site-2];
            }
            totalCost+=min(cost[current_site-1],cost[current_site-2]);
        }
        return totalCost;
    }
    private static int min(int a, int b){
        return a<b?a:b;
    }
}
