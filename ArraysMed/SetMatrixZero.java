package ArraysMed;
import java.util.*;
public class SetMatrixZero {
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;

        Set<Integer> rowset=new HashSet<>();
        Set<Integer> colset=new HashSet<>();

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(matrix[i][j]==0) {
                    rowset.add(i);
                    colset.add(j);
                }
            }
        }
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(rowset.contains(i) || colset.contains(j)) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}

// Input matrix

// [
//  [1, 1, 1],
//  [1, 0, 1],
//  [1, 1, 1]
// ]

// First pass (find zeros)

// Zero found at (1,1)

// rowset = {1}
// colset = {1}

// Second pass (set zeros)

// Any cell where row ∈ rowset OR column ∈ colset → set to 0

// Result:

// [
//  [1, 0, 1],
//  [0, 0, 0],
//  [1, 0, 1]
// ]

// ✅ Final Matrix
// [
//  [1, 0, 1],
//  [0, 0, 0],
//  [1, 0, 1]
// ]