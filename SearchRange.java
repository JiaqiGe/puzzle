// Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// For example,
// Given [5, 7, 7, 8, 8, 10] and target value 8,
// return [3, 4].

public class SearchRange{
    public int[] search(int[] nums, int target){
        if(nums.length == 0){
            return new int[]{-1,-1};
        }

        int[] result = new int[]{-1, -1};
        result[0] = searchLeft(nums, target);
        result[1] = searchRight(nums, target);

        return result;
    }

    private int searchLeft(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;

        int pos = -1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(target == nums[mid]){
                if(mid == 0 || nums[mid-1] != nums[mid]){
                    pos = mid;
                    break;
                }else{
                    hi = mid -1;
                }
            }else if (target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }

        return pos;
    }

    private int searchRight(int[] nums, int target){
        int lo = 0;
        int hi = nums.length - 1;
        int pos = -1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(target == nums[mid]){
                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]){
                    pos = mid;
                    break;
                }else{
                    lo = mid + 1;
                }
            }else if(target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return pos;
    }

    public static void main(String[] args){
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        SearchRange s = new SearchRange();
        int[] r = s.search(nums, 8);
        for(int i : r){
            System.out.println(i);
        }
    }
}
