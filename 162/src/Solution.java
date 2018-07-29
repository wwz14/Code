
public class Solution {
    public int findPeakElement(int[] nums) {
        return help(nums,0,nums.length-1);
        
    }
    
    public int help(int [] nums,int start,int end) {
        if(start == end )
            return start;
        if(start+1 == end) {
            return nums[start]>nums[end]?start:end;
        } 
        
        int mid = (start+end)/2;
        
       if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
           return mid;
       }else if(nums[mid-1]>nums[mid]&&nums[mid]>nums[mid+1]) {
           return help(nums,start,mid-1);          
       }else {
           return help(nums,mid+1,end);
       }
        
        
    }
}