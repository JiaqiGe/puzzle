// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// For example,
// [1,1,2] have the following unique permutations:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]


// ********
// extremely careful at how to deal with moving item from arraylist
// ********
import java.util.*;

public class PermutationTwo {
    public List<List<Integer>> permute(int[] nums){
        //dfs
        if (nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);

        List<List<Integer>> combs   = new ArrayList<>();
        List<Integer>       oneComb = new ArrayList<>();

        permuteHelp(toList(nums), oneComb, combs);
        return combs;
    }

    private List<Integer> toList(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i : nums){
            list.add(i);
        }
        return list;
    }

    private void permuteHelp(List<Integer> nums, List<Integer> oneComb, List<List<Integer>> combs){
        if (nums.isEmpty()){
            combs.add(new ArrayList<>(oneComb));
        }

        for (int i = 0; i < nums.size(); i++){
            if ((i > 0) && (nums.get(i) == nums.get(i - 1))){
                //avoid duplication
                continue;
            }

            int v = nums.get(i);
            oneComb.add(v);
            nums.remove(i);
            permuteHelp(nums, oneComb, combs);
            nums.add(i, v);
            oneComb.remove(oneComb.size() - 1);
        }
    })

    public static void main(String[] args){
        PermutationTwo p = new PermutationTwo();

        int[]               nums = new int[] { 1, 1, 2 };
        List<List<Integer>> r    = p.permute(nums);

        for (List<Integer> list : r){
            for (int i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
