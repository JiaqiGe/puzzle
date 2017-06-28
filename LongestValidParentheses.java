// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// For "(()", the longest valid parentheses substring is "()", which has length = 2.
//
// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
import java.util.*;

public class LongestValidParentheses{
    public int LongestValidParentheses(String s){
        if(s.isEmpty()){
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int longestLength = 0;
        int accumulatedLength = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                int matchedLength = 0;

                if(stack.isEmpty()){
                    accumulatedLength = 0;
                }else{
                    int pos = stack.pop();
                    // matchedLength = (i - pos + 1);
                    if(stack.isEmpty()){
                        matchedLength = (i - pos + 1) + accumulatedLength;
                        accumulatedLength = matchedLength;
                    }else{
                        matchedLength = (i - stack.peek());
                    }
                    longestLength = Math.max(longestLength, matchedLength);
                }
            }
        }
        return longestLength;
    }

    public static void main(String[] args){
        String s = ")))((())()())";
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.LongestValidParentheses(s));
    }
}
