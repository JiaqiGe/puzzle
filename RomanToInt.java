import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
public int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        //initial map
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
                map.put(symbols[i], nums[i]);
        }

        // scan from left to right
        int result = 0;
        int i = 0;
        while(i < s.length()) {
          if(i + 1 < s.length() && map.containsKey(s.substring(i,i+2))){
            result += map.get(s.substring(i,i+2));
            i += 2;
          }else{
            result += map.get(Character.toString(s.charAt(i)));
            i++;
          }

        }

        return result;
}

public static void main(String[] args){
  RomanToInt r = new RomanToInt();
  System.out.println(r.romanToInt("X"));
}
}
