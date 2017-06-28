// Given an absolute path for a file (Unix-style), simplify it.
//
// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.
//
// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

import java.util.*;

public class SimplifyPath{
    public String simplifyPath(String path){
        if(path.isEmpty()){
            return "";
        }

        String[] elements = path.split("/");
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < elements.length; i++){
            String element = elements[i];

            if(!element.isEmpty() && !element.equals(".")){
                if(element.equals("..")){
                    if(!stack.isEmpty()){
                        stack.pop();
                    }
                }else{
                    stack.push(element);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            String element = stack.pop();
            sb.insert(0, "/"+element);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        SimplifyPath s = new SimplifyPath();
        String t = "/../";
        System.out.println(s.simplifyPath(t));

    }
}
