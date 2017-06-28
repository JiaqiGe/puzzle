// Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
//
// (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
// You are given a target value to search. If found in the array return its index, otherwise return -1.
//
// You may assume no duplicate exists in the array.


public class SearchRotate{
    public int search(int[] nums, int target){
        //binary search with different strategy

        if(nums.length == 0){
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        int result = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(lo == hi){
                result = target == nums[mid] ? mid : -1;
                break;
            }

            if(nums[mid] == target){
                result = mid;
                break;
            }

            if(nums[mid] > nums[lo] && nums[mid] > nums[hi]){
                if(target < nums[mid] && target >= nums[lo]){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }else {
                if(target <= nums[hi] && target > nums[mid]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }

        return result;
    }

    public static void main(String[] args){
        int[] nums = new int[]{4,5,6,7,0,1,2};
        SearchRotate s = new SearchRotate();
        System.out.println(s.search(nums, 3));
    }
}
