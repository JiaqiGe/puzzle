// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
//
// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
// Note:
// The solution is guaranteed to be unique.


/** solution:
  two steps:
  (1) if exits a solution or not:
        if the total gas is larger than or euqal to the total cost => yes!
  (2) Greedy algorithm
      Given an empty tank at i. Suppose i can connect to j,
      but j cannot connect to j+1, then any node in [i, j] cannot connect to j+1

      Proof:
      initial tank T[i] = 0
      k \in (i,j]
      the remaining gas at k is larger than or equal to 0 (R[k] >= 0), because
        i can connec to j;

      if k is the initial starting point, then T[k] = 0 <= R[k] => k cannot connect to j+1
      because:
        when there are additional T[k] gas, k cannot connect to j+1;
        now if there are 0 additional gas at k, k cannot connect to j+1, too.

        Therefore, we can prune all nodes from i to j, because there are not solutions.

(3) if i is the most left gas station that can connect to n, i is the solution.

proof:
  Certainty i+1 also can connect to n. Suppose the remaining gas for starting at i+1 is R[i+1],
  and the remaining gas for starting at i is R[i], we have
  R[i] >= R[i+1]

  let the cost of connecting n to i+1 be C[i+1], the cost of connecting n to i be C[i], then
  C[i] <= C[i+1]

  if with R[i+1], n can connect to i,
  then with more remaining gas (R[i] > R[i+1]) and less cost (C[i] < C[i+1]), n can connect to i.

  Therefore, i+1 is also a solution which conficts with the statement "unique solution".


  In sum, the solution is the longest subsequence that ending at n whose sum of gas is larger than or
  equal to the cost.
**/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost){
      if(gas.length == 0){
        return -1;
      }

      int sum = 0;
      int total = 0;
      int index = 0;

      for(int i = 0; i < gas.length; i++){
          sum += (gas[i] - cost[i]);
          total += (gas[i] - cost[i]);

          if(sum < 0){
            // cannot connect to next gas station
            index = i+1;
            sum = 0;
          }
      }

      return total >= 0 ? index : -1;
    }
}
