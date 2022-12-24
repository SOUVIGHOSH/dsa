/*

  Find Minimum spanning tree with Kruskal's algorithm
  Time Complexity: O(E \cdot \log E)O(E⋅logE). Here, EE represents the number of edges.

  At first, we need to sort all the edges of the graph in ascending order. Sorting will take O(E \log E)O(ElogE) time.
  Next, we can start building our minimum spanning tree by selecting which edges should be included. For each edge, we will look at whether both of the vertices of the edge belong to the same connected component; which is an O(\alpha(V))O(α(V)) operation, where \alphaα refers to the Inverse Ackermann function. In the worst case, the tree will not be complete until we reach the very last edge (the edge with the largest weight), so this process will take O(E \alpha(V))O(Eα(V)) time.
  Therefore, in total, the time complexity is O(E \log E + E \alpha(V)) = O(E \log E)O(ElogE+Eα(V))=O(ElogE).
  Space Complexity: O(V)O(V). VV represents the number of vertices. Keeping track of the root of every vertex in the union-find data structure requires O(V)O(V) space. However, depending on the sorting algorithm used, different amounts of auxiliary space will be required to sort the list of edges in place. For instance, Timsort (used by default in python) requires O(E)O(E) space in the worst-case scenario, while Java uses a variant of quicksort whose space complexity is O(\log E)O(logE).

*/
class MST {
    public int minCostConnectPoints(int[][] points) {
        // number of vertices
        int n=points.length;
        // initialize union find or disjoint set data structure to find whether there is any cycle if we include an edge in alpha(V) time complexity
        // alpha in inverse acherman function
        UF ds=new UF(n);
        // Uses PriorityQueue to sort the edges according to weight this take ELogE time complexity.
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(
            (a,b)->distance(points[a[0]],points[a[1]])-distance(points[b[0]],points[b[1]]));
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                minHeap.offer(new int[]{i,j});
            }
        }
        int count=0;
        int cost=0;
        // MST has n-1 edges
        while(count != n-1){
            int[] indexes=minHeap.poll();
            int p1=indexes[0];
            int p2=indexes[1];
            if(!ds.isConnected(p1,p2)){
                ds.union(p1,p2);
                count++;
                cost+= distance(points[p1],points[p2]);
            }
        }
        return cost;
       
    }
    private int distance(int[] p1,int[] p2){
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
    // Union Find data structure
    class UF{
        int[] root,rank;
        UF(int size){
            root = new int[size];
            rank = new int[size];
            for(int i=0;i<size;i++){
                root[i]=i;
                rank[i]=1;
            }
        }
        public boolean isConnected(int a,int b){
            return find(a)==find(b);
        }
        public int find(int a){
            if(root[a]==a) return a;
            else return root[a]=find(root[a]);
        }
        public void union(int a,int b){
            int roota=find(a);
            int rootb=find(b);
            if(roota!=rootb){
                if(rank[roota]>rank[rootb]) root[rootb]=roota;
                else if(rank[rootb]>rank[roota]) root[roota]=rootb;
                else{
                    root[roota]=rootb;
                    rank[rootb]++;
                }
            }
        }
    }
}
