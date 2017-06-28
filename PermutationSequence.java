
// The set [1,2,3,…,n] contains a total of n! unique permutations.
//
// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):
//
// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.
// Note: Given n will be between 1 and 9 inclusive.

//bug:  line 41 => when update k, do not forget times the factor

import java.util.*;

public class PermutationSequence{
    public String getPermutation(int n, int k){
        //edge case
        if(k < 1 || k > fac(n)){
            return "";
        }

        //1. all permutations can be divided into n groups by the starting number
        // each group contains fac(n-1) permutations
        List<Integer> v = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 1; i <= n; i++){
            v.add(i);
        }

        int i = 1;
        while(i < n){
            int idx = (k-1) / fac(n-i);
            result.add(v.get(idx));
            v.remove(idx);
            k = k - ((k-1) / fac(n-i))*fac(n-i);
            i++;
        }

        result.add(v.get(0));

        StringBuffer sb = new StringBuffer();
        for(int digit : result){
            sb.append(digit);
        }

        return sb.toString();
    }

    private int fac(int n){
        if(n == 1){
            return 1;
        }

        return n*fac(n-1);
    }

    public static void main(String[] args){
        PermutationSequence p = new PermutationSequence();
        int n = 4;
        int k = 3;
        System.out.println(p.getPermutation(n,k));
    }
}
