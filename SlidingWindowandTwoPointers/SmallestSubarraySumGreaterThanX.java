package SlidingWindowandTwoPointers;

public class SmallestSubarraySumGreaterThanX {
    public static int smallestSubWithSum(int x, int[] arr) {
        int n=arr.length;
        int windowStart=0;
        int sum=0;
        int minLen=Integer.MAX_VALUE;
        
        for(int windowEnd=0;windowEnd<n;windowEnd++) {
            sum+=arr[windowEnd];
            
            while(sum>x) {
                minLen=Math.min(minLen,windowEnd-windowStart+1);
                sum-=arr[windowStart];
                windowStart++;
            }
        }
        return (minLen==Integer.MAX_VALUE)?0:minLen;
    }
}


// Input
// arr = [1,4,45,6,0,19]
// x = 51
// 🔁 Iteration Step-by-Step
// windowEnd = 0

// sum = 1
// 1 > 51 ❌

// windowEnd = 1

// sum = 1 + 4 = 5
// 5 > 51 ❌

// windowEnd = 2

// sum = 5 + 45 = 50
// 50 > 51 ❌

// windowEnd = 3

// sum = 50 + 6 = 56
// 56 > 51 ✅

// Now shrink:

// Length = 3 - 0 + 1 = 4
// minLen = 4

// Remove arr[0]=1
// sum = 55

// 55 > 51 ✅

// Length = 3 - 1 + 1 = 3
// minLen = 3

// Remove arr[1]=4
// sum = 51

// 51 > 51 ❌ stop shrinking

// windowEnd = 4

// sum = 51 + 0 = 51
// 51 > 51 ❌

// windowEnd = 5

// sum = 51 + 19 = 70
// 70 > 51 ✅

// Shrink:

// Length = 5 - 2 + 1 = 4
// minLen = 3

// Remove arr[2]=45
// sum = 25

// 25 > 51 ❌

// ✅ Final Answer
// 3