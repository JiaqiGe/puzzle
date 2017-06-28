// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Here are few examples.
// [1,3,5,6], 5 → 2
// [1,3,5,6], 2 → 1
// [1,3,5,6], 7 → 4
// [1,3,5,6], 0 → 0

public class SearchInsertPosition{
    public int search(int[] nums, int target){
        if(nums.length == 0){
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(target == nums[mid]){
                return mid;
            }

            if(target < nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6};
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.search(nums, 5));
        System.out.println(s.search(nums, 2));
        System.out.println(s.search(nums, 7));
        System.out.println(s.search(nums, 0));

    }
}
