// Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers.
// You may assume that each input would have exactly one solution.
//
//     For example, given array S = {-1 2 1 -4}, and target = 1.
//
//     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
import java.util.*;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
          return 0;
        }

        int result = 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
           int sum = nums[i] + findClosestTwo(nums, i+1, target-nums[i]);
           if(Math.abs(sum - target) < diff){
             diff = Math.abs(sum - target);
             result = sum;
           }
        }

        return result;
    }

    private int findClosestTwo(int[] nums, int start, int target){
      int lo = start;
      int hi = nums.length - 1;

      int result = 0;
      int diff = Integer.MAX_VALUE;
      while(lo < hi){
        int sum = nums[lo] + nums[hi];
        if(sum == target){
          return target;
        }else if (sum < target){
          if(target - sum < diff){
            diff = target - sum;
            result = sum;
          }
          lo ++;
        }else{
          if(sum - target < diff){
            diff = sum - target;
            result = sum;
          }
          hi --;
        }
      }
      return result;
    }

    public static void main(String[] args){
      int[] nums = {-1, 2, 1, -4};
      ThreeSumClosest t = new ThreeSumClosest();
      System.out.println(t.threeSumClosest(nums, 1));
    }
}
