package SlidingWindowandTwoPointers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegative {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            // Add negative element index
            if (arr[i] < 0) {
                queue.offer(i);
            }

            // Window size reached
            if (i >= k - 1) {

                // Remove elements out of window
                while (!queue.isEmpty() && queue.peek() <= i - k) {
                    queue.poll();
                }

                // First negative
                if (queue.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(arr[queue.peek()]);
                }
            }
        }

        return result;
    
    }
}


// ✅ Input
// arr = [-8, 2, 3, -6, 10]
// k = 2
// 🔹 Initial State
// queue = []
// result = []
// n = 5

// We iterate i = 0 → 4

// 🔁 Iteration by Iteration
// 🔹 i = 0

// arr[0] = -8

// Negative → add index

// queue = [0]

// Window not formed yet (i < k-1 = 1)
// So nothing added to result.

// 🔹 i = 1

// arr[1] = 2

// Not negative → do nothing

// Now window formed (i >= 1)

// Remove out-of-window elements
// i - k = 1 - 2 = -1
// queue.peek() = 0
// 0 <= -1 ? NO

// Nothing removed.

// Queue not empty → first negative = arr[0] = -8

// result = [-8]
// queue = [0]
// 🔹 i = 2

// arr[2] = 3

// Not negative.

// Window formed.

// Remove out-of-window
// i - k = 2 - 2 = 0
// queue.peek() = 0
// 0 <= 0 ? YES → remove
// queue = []

// Queue empty → no negative

// result = [-8, 0]
// 🔹 i = 3

// arr[3] = -6

// Negative → add index

// queue = [3]

// Window formed.

// Remove out-of-window
// i - k = 3 - 2 = 1
// queue.peek() = 3
// 3 <= 1 ? NO

// Queue not empty → first negative = arr[3] = -6

// result = [-8, 0, -6]
// 🔹 i = 4

// arr[4] = 10

// Not negative.

// Window formed.

// Remove out-of-window
// i - k = 4 - 2 = 2
// queue.peek() = 3
// 3 <= 2 ? NO

// Queue not empty → first negative = arr[3] = -6

// result = [-8, 0, -6, -6]
// ✅ Final Output
// [-8, 0, -6, -6]