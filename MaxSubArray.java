// Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
//
// For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
// the contiguous subarray [4,-1,2,1] has the largest sum = 6.
import java.util.*;

public class MaxSubArray{
    public int maxSubArray2(int[] nums){
        //divide & conquer

    }


    public int maxSubArray(int[] nums){
        if(nums.length == 0){
            return 0;
        }

        int maxAt = nums[0];
        int maxValue = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(maxAt > 0){
                maxAt += nums[i];
            }else{
                maxAt = nums[i];
            }
            maxValue = Math.max(maxValue, maxAt);
        }

        return maxValue;
    }

    public static void main(String[] args){
        MaxSubArray m = new MaxSubArray();
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(m.maxSubArray(nums));
    }
}
