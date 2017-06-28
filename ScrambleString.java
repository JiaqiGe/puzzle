
import java.util.*;

public class ScrambleString{
    public boolean isScramble(String s1, String s2) {
            if(s1.isEmpty() && s2.isEmpty()){
                return true;
            }

            if(s1.length() != s2.length()){
                return false;
            }

            if(s1.equals(s2)){
                return true;
            }

            boolean result = false;

            for(int i = 1; i < s1.length(); i++){
                String s11 = s1.substring(0,i);
                String s12 = s1.substring(i);

                if(signature(s11).equals(signature(s2.substring(0,i))) && signature(s12).equals(signature(s2.substring(i)))){
                    result = result || isScramble(s11, s2.substring(0,i)) && isScramble(s12, s2.substring(i));
                }else if(signature(s11).equals(signature(s2.substring(s2.length()-i))) && signature(s12).equals(signature(s2.substring(0, s2.length()-i)))){
                    result = result || isScramble(s11, s2.substring(s2.length()-i)) && isScramble(s12, s2.substring(0, s2.length()-i));
                }

                if(result){
                    return true;
                }
            }
            return result;
    }

    private String signature(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args){
        ScrambleString s = new ScrambleString();
        String s1 = "rgtae";
        String s2 = "great";
        System.out.println(s.isScramble(s1, s2));
    }


}
