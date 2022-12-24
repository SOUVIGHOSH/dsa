class AlienDictionary {
    public String alienOrder(String[] words) {

        // map to store inorder degree for each characters
        Map<Character,Integer> inorder = new HashMap<>();
        // adjacency list
        Map<Character,List<Character>> map= new HashMap<>();
        for(String word:words){
            for(char c:word.toCharArray()) {
                inorder.put(c,0);
                map.put(c,new ArrayList<Character>());
            }
        }
        
        
        // build graph
        for(int i=0;i<words.length-1;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            //checks if word1 starts with word2 then not possible to identify order example "abcd" & "ab"
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
            return "";
            }
            // find first non matching characters{
            for(int j=0;j<Math.min(word1.length(),word2.length());j++){
                if(word1.charAt(j)!=word2.charAt(j)){
                    map.get(word1.charAt(j)).add(word2.charAt(j));
                    inorder.put(word2.charAt(j),inorder.get(word2.charAt(j))+1);
                    break;
                }
            }
        }
        // queue for bfs traversal
        Queue<Character> queue = new LinkedList<>();
        // push the characters who has no dep i.e. inorder is 0
        for(char key:inorder.keySet()){
            if(inorder.getOrDefault(key,0)==0) queue.offer(key);
        }
        
        // set to track visited 
        Set<Character> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        
        //bfs traversal
        while(!queue.isEmpty()){
            //System.out.println(queue+" "+inorder);
            char cur= queue.poll();
            if(set.contains(cur)) return "";
            set.add(cur);
            sb.append(cur);
            //reduce inorder and if it gets 0 offer to Queue
            for(char next:map.get(cur)){
                inorder.put(next,inorder.get(next)-1);
                if(inorder.get(next)==0) queue.offer(next);
            }
        }
        
        if (sb.length() < inorder.size()) {
        return "";
        }
        
        return sb.toString();
        
    }
}
