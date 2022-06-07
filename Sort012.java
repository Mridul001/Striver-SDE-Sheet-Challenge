import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void swap (int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    } 
    public static void sort012(int[] nums)
    {
        //Write your code here
         int n = nums.length;
        int l = 0, r = n-1;
        
        int i = 0;
        while(i<=r){
            if(nums[i]==0){
                swap(nums, i, l);
                l++;
                i++;
            }
            else if(nums[i]==1)
                i++;
            else{
                swap(nums, i, r);
                r--;
            }   
        }
    }
}
