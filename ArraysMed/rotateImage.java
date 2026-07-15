package ArraysMed;

public class rotateImage {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseRows(matrix);
    }
    private void transposeMatrix(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<=i;j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    private void reverseRows(int matrix[][]) {
        for(int i=0;i<matrix.length;i++) {
            int left=0;
            int right=matrix.length-1;
            while(left<right) {
                int temp=matrix[i][left];
                matrix[i][left]=matrix[i][right];
                matrix[i][right]=temp;
                left++;
                right--;
            }
        }
    }
}


// Dry Run Example
// Input
// matrix =
// [
//  [1, 2, 3],
//  [4, 5, 6],
//  [7, 8, 9]
// ]

// Step 1️⃣ Transpose

// Swap across diagonal:

// [
//  [1, 4, 7],
//  [2, 5, 8],
//  [3, 6, 9]
// ]

// Step 2️⃣ Reverse each row

// Row 0 → [1,4,7] → [7,4,1]
// Row 1 → [2,5,8] → [8,5,2]
// Row 2 → [3,6,9] → [9,6,3]

// 🎉 Final Rotated Matrix (90° clockwise)
// [
//  [7, 4, 1],
//  [8, 5, 2],
//  [9, 6, 3]
// ]

// ⏱️ Complexity

// Time: O(n²)

// Space: O(1) (in-place)