package Stackk;

import java.util.Stack;

public class LargestRecInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea=0;
        int nsr[]=new int[heights.length];
        int nsl[]=new int[heights.length];

        //nsr
        Stack<Integer> s=new Stack<>();

        for(int i=heights.length-1;i>=0;i--) {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }

            if(s.isEmpty()) {
                nsr[i]=heights.length;
            } else {
                nsr[i]=s.peek();
            }
            s.push(i);
        }
        //nsl

        s=new Stack<>();
        for(int i=0;i<heights.length;i++) {
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsl[i]=-1;
            } else {
                nsl[i]=s.peek();
            }
            s.push(i);
        }

        for(int i=0;i<heights.length;i++) {
            int h=heights[i];
            int width=nsr[i]-nsl[i]-1;
            int currArea=h*width;
            maxArea=Math.max(maxArea,currArea);
        }
        return maxArea;
    }
}


// heights = [2,1,5,6,2,3]
// n = 6

// -----------------------------------
// Step 1: Next Smaller Right (NSR)
// -----------------------------------

// Traverse right → left

// i=5 (3) → nsr[5]=6
// i=4 (2) → pop 3 → nsr[4]=6
// i=3 (6) → nsr[3]=4
// i=2 (5) → pop 6 → nsr[2]=4
// i=1 (1) → pop 5,2 → nsr[1]=6
// i=0 (2) → nsr[0]=1

// NSR = [1,6,4,4,6,6]

// -----------------------------------
// Step 2: Next Smaller Left (NSL)
// -----------------------------------

// Traverse left → right

// i=0 (2) → nsl[0]=-1
// i=1 (1) → pop 2 → nsl[1]=-1
// i=2 (5) → nsl[2]=1
// i=3 (6) → nsl[3]=2
// i=4 (2) → pop 6,5 → nsl[4]=1
// i=5 (3) → nsl[5]=4

// NSL = [-1,-1,1,2,1,4]

// -----------------------------------
// Step 3: Area Calculation
// -----------------------------------

// Formula:
// width = nsr[i] - nsl[i] - 1
// area = height * width

// i=0 → 2*(1-(-1)-1)=2
// i=1 → 1*(6-(-1)-1)=6
// i=2 → 5*(4-1-1)=10
// i=3 → 6*(4-2-1)=6
// i=4 → 2*(6-1-1)=8
// i=5 → 3*(6-4-1)=3

// -----------------------------------
// Maximum Area = 10
// -----------------------------------