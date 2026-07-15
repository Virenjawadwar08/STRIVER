package Recursion;
import java.util.Stack;
public class SortaStack {
    private void insert(Stack<Integer> st,int temp) {
        if(st.isEmpty() || st.peek()<=temp) {
            st.push(temp);
            return;
        }

        int val=st.pop();
        insert(st,temp);
        st.push(val);
    }

    public void sortStack(Stack<Integer> st) {
        if(!st.isEmpty()) {
            int temp=st.pop();
            sortStack(st);
            insert(st,temp);
        }
    }
}


/*
========================================
DRY RUN : Sort Stack (Descending Order)
Input Stack (Top → Bottom):

2
3
1
4
========================================

STEP 1: sortStack(st)

Call Stack Flow (Removing Elements):

sortStack([4,1,3,2])
→ pop 2
→ sortStack([4,1,3])

→ pop 3
→ sortStack([4,1])

→ pop 1
→ sortStack([4])

→ pop 4
→ sortStack([])

→ stack empty → return


========================================
Now inserting back in sorted order
========================================

Insert 4:
insert([], 4)
→ stack empty → push 4
Stack: [4]

----------------------------------------

Insert 1:
insert([4], 1)

4 > 1 → pop 4
insert([], 1)
→ push 1
push back 4

Stack becomes:
1
4

----------------------------------------

Insert 3:
insert([1,4], 3)

Top = 4 > 3 → pop 4
insert([1], 3)

Top = 1 <= 3 → push 3
push back 4

Stack becomes:
1
3
4

----------------------------------------

Insert 2:
insert([1,3,4], 2)

Top = 4 > 2 → pop 4
Top = 3 > 2 → pop 3
Top = 1 <= 2 → push 2
push back 3
push back 4

Stack becomes:
1
2
3
4


========================================
FINAL STACK (Top → Bottom):

4
3
2
1
========================================
Printed while popping:
4 3 2 1
========================================

Time Complexity: O(n^2)
Space Complexity: O(n) (recursion stack)
*/