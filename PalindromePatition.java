// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// For example, given s = "aab",
// Return
//
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
import java.util.*;

public class PalindromePatition {
    public List<List<String>> partition(String s){
        // dfs
        if (s.isEmpty()){
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= s.length(); i++){
            String head = s.substring(0, i);
            String tail = s.substring(i);

            if (isPalindrome(head)){
                // dfs
                List<List<String>> preLists = partition(tail);
                if (preLists.isEmpty()){
                    List<String> list = new ArrayList<>();
                    list.add(head);
                    preLists.add(list);
                }else{
                    for (List<String> oneList : preLists){
                        oneList.add(0, head);
                    }
                }
                result.addAll(preLists);
            }
        }
        return result;
    }

    private boolean isPalindrome(String s){
      if(s.isEmpty()){
        return true;
      }

      int i = 0;
      int j = s.length()-1;

      while(i < j){
        if(s.charAt(i) != s.charAt(j)){
          return false;
        }

        i++;
        j--;
      }

      return true;
    }

    public static void main(String[] args){
        PalindromePatition p = new PalindromePatition();

        List<List<String>> result = p.partition("aab");
        for (List<String> oneList : result){
            for (String str : oneList){
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
