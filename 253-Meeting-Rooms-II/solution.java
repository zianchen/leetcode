/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    //https://discuss.leetcode.com/topic/20958/ac-java-solution-using-min-heap  
    class StartComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    
    class EndComparator implements Comparator<Interval>{
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.end - i2.end;
        }
    }
    
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        StartComparator startComparator = new StartComparator();
        EndComparator endComparator = new EndComparator();
        Arrays.sort(intervals, startComparator);
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(endComparator);
        
        heap.offer(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            
            if (intervals[i].start >= interval.end) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();
    }
}