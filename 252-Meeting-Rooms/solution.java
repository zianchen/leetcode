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
    
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            return i1.start - i2.start;
        }
    }
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null || intervals.length < 2) {
            return true;
        }
        IntervalComparator intervalComparator = new IntervalComparator();
        Arrays.sort(intervals, intervalComparator);
        for (int i = 1; i < intervals.length; i++) {
            int mStart = Math.max(intervals[i].start, intervals[i-1].start);
            int mEnd = Math.min(intervals[i].end, intervals[i-1].end);
            if (mStart < mEnd) {
                return false;
            }
        }
        return true;
    }
}