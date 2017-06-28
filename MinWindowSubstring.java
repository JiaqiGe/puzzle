// Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//
// For example,
// S = "ADOBECODEBANC"
// T = "ABC"
// Minimum window is "BANC".
//
// Note:
// If there is no such window in S that covers all characters in T, return the empty string "".
//
// If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
//

// bug: line 73: aftern find a minimal candidate, matchCount --  => remove s[left] from produer; otherwise, matchCount should not decrease

import java.util.*;

public class MinWindowSubstring{
    public String minWindow(String s, String t){
        if(s.isEmpty()){
            return "";
        }

        if(t.isEmpty()){
            return "";
        }

        //transform t to a map
        Map<Character, Integer> consumer = new HashMap<Character, Integer>();

        for(char c : t.toCharArray()){
            if(consumer.containsKey(c)){
                consumer.put(c, consumer.get(c) + 1);
            }else{
                consumer.put(c, 1);
            }
        }

        Map<Character, Integer> producer = new HashMap<>();

        int left = 0;
        int right = 0;
        int matchCount = 0;
        int minLength = Integer.MAX_VALUE;
        String result = "";

        while(right < s.length()){
            if(matchCount < consumer.size()){
                // if not found all characters
                // put character at right to producer
                char c = s.charAt(right);

                if(consumer.containsKey(c)){
                    if(producer.containsKey(c)){
                        producer.put(c, producer.get(c) + 1);
                    }else{
                        producer.put(c, 1);
                    }

                    if(producer.get(c) == consumer.get(c)){
                        matchCount ++;
                    }
                }
                right ++;
            }else {
                // if all characters are found in [left, right)
                // move left until find the minimal substring candidate
                char c = s.charAt(left);
                if(consumer.containsKey(c)){
                    if(producer.get(c) == consumer.get(c)){
                        if(right - left < minLength){
                            result = s.substring(left, right);
                            minLength = right - left;
                        }
                        producer.put(c, producer.get(c) - 1);
                        matchCount --;
                    }else if(producer.get(c) > consumer.get(c)){
                        producer.put(c, producer.get(c) - 1);
                    }
                }
                left ++;
            }
        }

        while(matchCount == consumer.size()){
            char c = s.charAt(left);
            if(consumer.containsKey(c)){
                if(producer.get(c) > consumer.get(c)){
                    producer.put(c, producer.get(c) - 1);
                }else if(producer.get(c) == consumer.get(c)){
                    if(right - left < minLength){
                        result = s.substring(left, right);
                        minLength = right - left;
                    }
                    matchCount --;
                }
            }
            left ++;
        }

        return result;
    }

    public static void main(String[] args){
        MinWindowSubstring m = new MinWindowSubstring();
        String s = "ADDEBDCDDEABOC";
        String t = "ABC";

        System.out.println(m.minWindow(s, t));
    }
}
