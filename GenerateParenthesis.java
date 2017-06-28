// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
// For example, given n = 3, a solution set is:
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]

import java.util.*;


public class GenerateParenthesis {
public List<String> generateParenthesis(int n) {
        if(n <= 0) {
                return new ArrayList<String>();
        }

        List<String> combs = new ArrayList<>();

        combinations(n, 0, 0, combs, "");
        return combs;
}

private void combinations(int n, int left, int right, List<String> combs, String pattern){
        if(left == n && right == n) {
                combs.add(pattern);
                return;
        }

        if(left == right) {
                combinations(n, left+1, right, combs, pattern + "(");
        }

        if(left > right) {
                combinations(n, left, right+1, combs, pattern+")");

                if(left < n) {
                        combinations(n, left+1, right, combs, pattern+"(");
                }
        }

}

public static void main(String[] args){
        GenerateParenthesis g = new GenerateParenthesis();
        System.out.println(g.generateParenthesis(3));
}
}
