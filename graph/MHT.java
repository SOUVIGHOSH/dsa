class MHT {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // edge case when there is no edge a single node present
        if(n==1){
            List<Integer> list=List.of(0);
            return list; 
        }
        // to track inorder
        int[] inorder = new int[n];
        // create adjacency list
        Map<Integer,List<Integer>> map=new HashMap<>();
        // build graph
        for(int[] edge:edges){
            map.computeIfAbsent(edge[0],val->new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1],val->new ArrayList<Integer>()).add(edge[0]);
            inorder[edge[1]]++;
            inorder[edge[0]]++;
        }
        // queue for bfs iteration
        Queue<Integer> q=new LinkedList<>();
        //push the leaf nodes to q
        for(int i=0;i<n;i++){
            if(inorder[i]==1) q.offer(i);
        }
        int count=n;
        // bfs traversal till we are left with 1 or 2 centroid nodes        
        while(!q.isEmpty()){
            // a tree can have max 2 centroid
            if(count <=2) break;
            int size=q.size();
            // for all leaves reduce the adjacent nodes inorder degree
            for(int i=0;i<size;i++){
                int cur=q.poll();
                count--;
                for(int next:map.get(cur)){
                    inorder[next]--;
                    //if inorder degree is 1 then it is next leaf so push in queue
                    if(inorder[next]==1) q.offer(next);
                }
            }
            
        }
        
        List<Integer> list= new ArrayList<>(q);
        return list;
        
        
    }
}
