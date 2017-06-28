// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// For example:
// Given array A = [2,3,1,1,4]
//
// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
//
// Note:
// You can assume that you can always reach the last index.
import java.util.*;

public class JumpGameTwo{
    public int jump(int[] nums){
        //dfs + memorize
        if(nums.length == 0){
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();

        return jumpHelp(nums, 0, map);
    }

    private int jumpHelp(int[] nums, int index, Map<Integer, Integer> map){
        if(index == nums.length - 1){
            return 0;
        }

        if(index >= nums.length){
            // indicates that beyond the end
            return Integer.MAX_VALUE;
        }
        int minSteps = Integer.MAX_VALUE;

        for(int i = 1; i <= nums[index]; i++){
            if(map.containsKey(index+i)){
                minSteps = Math.min(minSteps, map.get(index+i)+1);
            }else{
                minSteps = Math.min(minSteps, jumpHelp(nums, index+i, map)+1);
            }
        }

        map.put(index, minSteps);
        return minSteps;
    }

    public static void main(String[] args){
        JumpGameTwo j = new JumpGameTwo();
        int[] nums = new int[]{2,3,1,1,4};
        System.out.println(j.jump(nums));
    }
}
