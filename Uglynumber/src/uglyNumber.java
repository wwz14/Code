
public class uglyNumber {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int t2 = 0;
        int t3 = 0;
        int t5 = 0;
        
        for(int i = 1; i< n;i++) {
            res[i] = Math.min(Math.min(2*res[t2],3*res[t3]),5*res[t5]);
            if(res[i] == 2*res[t2])
                t2++;
            if(res[i] == 3*res[t3])
                t3++;
            if(res[i] == 5*res[t5])
                t5++;
        }
        return res[n-1];
    }
}
