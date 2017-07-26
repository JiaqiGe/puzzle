// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.


// if (s == null || s.length() == 0){
//     return 0;
// }
// // two points: start & end
// // end ++ until found repeated character
// // start++ until no repeated character between start and end
//
// Map<Character, Integer> map = new HashMap<Character, Integer>();
//
// map.put(s.charAt(0), 0);
//
// int start = 0;
// int end = 1;
//
// int maxLength = 1;
// int length = 1;
// while(start < s.length() && end < s.length()){
//     char cur = s.charAt(end);
//     if(!map.containsKey(cur) || map.get(cur) < start){
//         //no repeated
//         length = end - start + 1;
//         maxLength = Math.max(maxLength, length);
//
//         map.put(cur, end);
//         end ++;
//     }else{
//         //find repeated character
//         start = map.get(cur) + 1;
//     }
// }
//
// return maxLength;

import java.util.*;

public class LongestSubstringWithoutRepeatCharacter {
    public int lengthOfLongestSubstring(String s){
      if(s.length() <= 1){
        return s.length();
      }


      int lo = 0;
      int hi = 0;

      int maxLength = 0;
      Map<Character, Integer> map = new HashMap<>();

      while(hi < s.length()){
        char c = s.charAt(hi);
        if(!map.containsKey(c)){
          map.put(c, hi);
          hi++;
        }else{
          if(map.get(c) < lo){
            map.put(c, hi);
            hi++;
          }else{
            map.put(c, hi);
            maxLength = Math.max(maxLength, hi - lo);
            lo = map.get(c) + 1;
            hi++;
          }
        }
      }

      maxLength = Math.max(maxLength, hi - lo);
      return maxLength;
    }
}
