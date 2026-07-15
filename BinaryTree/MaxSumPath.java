package BinaryTree;

public class MaxSumPath {
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

  int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root) {
        if(root==null) return 0;

        int left=Math.max(0,maxGain(root.left));
        int right=Math.max(0,maxGain(root.right));

        // path THROUGH current node
        int currentPath=left+right+root.val;
         // update global max
         maxSum=Math.max(maxSum,currentPath);
          // return path going UP
          return root.val+Math.max(left,right);
    }
}


// 🌳 Tree
//        -10
//        /  \
//       9   20
//           / \
//          15  7
// 💡 What we track at EACH node
// Thing	Meaning
// left, right	values returned from children
// currentPath	left + root + right (for answer)
// return value	root + max(left, right) (for parent)
// maxSum	global answer
// 🔁 Step-by-Step Execution (Postorder)
// 🟢 Node 9
// left = 0, right = 0

// 👉 currentPath:

// 9

// 👉 update maxSum:

// maxSum = 9

// 👉 return:

// 9
// 🟢 Node 15
// left = 0, right = 0
// currentPath = 15
// maxSum = 15
// return = 15
// 🟢 Node 7
// left = 0, right = 0
// currentPath = 7
// maxSum = 15
// return = 7
// 🟢 Node 20

// Now children returned:

// left = 15, right = 7

// 👉 currentPath (USE BOTH SIDES):

// 15 + 20 + 7 = 42 ✅

// 👉 update maxSum:

// maxSum = 42

// 👉 return (ONLY ONE SIDE):

// 20 + max(15,7) = 35
// 🟢 Node -10 (ROOT)

// Now:

// left = 9, right = 35

// 👉 currentPath:

// 9 + (-10) + 35 = 34

// 👉 maxSum stays:

// 42 (because 42 > 34)

// 👉 return:

// -10 + max(9,35) = 25
// ✅ Final Answer
// maxSum = 42