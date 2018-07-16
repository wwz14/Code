import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length())
            return res;
        
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        
        for(char c:p.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
       int counter = map.size();
       int begin = 0;
       int end = 0;
       while(end < s.length()) {
           if(map.containsKey(s.charAt(end))) {
               map.put(s.charAt(end),map.get(s.charAt(end))-1);
               if(map.get(s.charAt(end)) == 0) 
                   counter--;
           }
           end++;
               
               while(counter == 0) {
                   char beginchar = s.charAt(begin);
                   if(map.containsKey(beginchar)) {
                       map.put(beginchar,map.get(beginchar)+1);
                           if(map.get(beginchar) >0){
                               counter++;
                          if((end-begin) == p.length())
                              res.add(begin);
                           }
                   }
                   
                
                   
                   begin++;
               }
           
           

       } 
                                                           
       return res;
        
    }
}
