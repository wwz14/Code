
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0||matrix[0].length == 0)
        return false;
        
     int height = matrix.length;
     int width = matrix[0].length;
        
        int row = 0;
        int col = width -1;
        
        while(row < height && col>=0) {
            if(matrix[row][col] == target){
                return true;
            }else if (matrix[row][col]<target ) {
                row++;
            }else {
                col--;
            }
        }
        return false;
    }
}