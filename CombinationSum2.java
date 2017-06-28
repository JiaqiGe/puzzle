// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// Each number in C may only be used once in the combination.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer> > combinationSum2(int[] candidates, int target){
        if (candidates.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(candidates);

        return combinationSumHelp(candidates, 0, target);
    }

    private List<List<Integer> > combinationSumHelp(int[] array, int i, int target){
        //recursion
        if (target == 0){
            return new ArrayList<>();
        }

        if ((i >= array.length) || (array[i] > target)){
            //no available solution
            return null;
        }

        //case 1: array[i] contributes to a solution
        List<List<Integer> > list1 = combinationSumHelp(array, i + 1, target - array[i]);

        List<List<Integer> > result = new ArrayList<>();

        if (list1 != null){
            if (list1.isEmpty()){
                List<Integer> oneList = new ArrayList<>();
                oneList.add(array[i]);
                list1.add(oneList);
            }else{
                for (List<Integer> oneList : list1){
                    oneList.add(array[i]);
                }
            }
            result.addAll(list1);
        }

        //case 2: array[i] does not contribute to a solution
        i++;
        while(i < array.length && array[i] == array[i-1]){i++;}

        List<List<Integer> > list2 = combinationSumHelp(array, i, target);


        if (list2 != null){
            result.addAll(list2);
        }

        return result.isEmpty() ? null : result;
    }

    public static void main(String[] args){
        CombinationSum2 c = new CombinationSum2();

        int[]                candidates = new int[] { 10, 1, 2, 7, 6, 1, 5 };
        List<List<Integer> > lists      = c.combinationSum2(candidates, 8);
        for (List<Integer> list : lists){
            for (int i : list){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
