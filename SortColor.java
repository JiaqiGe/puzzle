// Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
//
// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
//
// Note:
// You are not suppose to use the library's sort function for this problem.
//
// click to show follow up.
//
// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
//
// Could you come up with an one-pass algorithm using only constant space?
// bug: line 34 "if" => "else if"
//      line 28 "<" => "<=": ending condition
//      line 35 : current ++ : when scan from left to right, no blue will exist behind current

public class SortColor{
    public void sortColors(int[] nums){
        //dutch flag problem
        if(nums.length <= 1){
            return;
        }

        int nextRed = 0;
        int nextBlue = nums.length - 1;
        int current = 0;

        while(current <= nextBlue){
            if(nums[current] == 0){
                //if current color is red
                //swap to nextRed
                swap(nums, current, nextRed);
                nextRed ++;
                current ++;
            }else if(nums[current] == 1){
                // if current color is white
                current ++;
            }else{
                // if current color is blue
                swap(nums, current, nextBlue);
                nextBlue--;
            }
        }
        return;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }

    public static void main(String[] args){
        SortColor s = new SortColor();
        int[] nums = new int[]{2,1,2,0,1,0};
        s.sortColors(nums);
        for(int i : nums){
            System.out.print(i);
        }
    }
}
