// There are N children standing in a line. Each child is assigned a rating value.
//
// You are giving candies to these children subjected to the following requirements:
//
// Each child must have at least one candy.
// Children with a higher rating get more candies than their neighbors.
// What is the minimum candies you must give?
public class Candy {
    public int candy(int[] ratings){
      if(rating.length == 0){
        return 0;
      }

      int[] count = new int[ratings.length];
      Arrays.fill(count, 1);

      for(int i = 1; i < count.length; i++){
          if(ratings[i] > ratings[i-1]){
            count[i] = count[i-1] + 1;
          }
      }

      int sum = 0;
      for(int i = count.length; i >= 1; i--){
        sum += count[i];
        if(ratings[i-1] > ratings[i] && count[i-1] <= count[i]){
          count[i-1] = count[i] + 1;
        }
      }

      sum += count[0];
      return sum;
    }
}
