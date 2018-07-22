
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int[] degree = new int[numCourses];
        int[] order = new int[numCourses];
        
        for(int[] pre:prerequisites) {
            degree[pre[0]]++;
        }
        
        Queue<Integer> queue = new  ArrayDeque<Integer>();
        int index = 0;     
        for(int i = 0;i<degree.length;i++) {
            if(degree[i] == 0) {
                queue.add(i);
                order[index++] = i;
            }
        }
        
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            for(int i = 0;i<prerequisites.length;i++) {
                if(prerequisites[i][1] == pre) {
                    degree[prerequisites[i][0]]--;
                    if(degree[prerequisites[i][0]] == 0) {
                        order[index++] = prerequisites[i][0];
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
            
        }
      return (index == numCourses) ? order : new int[0];
    }
}
