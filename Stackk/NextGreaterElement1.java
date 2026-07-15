package Stackk;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    if (nums2.length == 0 || nums1.length == 0) {
      return new int[0];
    }
    Map<Integer, Integer> numberNGE = new HashMap<>();
    Stack<Integer> numStack = new Stack<>();

    numStack.push(nums2[nums2.length - 1]);
    numberNGE.put(nums2[nums2.length - 1], -1);

    for (int i = nums2.length - 2; i >= 0; i--) {

      if (nums2[i] < numStack.peek()) {
        numberNGE.put(nums2[i], numStack.peek());
        numStack.push(nums2[i]);
        continue;
      }

      while (!numStack.isEmpty() && numStack.peek() < nums2[i]) {
        numStack.pop();
      }
      if (numStack.isEmpty()) {
        numStack.push(nums2[i]);
        numberNGE.put(nums2[i], -1);
      } else {
        numberNGE.put(nums2[i], numStack.peek());
        numStack.push(nums2[i]);
      }
    }

    for (int i = 0; i < nums1.length; i++) {
      nums1[i] = numberNGE.get(nums1[i]);
    }
    return nums1;
  }
}


// Example:

// nums1 = [4, 1, 2]
// nums2 = [1, 3, 4, 2]

// -----------------------------------
// Step 1: Build Next Greater Map
// Traverse nums2 from right to left
// -----------------------------------

// Initial:
// Stack = []
// Map = {}

// i = 3 → nums2[i] = 2
// Stack empty
// NGE(2) = -1
// Stack = [2]
// Map = {2=-1}

// i = 2 → nums2[i] = 4
// Top = 2 < 4 → pop 2
// Stack empty
// NGE(4) = -1
// Stack = [4]
// Map = {2=-1, 4=-1}

// i = 1 → nums2[i] = 3
// Top = 4 > 3
// NGE(3) = 4
// Stack = [4, 3]
// Map = {2=-1, 4=-1, 3=4}

// i = 0 → nums2[i] = 1
// Top = 3 > 1
// NGE(1) = 3
// Stack = [4, 3, 1]
// Map = {2=-1, 4=-1, 3=4, 1=3}

// -----------------------------------
// Step 2: Replace nums1 using Map
// -----------------------------------

// nums1[0] = map[4] → -1
// nums1[1] = map[1] → 3
// nums1[2] = map[2] → -1

// Final Output:
// [-1, 3, -1]