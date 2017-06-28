// Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
//
// If the last word does not exist, return 0.
//
// Note: A word is defined as a character sequence consists of non-space characters only.
//
// For example,
// Given s = "Hello World",
// return 5.
//
public class LengthLastWord{
    public int lengthOfLastWord(String s){
        if(s.isEmpty()){
            return 0;
        }

        int end = s.length() - 1;

        while(end >= 0){
            //find the first non-empty characters; backward
            if(s.charAt(end) != ' '){
                break;
            }
            end --;
        }

        int start = end - 1;
        while(start >= 0){
            //find the first empty character; backward
            if(s.charAt(start) == ' '){
                break;
            }
            start --;
        }

        if(end < 0){
            return 0;
        }

        return end - start;
    }

    public static void main(String[] args){
        String s = "hello world ";
        LengthLastWord l = new LengthLastWord();
        System.out.println(l.lengthOfLastWord(s));
    }

}
