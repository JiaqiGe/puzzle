// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
//
// You may assume that the intervals were initially sorted according to their start times.
//
// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
//
// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
//
// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

import java.util.*;

public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        List<Interval> result = new ArrayList<>();

        if(intervals.isEmpty()){
            result.add(newInterval);
            return result;
        }

        int i = 0;

        while(i < intervals.size()){
            Interval interval = intervals.get(i);

            if(interval.end < newInterval.start){
                //no overlap, continue searching
                result.add(interval);
            }else if(interval.start > newInterval.end){
                // no overlap, stop searching
                result.add(newInterval);
                break;
            }else{
                //merge
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
            }
            i++;
        }

        if(i == intervals.size()){
            result.add(newInterval);
        }

        while(i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }

        return result;
    }

    public static void main(String[] args){
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(6,9);
        Interval i3 = new Interval(2,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);

        InsertInterval i = new InsertInterval();
        List<Interval> list = i.insert(intervals, i3);

        for(Interval interval : list){
            System.out.println("["+interval.start+","+interval.end+"]");
        }
    }
}


class Interval {
    int start;
    int end;
    Interval(){ start = 0; end = 0; }
    Interval(int s, int e){ start = s; end = e; }
}
