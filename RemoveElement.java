// Given an array and a value, remove all instances of that value in place and return the new length.
//
// Do not allocate extra space for another array, you must do this in place with constant memory.
//
// The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
// Example:
// Given input array nums = [3,2,2,3], val = 3
//
// Your function should return length = 2, with the first two elements of nums being 2.

public class RemoveElement{
    public int removeElement(int[] nums, int k){
        int lo = 0;
        int hi =  nums.length - 1;

        while(lo < hi){
            if(nums[lo] == k){
                if(nums[hi] == k){
                    hi--;
                }else{
                    nums[lo] = nums[hi];
                    hi--;
                    lo++;
                }
            }else{
                lo++;
            }
        }

        return hi + 1;
    }

    public static void main(String[] args){
        int[] nums = {3,2,2,3};
        RemoveElement r = new RemoveElement();
        System.out.println(r.removeElement(nums, 4));
    }
}