// You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
//
// For example, given:
// s: "barfoothefoobarman"
// words: ["foo", "bar"]
//
// You should return the indices: [0,9].
import java.util.*;


public class SubstringConcatenateWords {
   public List<Integer> findSubstring(String s, String[] words){
      if ((words.length == 0) || (s.length() == 0)){
         return new ArrayList<Integer>();
      }

      //build two maps: toConsume and toProduce for words
      Map<String, Integer> producer = buildMap(words);

      List<Integer> result = new ArrayList<>();
      for (int i = 0; i <= s.length() - words[0].length(); i++){
         Map<String, Integer> consumer = new HashMap<>();
         if (isMatch(consumer, producer, s, i, words[0].length(), words.length)){
            result.add(i);
         }
      }
      return result;
   }

   private boolean isMatch(Map<String, Integer> consumer, Map<String, Integer> producer, String s, int start, int unitSize, int numOfWords){
      int     matchCount = 0;
      boolean isMatch    = false;

      for (int i = start; i + unitSize <= s.length(); i += unitSize){
         String str = s.substring(i, i + unitSize);
         if (producer.containsKey(str)){
            if (consumer.containsKey(str)){
               if (producer.get(str) > consumer.get(str)){
                  consumer.put(str, consumer.get(str) + 1);
               }else{
                  break;
               }
            }else{
               consumer.put(str, 1);
            }

            matchCount++;
            if (matchCount == numOfWords){
               isMatch = true;
               break;
            }
         }else{
            break;
         }
      }
      return isMatch;
   }

   private Map<String, Integer> buildMap(String[] words){
      Map<String, Integer> map = new HashMap<>();
      for (String word : words){
         if (map.containsKey(word)){
            map.put(word, map.get(word) + 1);
         }else{
            map.put(word, 1);
         }
      }
      return map;
   }

   public static void main(String[] args){
      String s = "barfoothefoobarman";

      String[] words = new String[] { "foo", "bar" };
      SubstringConcatenateWords sscw   = new SubstringConcatenateWords();
      List<Integer>             result = sscw.findSubstring(s, words);
      for (int i : result){
         System.out.println(i);
      }
   }
}
