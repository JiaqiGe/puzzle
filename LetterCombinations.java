// Given a digit string, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below.
// Input:Digit string "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
import java.util.*;


public class LetterCombinations{
  public List<String> letterCombinations(String digits){

      List<String> result = new ArrayList<>();

      if(digits.isEmpty()){
        return result;
      }

      Map<Character, String> map = new HashMap<>();
      map.put('2',"abc");
      map.put('3',"def");
      map.put('4',"ghi");
      map.put('5',"jkl");
      map.put('6',"mno");
      map.put('7',"pqrs");
      map.put('8',"tuv");
      map.put('9',"wxyz");

      //recursion
      return combinations(digits, map);

  }

  private List<String> combinations(String digits, Map<Character, String> map){
    //base
    if(digits.isEmpty()){
      return new ArrayList<String>();
    }

    //recursive function
    List<String> result = new ArrayList<>();
    List<String> preCombs = combinations(digits.substring(1), map);

    String curWord = map.get(digits.charAt(0));
    for(int i = 0; i < curWord.length(); i++){
        if(preCombs.isEmpty()){
          result.add(Character.toString(curWord.charAt(i)));
        }else{
          for(String s : preCombs){
            result.add(curWord.charAt(i) + s);
          }
        }
    }
    return result;
  }

  public static void main(String[] args){
    LetterCombinations l = new LetterCombinations();
    System.out.println(l.letterCombinations("23"));
  }
}
