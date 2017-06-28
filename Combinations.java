// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// For example,
// If n = 4 and k = 2, a solution is:
//
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
import java.util.*;

public class Combinations{
    public List<List<Integer>> combine(int n, int k){
        if(k > n){
            return new ArrayList<>();
        }

        return combineHelp(1, n, k);
    }

    private List<List<Integer>> combineHelp(int start, int end, int k){
        List<List<Integer>> result = new ArrayList<>();
        //base
        if(end - start + 1 == k){
            List<Integer> list = new ArrayList<>();
            for(int i = start; i <= end; i++){
                list.add(i);
            }
            result.add(list);
            return result;
        }

        if(k == 1){
            for(int i = start; i <= end; i++){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                result.add(list);
            }

            return result;
        }

        // recursion
        // two possible cases:
        // (1) start is in the combinations
        // (2) start is not in the combinations

        result.addAll(combineHelp(start + 1, end, k));

        List<List<Integer>> preResults = combineHelp(start+1, end, k-1);
        for(List<Integer> oneList : preResults){
            oneList.add(0, start);
            result.add(oneList);
        }

        return result;
    }

    public static void main(String[] args){
        Combinations c = new Combinations();
        List<List<Integer>> result = c.combine(5,2);
        for(List<Integer> oneList : result){
            for(int i : oneList){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
