import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Collections;

public class Solution 
{
    public static void  swap(ArrayList<Integer> li, int i, int r){
        int t = li.get(r);
        li.set(r, li.get(i));
        li.set(i, t);
    }
    
	public static ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) 
	{
		// Write your code here.
        int n = permutation.size();
        if(n==1)
            return permutation;
        int i= n-2;
        
        while(i>=0 && permutation.get(i)>=permutation.get(i+1)){
            i--;
        }
        
        if(i<0){
            Collections.sort(permutation);
        }
        else{
            int r = i+1;
            while(r<n && permutation.get(r)>permutation.get(i)){
                r++;
            }
            r--;
            swap(permutation, i, r);
            i++;
            r = n-1;
            while(i<r)
            {
                swap(permutation, i, r);
                i++;
                r--;
            }
        }
        
        return permutation;
	}
}
