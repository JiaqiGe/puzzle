// Given an unsorted integer array, find the first missing positive integer.
//
// For example,
// Given [1,2,0] return 3,
// and [3,4,-1,1] return 2.
//
// Your algorithm should run in O(n) time and uses constant space.
public class FirstMissingPositive{
    public int firstMissingPositive(int[] nums){
        // count sort
        // attention!!!!
        // always use swap function to do swap

        if(nums.length == 0){
            return 1;
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                continue;
            }

            if(nums[i] - 1 == i){
                continue;
            }else{
                // swap nums[i] and nums[nums[i] - 1]
                swap(nums, i, nums[i] - 1);
                i--;
            }
        }

        int result = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                result = i+1;
                break;
            }
        }

        return result;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args){
        FirstMissingPositive f = new FirstMissingPositive();
        int[] nums = new int[]{3,4,-1,1};
        System.out.println(f.firstMissingPositive(nums));
    }
}
