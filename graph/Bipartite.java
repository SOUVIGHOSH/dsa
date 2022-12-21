class Bipartite {
    // checks if a graph is bipartite
    public boolean possibleBipartition(int n, int[][] dislikes) {
        //create adjecency list
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] a:dislikes){
            map.computeIfAbsent(a[0],val->new ArrayList<Integer>()).add(a[1]);
            map.computeIfAbsent(a[1],val->new ArrayList<Integer>()).add(a[0]);
        }
        
        // bfs with alternate color
        Queue<Integer> q=new LinkedList<>();
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        
        
        for(int i=1;i<=n;i++){
            if(color[i]!=-1) continue;
            q.offer(i);
            color[i]=0;
            while(!q.isEmpty()){
                int cur=q.poll();
                List<Integer> enemies =map.getOrDefault(cur,new ArrayList<>());
                for(int enemy:enemies){
                  // returns false if neighbour has same color
                    if(color[cur]==color[enemy]) return false;
                  // assign different color to neighbour and push to q
                    if(color[enemy]==-1){
                        color[enemy]=1-color[cur];
                        q.offer(enemy);
                    }
                }
            }
        }
        
        return true;
    }
}
