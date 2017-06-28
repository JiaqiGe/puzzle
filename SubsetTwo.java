// Given a collection of integers that might contain duplicates, nums, return all possible subsets.
//
// Note: The solution set must not contain duplicate subsets.
//
// For example,
// If nums = [1,2,2], a solution is:
//
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
import java.util.*;

public class SubsetTwo {
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        //recursion
        return help(nums, 0);
    }

    private List<List<Integer>> help(int[] nums, int idx){
        List<List<Integer>> result = new ArrayList<>();
        //base
        if (idx == nums.length){
            List<Integer> oneList = new ArrayList<>();
            result.add(oneList);
            return result;
        }

        //revisive function
        int i = idx+1;
        while (i < nums.length && nums[i] == nums[idx]){
            i++;
        }

        List<List<Integer>> preResult = help(nums, i);
        for (List<Integer> oneList : preResult){
            result.add(oneList);

            List<Integer> listCopy = new ArrayList<>(oneList);
            for (int j = idx; j < i; j++){
              listCopy.add(0,nums[j]);
              List<Integer> toAddList = new ArrayList<>(listCopy);
              result.add(toAddList);
            }
        }

        return result;
    }

    public static void main(String[] args){
      SubsetTwo s = new SubsetTwo();
      int[] nums = new int[]{1,2,2};
      List<List<Integer>> r = s.subsetsWithDup(nums);
      for(List<Integer> oneList : r){
        if(oneList.isEmpty()){
          System.out.print("[]");
        }else{
          System.out.print("[");
          for(int k : oneList){
            System.out.print(k+" ");
          }
          System.out.print("]");
        }

        System.out.println();
      }
    }
}
