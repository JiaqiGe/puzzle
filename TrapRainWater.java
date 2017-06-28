// Given n non-negative integers representing an elevation map where the width of each bar is 1,
// compute how much water it is able to trap after raining.
//
// For example,
// Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class TrapRainWater{
    public int trap(int[] heights){
        if(heights.length <= 1){
            return 0;
        }

        int result = 0;

        //scan from left to right
        int start = 0;
        int end = 1;
        int volumn = 0;

        while(end < heights.length){
            if(heights[end] < heights[start]){
                volumn += heights[start] - heights[end];
                end++;
            }else{
                result +=  volumn;
                start = end;
                end ++;
                volumn = 0;
            }
        }

        //scan from right to left

        start = heights.length - 1;
        end = heights.length - 2;
        volumn = 0;
        while(end >= 0){
            if(heights[end] < heights[start]){
                volumn = heights[start] - heights[end];
                end --;
            }else{
                result += volumn;

                start = end;
                end --;
                volumn = 0;
            }
        }

        return result;
    }

    public static void main(String[] args){
        TrapRainWater t = new TrapRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
