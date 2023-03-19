function Node(){
    this.keys=new Map();
    this.isWord=false;
}
var WordDictionary = function() {
    this.root=new Node();
};

/** 
 * @param {string} word
 * @return {void}
 */
WordDictionary.prototype.addWord = function(word) {
    let cur=this.root;
    for(let c of word){
        if(!(cur.keys.has(c))){
            cur.keys.set(c,new Node());
        }
        cur=cur.keys.get(c);
    }
    cur.isWord=true;
};

/** 
 * @param {string} word
 * @return {boolean}
 */
WordDictionary.prototype.search = function(word) {
    return searchHelper(word,this.root);
};

searchHelper = function(word,root){
    if(word.length==0) return root.isWord;
    let cur=root;
    for(let i=0;i<word.length;i++){
        let c= word.charAt(i);
        if(c==='.'){
            for(let k of cur.keys.keys()){
                if(searchHelper(word.substring(i+1),cur.keys.get(k))) return true;
            }
            return false;
        }
        else if(!cur.keys.has(c)) return false;
        cur = cur.keys.get(c);
    }
    return cur.isWord;
}

/** 
 * Your WordDictionary object will be instantiated and called as such:
 * var obj = new WordDictionary()
 * obj.addWord(word)
 * var param_2 = obj.search(word)
 */
