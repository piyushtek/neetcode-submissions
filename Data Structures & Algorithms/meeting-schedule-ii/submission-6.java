class Solution {
    public int minMeetingRooms(List<Interval> intervals) {

        List<int[]> events = new ArrayList<>();

        for (Interval interval : intervals) {
            events.add(new int[]{interval.start, 1});   // start
            events.add(new int[]{interval.end, -1});    // end
        }

        events.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1]; // end before start
            }
            return a[0] - b[0];
        });

        int count = 0;
        int ans = 0;

        for (int[] event : events) {
            if (event[1] == 1)
                count++;
            else
                count--;

            ans = Math.max(ans, count);
        }

        return ans;
    }
}