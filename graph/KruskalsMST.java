package dsa.graph;

import java.util.PriorityQueue;

public class KruskalsMST {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Edge> pq=new PriorityQueue<>((a, b)->a.cost-b.cost);

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int cost=Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
                pq.offer(new Edge(i,j,cost));
            }
        }

        int n=points.length;
        UF ds=new UF(n);
        int count=n-1;
        int cost=0;
        while(!pq.isEmpty() && count>0){

            Edge cur=pq.poll();
            if(!ds.isconnected(cur.a,cur.b)){
                ds.union(cur.a,cur.b);
                cost += cur.cost;
                count--;
            }

        }
        return cost;
    }
    class Edge{
        int a,b;
        int cost;
        Edge(int a,int b,int cost){
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    class UF{
        int[] root;
        int[] rank;

        UF(int n){
            root=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) {
                root[i]=i;
                rank[i]=1;
            }

        }

        public int find(int x){
            if(x==root[x]) return x;
            else return root[x]=find(root[x]);
        }

        public void union(int a,int b){
            int aroot= find(a);
            int broot= find(b);
            if(aroot != broot){
                if(rank[aroot]>rank[broot]){
                    root[broot]=aroot;
                }
                else if(rank[broot]>rank[aroot]) root[aroot]=broot;
                else{
                    root[aroot]=broot;
                    rank[broot]++;
                }
            }
        }

        public boolean isconnected(int a,int b){
            return find(a)==find(b);
        }
    }
}
