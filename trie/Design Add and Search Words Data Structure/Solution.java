class WordDictionary {
    
    class TrieNode{
        boolean isWord;
        Map<Character,TrieNode> children;
        public TrieNode(){
            children=new HashMap<>();
            isWord=false;
        }
        
    }
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode cur=root;
        for(char c:word.toCharArray()){
            if(cur.children.containsKey(c)){
                cur=cur.children.get(c);
            }
            else{
                cur.children.put(c,new TrieNode());
                cur=cur.children.get(c);
            }
        }
        cur.isWord=true;
    }
    
    public boolean search(String word) {
        TrieNode cur=root;
        return helper(word,cur);
    }
    public boolean helper(String word,TrieNode cur){
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c=='.'){
                if(i==word.length()-1){
                    for(TrieNode n:cur.children.values()){
                        if(n.isWord) return true;
                    }
                    return false;
                }
                boolean flag=false;
                for(TrieNode node:cur.children.values()){
                    flag=helper(word.substring(i+1),node);
                    if(flag) return true;
                }
                return flag;
            }
            else{
                if(cur.children.containsKey(c)){
                    if(i==word.length()-1) return cur.children.get(c).isWord;
                    return helper(word.substring(i+1),cur.children.get(c));
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
