package greedyAlgo;

import java.util.Arrays;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; // number of intervals to remove
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prevEnd) {
                // overlap → remove this interval
                count++;
            } else {
                // no overlap → update end
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}

// intervals = [[1,2],[2,3],[3,4],[1,3]]

// Step 1: Sort by end
// [1,2], [2,3], [1,3], [3,4]

// prevEnd = 2

// Check [2,3]:
// 2 >= 2 ✔ → no overlap
// prevEnd = 3

// Check [1,3]:
// 1 < 3 ❌ → overlap → remove
// count = 1

// Check [3,4]:
// 3 >= 3 ✔ → no overlap
// prevEnd = 4

// Output = 1