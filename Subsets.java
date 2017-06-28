// Given a set of distinct integers, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,3], a solution is:
//
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
import java.util.*;

public class Subsets{
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }

        return subsetHelp(nums, 0);
    }

    private List<List<Integer>> subsetHelp(int[] nums, int k){
        List<List<Integer>> results = new ArrayList<>();

        //base
        if(k == nums.length){
            List<Integer> oneList = new ArrayList<>();
            results.add(oneList);
            return results;
        }

        //recursion

        List<List<Integer>> preSubsets = subsetHelp(nums, k+1);

        for(List<Integer> oneList : preSubsets){
            List<Integer> newList = new ArrayList<>(oneList);
            newList.add(0, nums[k]);
            results.add(newList);
        }
        results.addAll(preSubsets);

        return results;
    }

    public static void main(String[] args){
        Subsets s = new Subsets();
        List<List<Integer>> results = s.subsets(new int[]{1,2,3});

        for(List<Integer> oneList : results){
            System.out.print("[ ");
            for(int i : oneList){
                System.out.print(i + " ");
            }
            System.out.print("]");

            System.out.println();
        }

    }
}
