package reversebit;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int twosum = ((n&0x55555555) << 1) |((n&0xAAAAAAAA) >>>1);
        int foursum = ((twosum&0x33333333)<<2) |((twosum&0xCCCCCCCC) >>>2);
        int eightsum = ((foursum&0x0f0f0f0f)<<4)|((foursum&0xf0f0f0f0)>>>4);
        int sixsum = ((eightsum&0x00ff00ff)<<8)|((eightsum&0xff00ff00)>>>8);
        int res = ((sixsum&0x0000ffff)<<16) | ((sixsum&0xffff0000)>>>16);
        return res;        
    }
}