// Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
//
//
// Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
//
//
// The largest rectangle is shown in the shaded area, which has area = 10 unit.
//
// For example,
// Given heights = [2,1,5,6,2,3],
// return 10.

import java.util.*;

public class LargestRectangle{
    public int largestRectangleArea(int[] heights) {
        //greedy
        // at any bar, calculate the largetst rectangle area when the curren bar is the most left edge
        // suppose i is the current bar, if height at i+1 is larget than that at i, rectangele of [i,i+1] is larger than i => greedy
        // another iteration to get the largest area where the current bar is the most right edge => reverse heights and redo step2

        if(heights.length == 0){
            return 0;
        }

        int[] areas = help(heights);

        int result = areas[0];
        for(int i = 1; i < areas.length; i++){
            result = Math.max(result, areas[i]);
        }

        int[] reverseHeights = new int[heights.length];
        for(int i = 0; i < heights.length; i++){
            reverseHeights[i] = heights[heights.length - 1 - i];
        }

        areas = help(reverseHeights);

        result = areas[0];
        for(int i = 1; i < areas.length; i++){
            result = Math.max(result, areas[i]);
        }

        return result;
    }

    private int[] help(int[] heights){
        int[] areas = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < heights.length; i++){
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
                int leftIndex = stack.pop();
                areas[leftIndex] = heights[leftIndex] * (i - leftIndex);
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            int leftIndex = stack.pop();
            areas[leftIndex] = heights[leftIndex] * (heights.length - leftIndex);
        }

        return areas;
    }

    public static void main(String[] args){
        LargestRectangle l = new LargestRectangle();
        int[] heights = new int[]{3,6,5};

        System.out.println(l.largestRectangleArea(heights));
    }
}
