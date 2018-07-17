import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;


public class Solution {
    int n;
    //recode the connected nodes 
    List<Integer>[] e;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        this.n = n;
        e = new List[n];
        
        for(int i = 0;i<n;i++) {
            e[i] = new ArrayList<Integer>();
        }
        //record
        for(int[] edge:edges) {
            int index = edge[0];
            int connected = edge[1];
            e[index].add(connected);
            e[connected].add(index);
        } 
        
        int[] d1 = new int[n];//record the distance from node 0
        int[] d2 = new int[n];//record the distance from the leave found by d1
        int[] pre = new int[n];//record the path;
        
        bfs(0,d1,pre);
        
        int leave = 0;
        //found the leave which has the longest from node 0
        for(int i = 0;i<n;i++) {
            if(d1[i] > d1[leave])
                leave = i;
        }
        
        bfs(leave,d2,pre);
        int endpoint = 0;
        for(int i = 0;i<n;i++) {
            if(d2[i]> d2[endpoint])
                endpoint = i;
        }
        
        List<Integer> res = new ArrayList<>();
        int v = endpoint;
        while(v != -1) {
            res.add(v);
            v= pre[v];
        }
        
        return res.size()%2 ==1?Arrays.asList(res.get(res.size()/2)):Arrays.asList(res.get(res.size()/2-1),res.get(res.size()/2));   
    }
    
    private void bfs(int start,int[] dis,int[] pre) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        dis[start] = 0;
        pre[start] = -1;
        visited[start] = true;
       
        while(!queue.isEmpty()) {
            int v = queue.poll();
            for(int u : e[v]){
                if(!visited[u]) {
                    queue.add(u);
                    pre[u] = v;
                    visited[u] = true;
                    dis[u] = dis[v] +1;
                }
            }
        }
        
    }
}
