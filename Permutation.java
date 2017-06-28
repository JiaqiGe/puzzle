// Given a collection of distinct numbers, return all possible permutations.
//
// For example,
// [1,2,3] have the following permutations:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
import java.util.*;

public class Permutation{
    public List<List<Integer>> permute(int[] nums){
        //recursion
        if(nums.length == 0){
            return new ArrayList<>();
        }

        return permuteHelp(nums, 0);
    }

    private List<List<Integer>> permuteHelp(int[] nums, int index){
        //base
        if(index >= nums.length){
            return new ArrayList<>();
        }

        //recursive function
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> preLists = permuteHelp(nums, index+1);

        if(preLists.isEmpty()){
            List<Integer> oneList = new ArrayList<>();
            oneList.add(nums[index]);
            result.add(oneList);
        }else{
            for(List<Integer> oneList : preLists){
                //insert nums[index] to every possible position
                for(int i = 0; i <= oneList.size();i++){
                    oneList.add(i, nums[index]);
                    result.add(new ArrayList<>(oneList));
                    oneList.remove(i);
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        Permutation p = new Permutation();
        List<List<Integer>> lists = p.permute(new int[]{1,2,3});

        for(List<Integer> oneList : lists){
            for(int i : oneList){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
