class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        
        for(char c:moves.toCharArray()) {
            if(c == 'U') col++;
            else if(c == 'D') col--;
            else if(c=='L') row++;
            else row--;
        }
        return row == 0 && col == 0;
    }
}
