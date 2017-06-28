// Given a collection of intervals, merge all overlapping intervals.
//
// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals){
        if(intervals.size() <= 1){
            return intervals;
        }

        //sort by the start point
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        List<Interval> result = new ArrayList<>();
        Interval interval = new Interval(intervals.get(0).start, intervals.get(0).end);
        int i = 1;
        while(i < intervals.size()){
            Interval candidate = intervals.get(i);
            if(candidate.start <= interval.end){
                //merge
                interval.end = Math.max(candidate.end, interval.end);
            }else{
                result.add(interval);
                interval = new Interval(candidate.start, candidate.end);
            }
            i++;
        }

        result.add(interval);
        return result;
    }

    public static void main(String[] args){
        MergeIntervals m = new MergeIntervals();
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        List<Interval> merged = m.merge(intervals);
        for(Interval i : merged){
            System.out.println("["+i.start+","+i.end+"]");
        }
    }
}


class Interval {
    int start;
    int end;
    Interval(){ start = 0; end = 0; }
    Interval(int s, int e){ start = s; end = e; }
}
