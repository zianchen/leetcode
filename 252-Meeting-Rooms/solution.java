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
            // int mStart = Math.max(intervals[i].start, intervals[i-1].start);
            // int mEnd = Math.min(intervals[i].end, intervals[i-1].end);
            // if (mStart < mEnd) {
            //     return false;
            // }
            // 因为这里是前后相邻的interval算overlapping，又加上已经按照start sort过了。所以前面的interval的start一定小于后面的interval的start。只有yihua哥考我的那个两个intervals list算交集的题目才需要这样去算overlapping
            if (intervals[i].start < intervals[i-1].end) {
                return false;
            }
        }
        return true;
    }
}