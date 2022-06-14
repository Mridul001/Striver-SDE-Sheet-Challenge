/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;

public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        //    Write your code here.
        ArrayList<Integer> res = new ArrayList<>();
        traversal(root, 0, res);
        return res;
    }
    
    public static void traversal(TreeNode<Integer> root, int depth, ArrayList<Integer> res){
        if(root == null) return;
        
        if(res.size()==depth)
            res.add(root.data);
        
        traversal(root.left, depth+1, res);
        traversal(root.right, depth+1, res);
    }
}
