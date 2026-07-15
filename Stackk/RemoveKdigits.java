package Stackk;
import java.util.Stack;
public class RemoveKdigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();
        for(char ch:num.toCharArray()) {
            while(!stack.isEmpty() && k>0 && stack.peek()>ch) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k>0) {
            stack.pop();
            k--;
        }

        StringBuilder sb=new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length()>1 && sb.charAt(0)=='0') {
            sb.deleteCharAt(0);
        }
        return (sb.length()>0)?sb.toString():"0";
    }
}


// Example:

// num = "1432219"
// k = 3
// Start
// stack = []
// k = 3
// ch = '1'

// push 1
// stack = [1]

// ch = '4'

// 4 > 1 → ok
// push 4
// stack = [1,4]

// ch = '3'

// 4 > 3 → pop 4
// k=2

// push 3
// stack = [1,3]

// ch = '2'

// 3 > 2 → pop 3
// k=1

// push 2
// stack = [1,2]

// ch = '2'

// 2 > 2 ? no

// push 2
// stack = [1,2,2]

// ch = '1'

// 2 > 1 → pop 2
// k=0

// push 1
// stack = [1,2,1]

// ch = '9'

// k=0 → no removal

// push 9
// stack = [1,2,1,9]

// Build Number

// Pop all:

// 9,1,2,1

// Reverse:

// 1219
// ✅ Final Answer
// 1219
// ⏱ Time Complexity
// O(n)