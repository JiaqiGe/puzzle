// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
// For example:
// A = [2,3,1,1,4], return true.
//
// A = [3,2,1,0,4], return false.

// one bug: true is overwrittern by false

public class JumpGame{
    public boolean canJump(int[] nums){
        //1-d dp
        if(nums.length <= 1){
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        dp[dp.length - 1] = true;

        for(int i = dp.length - 2; i >= 0; i--){
            int maxStep = nums[i];
            for(int j = i+1; j <= i + maxStep; j++){
                if(j >= nums.length || dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }

    public static void main(String[] args){
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(new int[]{3,2,1,0,4}));
    }
}
