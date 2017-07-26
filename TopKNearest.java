// Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
// Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
//
//
// Example
// Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
// return [[1,1],[2,5],[4,4]]
import java.util.*;

public class TopKNearest {
    List<List<Integer>> findKNearest(List<List<Integer>> points,
                                     List<Integer> point, int k){
        if (points.isEmpty()){
            return new ArrayList<>();
        }

        Queue<List<Integer>> maxHeap = new PriorityQueue(k, new Comparator<List<Integer>>(){
            public int compare(List<Integer> o1, List<Integer> o2){
                int dist1 = distance(o1, point);
                int dist2 = distance(o2, point);

                if (dist1 != dist2){
                    return dist2 - dist1;
                }else{
                    if (o1.get(0) != o2.get(0)){
                        return o2.get(0) - o1.get(0);
                    }else{
                        return o2.get(1) - o1.get(1);
                    }
                }
            }
        });

        for (List<Integer> onePoint : points){
            if (maxHeap.size() < k){
              maxHeap.offer(onePoint);
            }else{
              if(distance(maxHeap.peek(), point) > distance(onePoint, point)){
                maxHeap.poll();
                maxHeap.offer(onePoint);
              }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(!maxHeap.isEmpty()){
          result.add(0, maxHeap.poll());
        }
        // result.addAll(maxHeap);
        return result;
    }

    private int distance(List<Integer> point1, List<Integer> point2){
        int dist = 0;

        for (int i = 0; i < point1.size(); i++){
            int delta = Math.abs(point1.get(i) - point2.get(i));
            dist += (delta * delta);
        }
        return dist;
    }

    public static void main(String[] args){
        List<List<Integer>> points = new ArrayList<>();
        List<Integer>       l1     = new ArrayList<>();
        l1.add(1);
        l1.add(2);

        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(3);
        List<Integer> l3 = new ArrayList<>();
        l3.add(4);
        l3.add(5);

        List<Integer> l4 = new ArrayList<>();
        l4.add(0);
        l4.add(0);

        points.add(l1);
        points.add(l2);
        points.add(l3);

        TopKNearest         t             = new TopKNearest();
        List<List<Integer>> nearestPoints = t.findKNearest(points, l4, 2);
        for (List<Integer> onePoint : nearestPoints){
            System.out.println(onePoint.get(0) + "," + onePoint.get(1));
        }
    }
}
