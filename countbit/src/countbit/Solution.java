package countbit;

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i = 1;i<num+1;i++) {
            res[i] = count(i);
        }
        return res;
    }
    
    public int count(int num){
        int twoBit = (num&0x55555555) + ((num&0xAAAAAAAA)>>>1);
        int fourBit = (twoBit&0x33333333) + ((twoBit&0xCCCCCCCC)>>>2);
        int eightBit = (fourBit&0x0f0f0f0f)+((fourBit&0xf0f0f0f0) >>>4);
        int sixBit = (eightBit&0x00ff00ff)+((eightBit&0xff00ff00) >>>8);
        int res = (sixBit&0x0000ffff)+((sixBit&0xffff0000)>>>16);
        return res;
    }
}
