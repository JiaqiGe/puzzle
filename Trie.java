class TrieNode{
  boolean isWord;
  String value;
  TrieNode[] next;

  public TrieNode(){
    isWord = false;
    value = "";
    next = new TrieNode[26];
  }
}


public class Trie{
  TrieNode root;

  public Trie(){
    root = new TrieNode();
  }

  public boolean search(String word){
    return search(word, root);
  }

  private boolean search(String word, TrieNode root){
    // base
    if(root == null){
      return false;
    }

    if(word.isEmpty()){
      return root.isWord;
    }

    // recuisive function
    boolean r = false;
    if(word.charAt(0) != '.'){
      int idx = word.charAt(0) - 'a';
      r = r || search(word.substring(1), root.next[idx]);
    }else{
      for(int i = 0; i < root.next.length; i++){
        r = r || search(word.substring(1), root.next[i]);
      }
    }
    return r;
  }

  public void insert(String word){
    insert(word, root);
  }

  private void insert(String word, TrieNode root){
    // base
    if(word.isEmpty()){
      root.isWord = true;
      return;
    }

    // recursion
    int idx = word.charAt(0) - 'a';
    if(root.next[idx] == null){
      TrieNode n = new TrieNode();
      n.isWord = false;
      n.value = root.value + word.charAt(0);
      root.next[idx] = n;
    }
    insert(word.substring(1), root.next[idx]);
    return;
  }

  public static void main(String[] args){
    Trie t = new Trie();
    t.insert("abc");
    t.insert("adc");
    t.insert("abc");
    System.out.println(t.search("ab"));
  }
}
