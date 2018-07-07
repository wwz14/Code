package binarywatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public List<String> readBinaryWatch(int num) {
        Set<String> result = new HashSet<>();

        for(int i = 0; i <= Math.min(num, 4); i++){
            List<Integer> hours = new ArrayList<>();
            List<Integer> minutes = new ArrayList<>();
            doPermute(i, 4, 0, 0, hours);
            doPermute(num-i, 6, 0, 0, minutes);
            for(Integer hour : hours){
                for(Integer minute : minutes){
                    if(minute <= 59 && hour <= 11) {
                        if (minute >= 10) {
                            result.add(hour + ":" + minute);
                        } else {
                            result.add(hour + ":" + "0" + minute);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }

    private void doPermute(int num, int total, int index, Integer temp, List<Integer> result){
        if(num <= 0){
            result.add(temp);
            return;
        }

        for(int i = index; i < total; i++){
            Integer copy = temp;
            copy = copy + (int)Math.pow(2, i);
            doPermute(num-1, total, i+1, copy, result);
        }
    }

 
}
