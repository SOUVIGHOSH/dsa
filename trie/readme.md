# Trie
Trie data structure is used for searching string, This is also know as Prefix Tree

## Implementation

Trie data structure has TrieNode which has two properties -> a. children which is a map off character or an array of size 26, b. boolean flag to denote is
the current node mards a valid word or not

```
 class TrieNode{
 
     Map<Character,TrieNode> children;
     booolean isWord = false;
     
 }
 ```
 
 ### Insert Algo
 ```
 Initialize cur = root
 for each character in string
     if cur children does not have the character 
        insert a new trienode into cur.children
      cur=cur.children.get(character)
 cur.isWord = true;
 ```
 
 ### Search Algo
 Initialize cur=root
 for each character in string
    if cur children does not have the character
      return false
    cur.cur.children.get(character)
 return cur.isWord   
 
