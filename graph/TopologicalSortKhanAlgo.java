class Solution {
    /*
        Implementation of Kahn's Algorithm
        Time Complexitiy O(V+E) Space Complexitiy O(V+E)
        Complexity Analysis

        Time Complexity: O(V + E)O(V+E) where VV represents the number of vertices and EE represents the number of edges.
        We pop each node exactly once from the zero in-degree queue and that gives us VV. Also, for each vertex, we iterate over its adjacency list
        and in totality, we iterate over all the edges in the graph which gives us EE. Hence, O(V + E)O(V+E)

        Space Complexity: O(V + E)O(V+E). We use an intermediate queue data structure to keep all the nodes with 0 in-degree.
        In the worst case, there won't be any prerequisite relationship and the queue will contain all the vertices initially
        since all of them will have 0 in-degree. That gives us O(V)O(V).
        Additionally, we also use the adjacency list to represent our graph initially.
        The space occupied is defined by the number of edges because for each node as the key,
        we have all its adjacent nodes in the form of a list as the value. Hence, O(E)O(E). So, the overall space complexity is O(V + E)O(V+E).
    
    */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // array to manage inorder degree of vertex
        // Space complexitiy raise to O(n)
        int[] inorder=new int[numCourses];
        int[] result= new int[numCourses];
        // build adjacency list
        // // Space complexitiy remains O(n)
        Map<Integer,List<Integer>> map=new HashMap<>();
        // Time complexity raise to O(E)
        for(int[] edge : prerequisites){
            map.computeIfAbsent(edge[1],val->new ArrayList<Integer>()).add(edge[0]);
            inorder[edge[0]]++;
        }
        // queue for bfs iteration
        Queue<Integer> queue = new LinkedList<>();
        // insert the node which has inorder 0
        // Time complexitiy O(V)
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==0) queue.offer(i);
        }
        int index=0;
        //set to track visited node, if any nodes repeats that means cycle so topological not possible
        Set<Integer> set=new HashSet<>();
        //bfs iteration
        // Time complexisity O(V+E)
        while(!queue.isEmpty()){
            int cur = queue.poll();
            // cycle found
            if(set.contains(cur)) return new int[0];
            set.add(cur);
            result[index++]=cur;
            // reduce inorder degree of adjacent and push in queue if inorder gets 0
            for(int vertices : map.getOrDefault(cur,new ArrayList<Integer>())){
                inorder[vertices]--;
                if(inorder[vertices]==0) queue.offer(vertices);
            }
        }
        //checks if topological sort is possible
        if(index==numCourses) return result;
        return new int[0];
        
    }
}
