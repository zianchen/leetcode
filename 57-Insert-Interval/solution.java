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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList();
        List<Interval> after = new LinkedList();
        if (intervals == null || intervals.size() == 0) {
            res.add(newInterval);
            return res;
        }
        int newStart = newInterval.start, newEnd = newInterval.end;
        for (Interval itl : intervals) {
            if (itl.end < newInterval.start) {
                res.add(itl);
            } else if (Math.max(itl.start, newStart) <= Math.min(itl.end, newEnd)) {
                newStart = Math.min(newStart, itl.start);
                newEnd = Math.max(newEnd, itl.end);
            } else {
                after.add(itl);
            }
        }
        res.add(new Interval(newStart, newEnd));
        res.addAll(after);
        return res;
    }
}