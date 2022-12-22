class DponTree {
    int[] ans,count;
    int N;
    List<Set<Integer>> graph;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        graph=new ArrayList<>();
        for(int i=0;i<n;i++) {
            graph.add(new HashSet<Integer>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        ans = new int[n];
        count = new int[n];
        Arrays.fill(count,1);
        
        dfs(0,-1);
        dfs2(0,-1);
        
        return ans;
        
    }
    
    private void dfs(int node,int parent){
        
       Set<Integer> nbrs = graph.get(node);
        for(int child:nbrs){
            if(child!=parent){
                dfs(child,node);
                count[node] += count[child];
                ans[node] += ans[child] + count[child];
            }
        }
        
    }
    
    private void dfs2(int node,int parent){
        
        Set<Integer> nbrs = graph.get(node);
        for(int child:nbrs){
            if(child!=parent){
                ans[child] = ans[node] - count[child] + (N - count[child]);
                dfs2(child,node);
            }
        }
        
    }
}

//refernence: https://leetcode.com/problems/sum-of-distances-in-tree/submissions/
