// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
//
// For example, given
// s = "leetcode",
// dict = ["leet", "code"].
//
// Return true because "leetcode" can be segmented as "leet code".

public class WordBreaker {
    public boolean wordBreak(String s, List<String> wordDict){
        if (s.isEmpty()){
            return true;
        }

        if (wordDict.isEmpty()){
            return false;
        }

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);

        Map<String, Boolean> map = new HashMap<>();

        return help(s, wordSet, map);
    }

    private boolean help(String s, Set<String> wordSet, Map<String, Boolean> map){
        // base
        if (s.isEmpty()){
            return true;
        }

        // dfs
        boolean result = false;
        for (int i = 1; i <= s.length(); i++){
            String head = s.substring(0, i);
            String tail = s.substring(i);

            if (wordSet.contain(head)){
                if (map.containsKey(tail)){
                    result = result || map.get(tail);
                }else{
                    result = result || help(tail, wordSet, map);
                }

                if (result){
                    break;
                }
            }
        }
        map.put(s, result);
        return result;
    }
}
