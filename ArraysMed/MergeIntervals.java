package ArraysMed;
import java.util.*;
public class MergeIntervals {
     public int[][] merge(int[][] intervals) {

        if(intervals.length<=1) return intervals;
       
        Arrays.sort(intervals,Comparator.comparingInt(i->i[0]));

        List<int[]> result=new ArrayList<>();

        int[] newInterval=intervals[0];
        result.add(newInterval);

        for(int[] interval:intervals) {
            if(interval[0]<newInterval[1]) {
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            } else {
                newInterval=interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
     }
}


// 🔷 Method Signature
// int[][] merge(int[][] intervals)

// What does this mean?

// Input: 2D array (list of intervals)

// Output: 2D array (merged intervals)

// Each interval is:

// [start, end]

// 🔷 Step 1: Edge Case
// if (intervals.length <= 1)
//     return intervals;


// If:

// 0 intervals

// 1 interval

// Then nothing to merge → return as it is.

// 🔷 Step 2: Sorting
// Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

// Why sorting?

// To merge intervals easily, we must:

// Arrange intervals by starting time.

// 🔹 What is happening here?
// Arrays.sort(...)

// Sorts the 2D array.

// Comparator.comparingInt(i -> i[0])

// This means:

// Compare intervals based on their first element (start time).

// Example:

// Before sorting:

// [[8,10], [1,3], [2,6]]


// After sorting:

// [[1,3], [2,6], [8,10]]

// What is i -> i[0]?

// This is a lambda expression.

// It means:

// For each interval i, use i[0] (start value) for comparison.

// 🔷 Step 3: Create Result List
// List<int[]> result = new ArrayList<>();


// We cannot know how many merged intervals will exist.

// So we use:

// Dynamic list


// Each element is:

// int[]  (an interval)

// 🔷 Step 4: Initialize First Interval
// int[] newInterval = intervals[0];
// result.add(newInterval);


// Take first interval

// Add it to result

// Use it as base for merging

// 🔷 Step 5: Loop Through Intervals
// for (int[] interval : intervals)


// Enhanced for-loop:

// interval is each [start, end]

// 🔷 Step 6: Check Overlap
// if (interval[0] <= newInterval[1])


// Meaning:

// If current interval start <= previous interval end


// Then they overlap.

// 🔹 Overlap Case
// newInterval[1] = Math.max(newInterval[1], interval[1]);


// We update end to maximum.

// Example:

// [1,3] and [2,6]


// Since:

// 2 <= 3 → overlap


// Update:

// end = max(3,6) = 6


// So becomes:

// [1,6]

// 🔷 Step 7: Non-Overlap Case
// else {
//     newInterval = interval;
//     result.add(newInterval);
// }


// If:

// interval[0] > newInterval[1]


// Then no overlap.

// So:

// Start new interval

// Add to result

// 🔷 Step 8: Convert List to Array
// return result.toArray(new int[result.size()][]);


// Why?

// Because method must return:

// int[][]


// But result is:

// List<int[]>


// So we convert.


// 🔹 Why new int[result.size()][] ?

// Let’s understand this carefully.

// result.size()

// Number of intervals in the list.

// Suppose:

// result.size() = 3


// Then:

// new int[3][]


// This means:

// Create an array of size 3

// Each element is an int[]

// Second dimension size not fixed yet



class Solution {

    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals based on starting time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Initialize start and end with first interval
        int start = intervals[0][0];
        int end = intervals[0][1];

        // Create a list to store merged intervals
        List<int[]> list = new ArrayList<>();

        // Traverse remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // Current interval start and end
            int s = intervals[i][0];
            int e = intervals[i][1];

            // If intervals overlap (current start <= previous end)
            if (s <= end) {

                // Merge by updating end to maximum value
                end = Math.max(end, e);

            } else {

                // If no overlap, add the previous interval to list
                list.add(new int[]{start, end});

                // Update start and end for new interval
                start = s;
                end = e;
            }
        }

        // Add the last interval after loop finishes
        list.add(new int[]{start, end});

        // Convert List<int[]> to int[][] and return
        return list.toArray(new int[list.size()][]);
    }
}
