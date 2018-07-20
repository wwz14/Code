
public class Solution {
    public void gameOfLife(int[][] board) {
        int height = board.length;
        int width = board[0].length;
        
        int[][] res = new int[height][width];
        
        for(int i = 0;i<height;i++) {
            for(int j = 0;j<width;j++){
                int counter = 0;
                if(j+1 < width && board[i][j+1] == 1) {
                    counter++;
                }
                
                if(i+1 < height && board[i+1][j] == 1) {
                    counter++;
                }
                
                if(i+1 < height && j+1 < width &&board[i+1][j+1] == 1) {
                    counter++;
                }
                
                if(i-1>=0 && board[i-1][j] == 1) {
                    counter++;
                }
                if(j-1>=0 && board[i][j-1] == 1) {
                    counter++;
                }
                
                if(i-1>=0&&j-1>=0&&board[i-1][j-1] == 1) {
                    counter++;
                }
                if(i-1>=0&&j+1<width&&board[i-1][j+1]==1){
                    counter++;
                }
                if(i+1<height&&j-1>=0&&board[i+1][j-1]==1) {
                    counter++;
                }        
               
                if(counter < 2 ){
                    res[i][j] = 0;
                }else if(counter>3){
                    res[i][j]=0;
                }else if(counter == 2 ) {
                    if(board[i][j] == 1)
                    res[i][j] = 1;
                    else
                        res[i][j] = 0;
                }else {
                    res[i][j] =1;
                }
            }
        }
        
        for(int i = 0;i<height;i++) {
            for(int j = 0;j<width;j++) {
                board[i][j] = res[i][j];
            }
        }
   
    }
}
