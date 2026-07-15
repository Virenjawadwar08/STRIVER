package Stackk;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int n=nums.length;
        int res[]=new int[n];

        for(int i=2*n-1;i>=0;i--) {
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]) {
                stack.pop();
            }

            if(i<n) {
                if(stack.isEmpty()) {
                    res[i]=-1;
                } else {
                    res[i]=stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        return res;
    }
}



// i = 5

// i % n = 2 → value = 1

// Stack empty → nothing to pop

// Push 1

// stack = [1]
// i = 4

// i % n = 1 → value = 2

// Top = 1 ≤ 2 → pop 1

// Stack empty

// Push 2

// stack = [2]
// i = 3

// i % n = 0 → value = 1

// Top = 2 ≤ 1 ? No

// Push 1

// stack = [2,1]
// ⚠ Now i < n → start filling result
// i = 2

// i % n = 2 → value = 1

// Top = 1 ≤ 1 → pop 1

// Top = 2 ≤ 1 ? No

// Since i < n:

// res[2] = 2

// Push 1

// stack = [2,1]
// res = [0,0,2]
// i = 1

// i % n = 1 → value = 2

// Top = 1 ≤ 2 → pop
// Top = 2 ≤ 2 → pop

// Stack empty

// Since i < n:

// res[1] = -1

// Push 2

// stack = [2]
// res = [0,-1,2]
// i = 0

// i % n = 0 → value = 1

// Top = 2 ≤ 1 ? No

// Since i < n:

// res[0] = 2

// Push 1

// stack = [2,1]
// res = [2,-1,2]
// ✅ Final Output
// [2, -1, 2]