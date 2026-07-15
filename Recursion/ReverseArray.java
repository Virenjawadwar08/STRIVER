package Recursion;

public class ReverseArray {
    public void reverse(int arr[],int n) {
        reverseHelper(arr,0,n-1);
    }
    private void reverseHelper(int arr[],int left,int right) {

        if(left>=right) {
            return;
        }

        int temp=arr[left];
        arr[left]=arr[right];
        arr[right]=temp;

        reverseHelper(arr, left+1, right-1);
    }
}


/*
========================================
REVERSE ARRAY USING RECURSION
Input: arr = [1,2,3,4,5], n = 5
========================================

Call:
reverse(arr, 5)
→ reverseHelper(arr, 0, 4)

----------------------------------------
CALL STACK (Forward Phase)

reverseHelper(arr, 0, 4)
→ swap arr[0] and arr[4]
   [5,2,3,4,1]
→ call reverseHelper(arr, 1, 3)

reverseHelper(arr, 1, 3)
→ swap arr[1] and arr[3]
   [5,4,3,2,1]
→ call reverseHelper(arr, 2, 2)

reverseHelper(arr, 2, 2)
→ left >= right
→ return

----------------------------------------
CALL STACK (Backtracking Phase)

reverseHelper(arr, 2,2) returns
reverseHelper(arr, 1,3) returns
reverseHelper(arr, 0,4) returns

----------------------------------------
FINAL ARRAY:

[5,4,3,2,1]

========================================
If n = 6 and arr = [1,2,3,4,5,6]

reverseHelper(arr,0,5)
→ swap 1 & 6 → [6,2,3,4,5,1]
→ reverseHelper(1,4)

→ swap 2 & 5 → [6,5,3,4,2,1]
→ reverseHelper(2,3)

→ swap 3 & 4 → [6,5,4,3,2,1]
→ reverseHelper(3,2) stop

========================================
Time Complexity: O(n)
Space Complexity: O(n) (recursion stack)
========================================
*/