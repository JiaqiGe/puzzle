// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// bug at line 29: i++

public class StockTwo {
    public int maxProfit(int[] prices){
      if(prices.length < 2){
        return 0;
      }

      int maxProfit = 0;
      int i = 0;

      while(i < prices.length){
        while(i + 1 < prices.length && prices[i+1] <= prices[i]){
          i++;
        }

        int lo = i;

        while(i + 1 < prices.length && prices[i+1] >= prices[i]){
          i++;
        }

        int hi = i;

        maxProfit += (prices[hi] - prices[lo]);
        i++;
      }

      return maxProfit;
    }
}
