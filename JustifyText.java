// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
//
// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
//
// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
// For the last line of text, it should be left justified and no extra space is inserted between words.
//
// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.
//
// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.

import java.util.*;

public class JustifyText{
    public List<String> fullJustify(String[] words, int maxWidth){
        //edge case

        if(words.length == 0){
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        int start = 0;
        int end = 1;
        int length = words[start].length();

        while(end < words.length){
            if(length + 1 + words[end].length() < maxWidth){
                length = length + 1 + words[end].length();
            }else{
                result.add(format(words, start, end - 1, maxWidth));
                start = end;
                length = words[start].length();
            }

            end++;
        }

        result.add(formatLastLine(words, start, end-1, maxWidth));

        return result;
    }

    private String formatLastLine(String[] words, int start, int end, int maxWidth){
        StringBuffer sb = new StringBuffer();

        for(int i = start; i <= end; i++){
            sb.append(words[i]);
            if(i != end){
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private String format(String[] words, int start, int end, int maxWidth){
        int totalLength = 0;

        for(int i = start; i <= end; i++){
            totalLength += words[i].length();
        }

        int spaceLength = maxWidth - totalLength;


        if(start == end){
            //todo:
            int rightSpaceLength = spaceLength / 2;
            int leftSpaceLength = spaceLength - rightSpaceLength;
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < leftSpaceLength; i++){
                sb.append(' ');
            }

            sb.append(words[start]);

            for(int i = 0; i < rightSpaceLength; i++){
                sb.append(' ');
            }

            return sb.toString();
        }

        int avgSpaceLength = spaceLength / (end - start);

        int residualSpaceLength = spaceLength % (end - start);

        String[] spaces = new String[end-start];

        StringBuffer spaceAve = new StringBuffer();
        for(int i = 0; i < avgSpaceLength; i++){
            spaceAve.append(' ');
        }

        String space = spaceAve.toString();

        for(int i = 0; i < spaces.length; i++){
            if(i < residualSpaceLength){
                spaces[i] = space + ' ';
            }else{
                spaces[i] = space;
            }
        }

        StringBuffer result = new StringBuffer();
        for(int i = start; i <= end; i++){
            result.append(words[i]);
            if(i != end){
                result.append(spaces[i-start]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args){
        JustifyText j = new JustifyText();
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result = j.fullJustify(words, 16);
        for(String s : result){
            System.out.println(s);
        }
    }
}
