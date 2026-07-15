package SlidingWindowandTwoPointers;

public class MaximumPoints {
   public int maxScore(int[] cardPoints, int k) 
    {
        int n = cardPoints.length;

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int i = 0; i < n; i++) 
        {
            totalSum += cardPoints[i];
        }

        // Step 2: If taking all cards
        if (k == n) 
        {
            return totalSum;
        }

        // Step 3: Sliding window of size (n - k)
        int windowSize = n - k;

        int windowSum = 0;

        // First window
        for (int i = 0; i < windowSize; i++) 
        {
            windowSum += cardPoints[i];
        }

        int minSum = windowSum;

        // Slide the window
        for (int i = windowSize; i < n; i++) 
        {
            windowSum = windowSum + cardPoints[i] - cardPoints[i - windowSize];

            if (windowSum < minSum) 
            {
                minSum = windowSum;
            }
        }

        // Step 4: Result
        return totalSum - minSum;
    }
}

// Input:
// cardPoints = [1,2,3,4,5,6,1]
// k = 3

// Step 1:
// n = 7
// windowSize = n - k = 7 - 3 = 4

// Step 2:
// totalSum = 1 + 2 + 3 + 4 + 5 + 6 + 1 = 22

// Step 3: First Window (size = 4)
// window = [1,2,3,4]
// windowSum = 10
// minSum = 10

// Step 4: Sliding Window

// Iteration 1:
// Remove cardPoints[0] = 1
// Add cardPoints[4] = 5
// windowSum = 10 - 1 + 5 = 14
// minSum = min(10, 14) = 10

// Iteration 2:
// Remove cardPoints[1] = 2
// Add cardPoints[5] = 6
// windowSum = 14 - 2 + 6 = 18
// minSum = min(10, 18) = 10

// Iteration 3:
// Remove cardPoints[2] = 3
// Add cardPoints[6] = 1
// windowSum = 18 - 3 + 1 = 16
// minSum = min(10, 16) = 10

// Step 5:
// maxScore = totalSum - minSum
//           = 22 - 10
//           = 12

// Output:
// 12

//tc-O(n) , sc-O(n)