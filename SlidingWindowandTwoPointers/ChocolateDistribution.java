package SlidingWindowandTwoPointers;

import java.util.ArrayList;
import java.util.Collections;

// https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1


public class ChocolateDistribution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        int n=arr.size();
        if(arr.size()==0 || m>n) {
            return 0;
        }
        Collections.sort(arr);
        long res=Long.MAX_VALUE;
        for(int i=0;i<n-m+1;i++) {
            int minElement=arr.get(i);
            int maxElement=arr.get(i+m-1);
            res=Math.min(res,maxElement-minElement);
        } 
        return (int) res;
    }
}

//tc-O(nlogn)


// Complete Dry Run

// Input:

// arr = [3, 4, 1, 9, 56, 7, 9, 12]
// m = 5
// 🔹 Step 1: Sort
// [1, 3, 4, 7, 9, 9, 12, 56]

// n = 8

// Windows = 8 - 5 + 1 = 4

// 🔹 i = 0

// Window:

// [1, 3, 4, 7, 9]

// min = 1
// max = 9

// diff = 9 - 1 = 8

// res = 8

// 🔹 i = 1

// Window:

// [3, 4, 7, 9, 9]

// min = 3
// max = 9

// diff = 9 - 3 = 6

// res = min(8,6) = 6

// 🔹 i = 2

// Window:

// [4, 7, 9, 9, 12]

// min = 4
// max = 12

// diff = 12 - 4 = 8

// res = min(6,8) = 6

// 🔹 i = 3

// Window:

// [7, 9, 9, 12, 56]

// min = 7
// max = 56

// diff = 49

// res = min(6,49) = 6

// ✅ Final Answer
// 6