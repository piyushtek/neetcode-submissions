/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
        public int minMeetingRooms(List<Interval> intervals) {
            intervals.sort((o1, o2) -> o1.start - o2.start);
            PriorityQueue<Interval> minHeap = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);
            if(intervals.size()==0)
                return 0;
            minHeap.offer(intervals.get(0));
            int max=1;
            for(int i=1;i<intervals.size();i++){
                if(minHeap.size()>max)
                    max=minHeap.size();
                while(!minHeap.isEmpty() && minHeap.peek().end<=intervals.get(i).start){
                    minHeap.poll();
                }
                minHeap.offer(intervals.get(i));
            }
            return Math.max(max,minHeap.size());
        }

        // (1,10),(2,9),(3,8),(5,7)
}
