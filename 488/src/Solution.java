
public class Solution {
    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        //count the number of each kind of balls
        for(int i = 0;i<hand.length();i++) {
            handCount[hand.charAt(i) - 'A']++;
        }
        
        int bound = 6;
       int res =  helper(board+"#",handCount);
        return res==bound?-1:res;     
    }
    
    private int helper(String board,int[] handCount) {
        board = removeConsutive(board);
        if(board.equals("#")) return 0;
        int res = 6;
        int need = 0;
        for(int i = 0,j=0;j<board.length();j++) {
            if(board.charAt(i) == board.charAt(j)) continue;
            need = 3-(j-i);
            if(handCount[board.charAt(i)-'A'] >= need) {
                handCount[board.charAt(i)-'A']-=need;
                res = Math.min(res,need+helper(board.substring(0,i)+board.substring(j,board.length()),handCount));
                handCount[board.charAt(i)-'A']+=need;
            }
            i=j;
        }
        return res;
    }
    
    private String removeConsutive(String board) {
        for(int i=0,j=0;j<board.length();j++) {
            if(board.charAt(i) == board.charAt(j)) continue;
            if(j-i>=3){
                return removeConsutive(board.substring(0,i)+board.substring(j,board.length()));
            }else {
                i=j;
            }
        }
        return board;
    }
}
