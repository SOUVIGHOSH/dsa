class ParallelCourse {
    public int minimumSemesters(int n, int[][] relations) {
        int[] inorder = new int[n+1];
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int[] rel:relations){
            map.computeIfAbsent(rel[0],val->new ArrayList<Integer>()).add(rel[1]);
            inorder[rel[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inorder[i]==0) q.offer(i);
        }
        Set<Integer> set=new HashSet<>();
        int step=0;
        int count=0;
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                int cur=q.poll();
                if(set.contains(cur)) return -1;
                count++;
                set.add(cur);
                for(int next:map.getOrDefault(cur,new ArrayList<>())){
                    inorder[next]--;
                    if(inorder[next]==0) q.offer(next);
                }
            }
            step++;
        }
        return count==n?step:-1;
    }
}
