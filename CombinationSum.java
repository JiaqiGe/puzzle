// Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
// The same repeated number may be chosen from C unlimited number of times.
//
// Note:
// All numbers (including target) will be positive integers.
// The solution set must not contain duplicate combinations.
// For example, given candidate set [2, 3, 6, 7] and target 7,
// A solution set is:
// [
//   [7],
//   [2, 2, 3]
// ]



import java.util.*;

public class CombinationSum {
    public List<List<Integer> > combinationSum2(int[] candidates, int target){
        //dfs
        if(candidates.length == 0){
            return new ArrayList<>();
        }

        Arrays.sort(candidates);
        List<Integer> oneComb = new ArrayList<>();
        List<List<Integer>> combs = new ArrayList<>();

        combinationSumHelp2(candidates, 0, oneComb,combs, target);
        return combs;
    }

    private void combinationSumHelp2(int[] array, int i, List<Integer> oneComb, List<List<Integer>> combs, int target){
        if(target == 0){
            List<Integer> list = new ArrayList<>(oneComb);
            combs.add(list);
        }

        if(i >= array.length || array[i] > target){
            return;
        }

        //case 1: array[i] contributes to oneComb
        oneComb.add(array[i]);
        combinationSumHelp2(array, i, oneComb, combs, target - array[i]);
        oneComb.remove(oneComb.size()-1);

        //case 2: array[i] does not contribute to oneComb
        i++;
        while(i < array.length && array[i] == array[i-1]){i++;}
        combinationSumHelp2(array, i, oneComb, combs, target);

        return;
    }

    public List<List<Integer> > combinationSum(int[] candidates, int target){
        // recursion: use null to indicate that no solution yet
        // pay attention to base condition; pay attention to return type; check null

        if (candidates.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(candidates);

        return combinationSumHelp(candidates, 0, target);
    }

    private List<List<Integer> > combinationSumHelp(int[] array, int i, int target){
        if (target == 0){
            return new ArrayList<List<Integer> >();
        }

        if (i >= array.length){
            return null;
        }

        if (array[i] > target){
            return null;
        }

        //case 1: array[i] is one of the list
        List<List<Integer> > list1 = combinationSumHelp(array, i, target - array[i]);
        List<List<Integer> > result = new ArrayList<>();

        if (list1 != null){
            if (!list1.isEmpty()){
                for (List<Integer> oneList : list1){
                    oneList.add(array[i]);
                }
            }else{
                List<Integer> oneList = new ArrayList<>();
                oneList.add(array[i]);
                list1.add(oneList);
            }
            result.addAll(list1);
        }
        //case 2: array[i] is not one of the list
        i++;
        while(i < array.length && array[i] == array[i-1]){i++;}

        List<List<Integer> > list2 = combinationSumHelp(array, i, target);

        if (list2 != null){
            result.addAll(list2);
        }
        return result.isEmpty() ? null : result;
    }

    public static void main(String[] args){
        int[]                candidates = new int[] {10, 1, 2, 7, 6, 1, 5 };
        CombinationSum       c          = new CombinationSum();
        List<List<Integer> > lists      = c.combinationSum(candidates, 8);
        for (List<Integer> list : lists){
            for (int i : list){
                System.out.print(i);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
