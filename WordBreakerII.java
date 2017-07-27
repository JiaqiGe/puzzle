// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
//
// Return all such possible sentences.
//
// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].
//
// A solution is ["cats and dog", "cat sand dog"].
public class WordBreakerII {
    public List<String> wordBreak(String s, List<String> wordDict){
      if(s.isEmpty() || wordDict.isEmpty()){
        return new ArrayList<>();
      }

      Set<String> wordSet = new HashSet<>();
      wordSet.addAll(wordDict);

      List<String> comb = new ArrayList<>();
      List<String> combs = new ArrayList<>();

      help(s, wordSet, comb, combs);
      return combs;
    }

    private void help(String s, Set<String> wordSet, List<String> comb, List<String> combs){
      if(s.isEmpty()){
        StringBuffer sb = new StringBuffer();
        for(String str : comb){
          sb.append(str);
          sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        combs.add(sb.toString());
        return;
      }

      // dfs
      for(int i = 1; i <= s.length(); i++){
        String head = s.substring(0,i);
        String tail = s.substring(i);

        if(wordSet.contains(head)){
          comb.add(head);
          help(tail, wordSet, comb, combs);
          comb.remove(comb.size()-1);
        }
      }

      return;
    }
}
