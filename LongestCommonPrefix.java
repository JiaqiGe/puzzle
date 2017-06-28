public class LongestCommonPrefix {
public String longestCommonPrefix(String[] strs){
    if(strs.length == 0){
      return "";
    }

    int length = Integer.MAX_VALUE;
    for(String str : strs){
      length = Math.min(length, str.length());
    }

    StringBuilder sb = new StringBuilder();
    int i = 0;
    while(i < length){
      char c = strs[0].charAt(i);
      for(int j = 1; j < strs.length; j++){
        if(c != strs[j].charAt(i)){
          return sb.toString();
        }
      }

      sb.append(c);
      i++;
    }
    return sb.toString();
}

public static void main(String[] args){
        String s1 = "ab";
        String s2 = "ac";
        String[] strs = {"abc","abcd",""};
        LongestCommonPrefix l = new LongestCommonPrefix();
        System.out.println(l.longestCommonPrefix(strs));
}
}
