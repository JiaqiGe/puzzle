//
// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
// The order of output does not matter.
//
// Example 1:
//
// Input:
// s: "cbaebabacd" p: "abc"
//
// Output:
// [0, 6]
//
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:
//
// Input:
// s: "abab" p: "ab"
//
// Output:
// [0, 1, 2]
//
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
import java.util.*;

public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p){
        if (s.isEmpty() || p.isEmpty()){
            return new ArrayList<>();
        }

        char[] c = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int[]  v = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < c.length; i++){
          map.put(c[i],v[i]);
        }

        List<Integer> result = new ArrayList<>();

        int pHash = hash(p, map);
        int firstWindowHash = hash(s.substring(0, p.length()), map);
        if(firstWindowHash == pHash){
          result.add(0);
        }

        int preWindowHash = firstWindowHash;
        for(int i = 1; i < s.length() - p.length() + 1; i++){
            char toRemoveChar = s.charAt(i-1);
            char toAddChar = s.charAt(i+p.length()-1);

            int windowHash = preWindowHash / map.get(toRemoveChar) * map.get(toAddChar);
            if(windowHash == pHash){
              result.add(i);
            }
            preWindowHash = windowHash;
        }
        return result;
    }

    private int hash(String s, Map<Character, Integer> map){
        int result = 1;
        for(int i = 0; i < s.length(); i++){
          result *= map.get(s.charAt(i));
        }
        return result;
    }

    public static void main(String[] args){
      FindAllAnagram f = new FindAllAnagram();
      String s = "cbaebabacd";
      String p = "abc";

      List<Integer> result = f.findAnagrams(s, p);
      for(int i : result){
        System.out.print(i+" ");
      }
    }
}
