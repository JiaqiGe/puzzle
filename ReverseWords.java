// Given an input string, reverse the string word by word.
//
// For example,
// Given s = "the sky is blue",
// return "blue is sky the".
//
// Update (2015-02-12):
// For C programmers: Try to solve it in-place in O(1) space.
//
// click to show clarification.
//
// Clarification:
// What constitutes a word?
// A sequence of non-space characters constitutes a word.
// Could the input string contain leading or trailing spaces?
// Yes. However, your reversed string should not contain leading or trailing spaces.
// How about multiple spaces between two words?
// Reduce them to a single space in the reversed string.
import java.util.*;

public class ReverseWords {
    public String reverseWords(String s){
        if (s.isEmpty()){
            return "";
        }

        int          start = 0;
        int          end   = 0;
        List<String> result = new ArrayList<>();

        while (start < s.length()){
            if (s.charAt(start) == ' '){
                start++;
                end++;
            }else{
                if (end >= s.length() || s.charAt(end) == ' '){
                  result.add(0, s.substring(start, end));
                  start = end;
                }else{
                    end++;
                }
            }
        }

        if(result.isEmpty()){
          return "";
        }

        StringBuffer sb = new StringBuffer();
        for(String str : result){
          sb.append(str);
          sb.append(' ');
        }

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args){
      ReverseWords r = new ReverseWords();
      String s = " ";
      System.out.println(r.reverseWords(s));
    }
}
