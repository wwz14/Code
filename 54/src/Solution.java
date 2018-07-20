import java.util.*;
public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length==0)
            return res;
        helper(matrix,matrix[0].length,matrix.length,0,0);
        return res;
    }
    
    private void helper(int[][] matrix,int width,int height,int startm, int startn) {
        if(height == 1 && width == 1) {
            System.out.println(startn);
            System.out.println(startm);
            res.add(matrix[startn][startm]);
          
        }else if(height == 1 && width ==2) {
             res.add(matrix[startn][startm]);
             res.add(matrix[startn][startm]+1);
              
        }else if(height == 2 && width ==1) {
            res.add(matrix[startn][startm]);
            res.add(matrix[startn+1][startm]);
            
        }else {
             
        for(int i = startm;i<width+startm;i++) {           
            res.add(matrix[startn][i]);
        }
        
        for(int j = startn+1;j<height+startn;j++) {
          
            res.add(matrix[j][startm+width-1]);
        }
        
       if(startn+height-1 != startn)
        for(int i = width+startm-2;i>=startm;i--) {
            res.add(matrix[startn+height-1][i]);

        }
        
      if(startm+width-1 != startm)
        for(int j=startn+height-2;j>startn;j--) {
            res.add(matrix[j][startm]);
        
        }
        
 
        width = width -2;
        height = height -2;
        if(width >0 && height >0) {
            System.out.println("g");
            startm = startm+1;
            startn = startn+1;
            helper(matrix,width,height,startm,startn);
        }
        }
    }
}