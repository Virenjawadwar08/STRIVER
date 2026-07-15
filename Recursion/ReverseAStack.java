package Recursion;

import java.util.Stack;

public class ReverseAStack {

    private void insertAtBottom(Stack<Integer> st,int value) {
        if(st.isEmpty()) {
            st.push(value);
            return;
        }

        int temp=st.pop();
        insertAtBottom(st, value);
        st.push(temp);
    }

    public void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) {
            return;
        }

        int temp=st.pop();
        reverseStack(st);
        insertAtBottom(st,temp);
    }
}


/*
========================================
REVERSE STACK USING RECURSION
Input Stack (Top → Bottom):

2
3
1
4
========================================

--------------- PHASE 1 ----------------
Remove all elements using reverseStack()

Call Stack (Removing Phase):

reverseStack([4,1,3,2])
→ pop 2
→ reverseStack([4,1,3])

→ pop 3
→ reverseStack([4,1])

→ pop 1
→ reverseStack([4])

→ pop 4
→ reverseStack([])

→ stack empty → return

----------------------------------------
At this point stack = empty
Call stack starts resolving
----------------------------------------

--------------- PHASE 2 ----------------
Insert elements at bottom

Insert 4:
insertAtBottom([], 4)
→ push 4
Stack: [4]

----------------------------------------

Insert 1:
insertAtBottom([4], 1)

pop 4
insertAtBottom([], 1)
→ push 1
push back 4

Stack becomes:
1
4

----------------------------------------

Insert 3:
insertAtBottom([1,4], 3)

pop 4
pop 1
insertAtBottom([], 3)
→ push 3
push back 1
push back 4

Stack becomes:
3
1
4

----------------------------------------

Insert 2:
insertAtBottom([3,1,4], 2)

pop 4
pop 1
pop 3
insertAtBottom([], 2)
→ push 2
push back 3
push back 1
push back 4

Stack becomes:
2
3
1
4

========================================
FINAL STACK (Top → Bottom):

4
1
3
2

If printed while popping:
2 3 1 4
========================================

Time Complexity: O(n^2)
Space Complexity: O(n) (recursion stack)
========================================
*/