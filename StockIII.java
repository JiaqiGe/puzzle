//
// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete at most two transactions.
//
// Note:
// You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
//
// attention! from algorithm to code => use something to help -- graph, figure, to avoid bugs
import java.util.*;

public class StockIII {
    public int maxProfit(int[] prices){
        if (prices.length < 2){
            return 0;
        }
        // from left to right, compute the maxProfit at i
        int[] leftProfit = new int[prices.length];
        int leftMin = prices[0];
        int leftMaxProfit = 0;
        for(int i = 1; i < prices.length; i++){
          if(prices[i] > leftMin){
            int candidate = prices[i] - leftMin;
            leftMaxProfit = Math.max(candidate, leftMaxProfit);
          }
          leftProfit[i] = leftMaxProfit;
          leftMin = Math.min(leftMin, prices[i]);
        }

        // from right to left, compute the maxProfit at i
        int[] rightProfit = new int[prices.length];
        int rightMax = prices[prices.length - 1];
        int rightMaxProfit = 0;
        for(int i = prices.length - 2; i >= 0; i--){
          if(prices[i] < rightMax){
            int candidate = rightMax - prices[i];
            rightMaxProfit = Math.max(candidate, rightMaxProfit);
          }
          rightProfit[i] = rightMaxProfit;
          rightMax = Math.max(rightMax, prices[i]);
        }

        int maxProfit = leftProfit[leftProfit.length-1];
        for(int i = 0; i < prices.length - 1; i++){
          int candidate = leftProfit[i] + rightProfit[i+1];
          maxProfit = Math.max(maxProfit, candidate);
        }

        return maxProfit;
    }

    public static void main(String[] args){
        StockIII s = new StockIII();

        int[] prices = new int[] {2,1,2,1,0,0,1};
        System.out.println(s.maxProfit(prices));
    }
}
