// You are climbing a stair case. It takes n steps to reach to the top.
//
// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// Note: Given n will be a positive integer.

public class ClimbChair{
    public int climStairs(int n){


        //1-d dp
        int[] dp = new int[n+1];


        //initial
        dp[dp.length - 1] = 1;
        dp[dp.length - 2] = 1;

        for(int i = dp.length - 3; i >= 0; i--){
                dp[i] = dp[i+1] + dp[i+2];
        }

        return dp[0];
    }

    public static void main(String[] args){
        ClimbChair c = new ClimbChair();
        System.out.println(c.climStairs(2));
    }
}
