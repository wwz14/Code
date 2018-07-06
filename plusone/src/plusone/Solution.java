package plusone;

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int result = digits[digits.length-1]+1;
        int[] extend = new int[digits.length+1];
        if(result < 10) {
            digits[digits.length-1] = result;
            return digits;
        }else {
            for(int i = digits.length-2;i>=0;i--){
               carry = result/10;
               digits[i+1] = result%10;
               result = carry+digits[i];  
               if(result < 10){
                   digits[i] = result;
                   return digits;
               }
        }
            if(result >= 10) {
                carry = result/10;
                digits[0] = result%10;
                extend[0] = carry;
                for(int i = 1;i<digits.length+1;i++){
                    extend[i] = digits[i-1];
                }
                return extend;
            }
            
        }
       return digits; 
    }
}
