// Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note: The solution set must not contain duplicate quadruplets.
//
// For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
import java.util.*;


public class FourSum {
public List<List<Integer> > fourSum(int[] nums, int target){
        List<List<Integer> > result = new ArrayList<>();
        if(nums.length < 4) {
                return result;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
                for(int j = i+1; j < nums.length - 2; j++) {
                        if(j > i+1 && nums[j] == nums[j-1]) {
                                continue;
                        }

                        int lo = j+1;
                        int hi = nums.length - 1;

                        while(lo < hi) {
                                if(lo > j+1 && nums[lo] == nums[lo-1]) {
                                        lo++;
                                        continue;
                                }

                                if(hi < nums.length - 1 && nums[hi] == nums[hi - 1]) {
                                        hi--;
                                        continue;
                                }

                                int twoSum = nums[lo] + nums[hi];
                                int twoTarget = target - nums[i] - nums[j];
                                if(twoSum == twoTarget) {
                                        List<Integer> oneList = new ArrayList<>();
                                        oneList.add(nums[i]);
                                        oneList.add(nums[j]);
                                        oneList.add(nums[lo]);
                                        oneList.add(nums[hi]);
                                        result.add(oneList);
                                        lo++;
                                        hi--;
                                }else if(twoSum < twoTarget) {
                                        lo++;
                                }else{
                                        hi--;
                                }
                        }
                }
        }
        return result;
}

public static void main(String[]  args){
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        FourSum f = new FourSum();
        System.out.println(f.fourSum(nums, target));
}
}
