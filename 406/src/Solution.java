
public class Solution {
    
    public int[][] reconstructQueue(int[][] people) {
        int[][] res = new int[people.length][2];
        
        if(people.length <2)
            return people;
       
        for(int i = 1;i<people.length;i++) {
            for(int j = i;j>0;j--){
                if(people[j-1][0] <people[j][0]){
                      int[] temp = people[j-1];
                        people[j-1] = people[j];
                        people[j] = temp;
            
                } else if(people[j-1][0] == people[j][0]) {
                    if(people[j-1][1] > people[j][1]) {
                        int[] temp = people[j-1];
                        people[j-1] = people[j];
                        people[j] = temp;
                    }
                }
            }  
        }
        
        int maxHeight = people[0][0];
        for(int i = 0;i<people.length;i++) {
            if(people[i][0] == maxHeight) {
                res[people[i][1]] = people[i];
            }else {
                for(int j = people.length-1;j>people[i][1];j--) {
                    res[j] = res[j-1];
                }
                
                res[people[i][1]] = people[i];
            }
        }
        return res;
    }
}