// Implement strStr().
//
// Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
public class StrStr{
    public int strStr(String haystack, String needle) {
        if(haystack.isEmpty() || needle.isEmpty()){
            return -1;
        }

        if(needle.length() > haystack.length()){
            return -1;
        }

        for(int i = 0; i <= haystack.length() - needle.length(); i++){
            String s1 = haystack.substring(i, i+needle.length());
            if(s1.equals(needle)){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        StrStr s = new StrStr();
        System.out.println(s.strStr("ab","b"));
    }
}
