package pow;

public class Solution {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        if(n == 0)
            return 1;
        // n为负值时，变为正值－n，有可能益处
        if(n < 0){
            return myPow(1/x,-(n+1))*(1/x);
        }else {
            if(n%2 == 0)
                return myPow(x*x,n/2);
            else 
                return x*myPow(x*x,n/2);
        }
    }
}
