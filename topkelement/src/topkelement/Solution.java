package topkelement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //compute frequency;
         Map<Integer,Integer> com = new HashMap<Integer,Integer>();
          for(Integer i : nums) {
              com.put(i,com.getOrDefault(i,0)+1);
          }
          
         List<Integer>[] bucket = new List[nums.length +1];
         for(Integer key:com.keySet()) {
              int frequency = com.get(key);
              if(bucket[frequency] == null) {
                  bucket[frequency] = new ArrayList<Integer>();
              }
              bucket[frequency].add(key);
          }
          
          List<Integer> res = new ArrayList<Integer>();
          for(int i = bucket.length -1;i>=0&&res.size()<k;i--) {
              if(bucket[i] != null) {
                  for(Integer e:bucket[i]) {
                      res.add(e);
                  }
              }
          }
          return res;
      }
  }
