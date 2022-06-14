/*********************************************

    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

*********************************************/
import java.util.*;



public class Solution {
    
    public static  class Node{
        BinaryTreeNode node;
        int ind;
        
        public Node(BinaryTreeNode node, int ind){
            this.node = node;
            this.ind = ind;
        }
}
    
    
    
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
         // Write your code here.         
        Queue<Node> q = new  LinkedList<>();
        q.offer(new Node(root, 0));
        HashMap<Integer, BinaryTreeNode> m = new HashMap<Integer, BinaryTreeNode>(); 
        int lastInd = 0;
        while(!q.isEmpty()){
            Node top = q.poll();
            BinaryTreeNode node  = top.node;
            int ind = top.ind;
            lastInd = Math.min(lastInd, ind);
            m.put(ind, node);
            if(node.left!=null)
                q.offer(new Node(node.left, ind-1));
            if(node.right!=null)
                q.offer(new Node(node.right, ind+1));
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(m.containsKey(lastInd)){
            ans.add(m.get(lastInd).val);
            lastInd++;
        }
        
        return ans;
    }
}
