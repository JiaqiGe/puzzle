// Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
//
// For example,
// Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
//
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7
// Therefore, return the max sliding window as [3,3,5,5,6,7].
import java.util.*;

public class SlidingWindowMaximum{
  public int[] maxSlidingWindow(int[] nums, int k){
    int[] max = new int[nums.length - k + 1];

    Deque<Integer> deque = new LinkedList<>();
    // initialize
    for(int i = 0; i < k; i++){
      while(!deque.isEmpty() && deque.peekLast() < nums[i]){
        deque.pollLast();
      }
      deque.offerLast(i);
    }

    for(int i = k; i < nums.length; i++){
        int idx = deque.peekFirst();
        // update max at i-k
        max[i-k] = nums[idx];

        // remove if the first element at i-k is the max value within window
        if(idx == i-k){
          deque.pollFirst();
        }

        // in-queue the ith element
        while(!deque.isEmpty() && deque.peekLast() < nums[i]){
          deque.pollLast();
        }

        deque.offerLast(i);
    }

    max[max.length - 1] = nums[deque.peekFirst()];
    return max;
  }

  public static void main(String[] args){
    int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
    int k = 3;
    SlidingWindowMaximum s = new SlidingWindowMaximum();
    int[] max = s.maxSlidingWindow(nums, k);
    for(int i : max){
      System.out.println(i);

    }
  }
}
