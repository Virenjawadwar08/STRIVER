package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagLevelOrderTrav {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

     List<List<Integer>> zigzag=new ArrayList<>();
     if(root==null) return zigzag;

     Queue<TreeNode> queue=new LinkedList<>();
     queue.add(root);

     boolean flag=false;

     while(!queue.isEmpty()) {
        int size=queue.size();

        List<Integer> level=new ArrayList<>();
        Stack<Integer> reverseStack=new Stack<>();

        for(int i=0;i<size;i++) {
            TreeNode node=queue.poll();

            //check flag
            if(flag) {
                reverseStack.add(node.val);
            } else {
                level.add(node.val);
            }

            if(node.left!=null) queue.add(node.left);

            if(node.right!=null) queue.add(node.right);
        }
        flag=!flag;

        //pop all elements from stack
        while(!reverseStack.isEmpty())
            level.add(reverseStack.pop());

        zigzag.add(level);
     }
     return zigzag;
    }
}


// 🌳 Input Tree
//        3
//      /   \
//     9     20
//          /  \
//         15   7
// 🔁 Initial Setup
// queue = [3]
// flag = false (Left → Right)
// zigzag = []
// ▶️ Iteration 1
// Queue before:
// [3]
// size = 1
// level = []
// reverseStack = []
// Loop:
// Take 3
// flag = false → normal order → level.add(3)
// After loop:
// level = [3]
// reverseStack = []
// Add children:
// queue → [9, 20]
// Add to result:
// zigzag = [[3]]
// Toggle flag:
// flag = true
// ▶️ Iteration 2
// Queue before:
// [9, 20]
// size = 2
// level = []
// reverseStack = []
// Loop:
// i = 0
// Take 9
// flag = true → push to stack → [9]
// i = 1
// Take 20
// flag = true → push → [9, 20]
// Add children:
// 9 → none
// 20 → add 15, 7

// Queue becomes:

// [15, 7]
// Now pop stack:
// pop → 20
// pop → 9

// 👉 level becomes:

// [20, 9]
// Add to result:
// zigzag = [[3], [20, 9]]
// Toggle flag:
// flag = false
// ▶️ Iteration 3
// Queue before:
// [15, 7]
// size = 2
// level = []
// reverseStack = []
// Loop:
// i = 0
// Take 15
// flag = false → level.add(15)
// i = 1
// Take 7
// flag = false → level.add(7)
// Add children:
// none

// Queue becomes:

// []
// Stack empty → nothing to pop
// Add to result:
// zigzag = [[3], [20, 9], [15, 7]]