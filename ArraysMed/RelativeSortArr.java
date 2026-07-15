package ArraysMed;

public class RelativeSortArr {
     public int[] relativeSortArray(int[] arr1, int[] arr2) 
    {
       int max=0;
       for(int num:arr1) if(num>max) max=num;
       int[] map=new int[max+1];
       for(int num:arr1) map[num]++;
       int i=0;
       int j=0;
       int m=arr2.length;
       while(j<m) {
        int temp=arr2[j];
        int val=map[temp];

        while(val-->0) {
            arr1[i]=temp;
            i++;
        }
        j++;
        map[temp]=0;
       }
       for(int k=0;k<=max;k++) {
        if(map[k]>0) {
        int temp=k;
        int val=map[k];

        while(val-->0) {
            arr1[i]=temp;
            i++;
        }
        map[k]=0;
        }

       }
       return arr1;
    }
}

// ✅ Test Case
// arr1 = [2,3,1,3,2,4,6,7,9,2,19]
// arr2 = [2,1,4,3,9,6]
// 🔍 Step 1: Find max
// max = 19
// 🔍 Step 2: Build Frequency Map
// map[x] = frequency in arr1

// Index:  1 2 3 4 6 7 9 19
// Value:  1 3 2 1 1 1 1 1
// 🔍 Step 3: Process arr2
// Initial:
// i = 0 (position in arr1)
// 👉 j = 0 → arr2[0] = 2
// map[2] = 3

// Fill:

// arr1 → [2,2,2,_,_,_,_,_,_,_,_]
// i = 3
// map[2] = 0
// 👉 j = 1 → arr2[1] = 1
// map[1] = 1

// Fill:

// arr1 → [2,2,2,1,_,_,_,_,_,_,_]
// i = 4
// map[1] = 0
// 👉 j = 2 → arr2[2] = 4
// map[4] = 1

// Fill:

// arr1 → [2,2,2,1,4,_,_,_,_,_,_]
// i = 5
// map[4] = 0
// 👉 j = 3 → arr2[3] = 3
// map[3] = 2

// Fill:

// arr1 → [2,2,2,1,4,3,3,_,_,_,_]
// i = 7
// map[3] = 0
// 👉 j = 4 → arr2[4] = 9
// map[9] = 1

// Fill:

// arr1 → [2,2,2,1,4,3,3,9,_,_,_]
// i = 8
// map[9] = 0
// 👉 j = 5 → arr2[5] = 6
// map[6] = 1

// Fill:

// arr1 → [2,2,2,1,4,3,3,9,6,_,_]
// i = 9
// map[6] = 0
// 🔍 Step 4: Add Remaining Elements (Sorted)

// Now check all k = 0 → 19

// Remaining non-zero:

// map[7] = 1
// map[19] = 1
// 👉 k = 7
// arr1 → [2,2,2,1,4,3,3,9,6,7,_]
// i = 10
// 👉 k = 19
// arr1 → [2,2,2,1,4,3,3,9,6,7,19]
// i = 11
// ✅ Final Output
// [2,2,2,1,4,3,3,9,6,7,19]

// Time: O(n + max)
// Space: O(max)

// After placing elements according to arr2, I reset their frequency to zero to avoid reprocessing them in the final sorted pass.