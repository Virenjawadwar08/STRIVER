package greedyAlgo;

import java.util.Arrays;

public class AssignCookies {
   public int findContentChildren(int[] g, int[] s) 
    {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer

        int count = 0;

        while (i < g.length && j < s.length) 
        {
            if (s[j] >= g[i]) 
            {
                count++;   // child satisfied
                i++;
                j++;
            } 
            else 
            {
                j++; // try bigger cookie
            }
        }

        return count;
    } 
}


// Input:
// g = [1,2,3]
// s = [1,1]

// After Sorting:
// g = [1,2,3]
// s = [1,1]

// i = 0, j = 0, count = 0

// Step 1:
// s[0] >= g[0] → 1 >= 1 ✔
// count = 1
// i = 1, j = 1

// Step 2:
// s[1] >= g[1] → 1 >= 2 ✘
// j = 2

// Loop ends

// Output = 1


// Time:

// Sorting → O(n log n + m log m)
// Traversal → O(n + m)
// 👉 Overall: O(n log n)

// Space:

// No extra space → O(1) (ignoring sorting)