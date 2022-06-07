import java.util.*;
import java.io.*;

public class Solution {

    public static boolean isGraphBirpatite(ArrayList<ArrayList<Integer>> edges) {
        int n = edges.size();
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        
        for(int i=0; i<n; i++){
            for(int j=0; j<edges.get(i).size(); j++)
                if(edges.get(i).get(j)==1){
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
        }
        
        boolean[] vis = new boolean[n];
        int[] col = new int[n];
        Arrays.fill(col, -1);
        Queue<int[]> q = new LinkedList<int[]>();
        
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() != 0 && vis[i] == false) {
                col[i] = 0;
                q.offer(new int[]{i, 0});
                while(!q.isEmpty()){
                    int[] node = q.poll();
                    int prevCol = node[1];
                    int par = node[0];
                    vis[par] = true;
                    for(int child : graph.get(par)){
                        if(!vis[child]){
                            q.offer(new int[]{child, prevCol^1});
                            col[child] = prevCol^1;
                        }
                        else{
                            if(col[child]==prevCol)
                                return false;
                        }
                    }
                }
            }
         }
        
        return true;
    }
}
