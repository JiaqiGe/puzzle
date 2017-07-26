// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest
// transformation sequence from beginWord to endWord, such that:
//
// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
//
// Note:
// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.

// level by level breadth-first search

import java.util.*;

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList){
    // bfs
    if (beginWord.isEmpty()){
      return 0;
    }

    Set<String> wordSet = new HashSet<>();
    wordSet.addAll(wordList);

    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    Set<String> isVisited = new HashSet<>();
    boolean     isFound   = false;

    int count = 1;

    while (!isFound && !queue.isEmpty()){

      Queue<String> nextQueue = new LinkedList<>();
      while(!queue.isEmpty()){
        String current = queue.poll();

        if(current.equals(endWord)){
          return count;
        }

        if(isVisited.contains(current)){
          continue;
        }

        Set<String> childs = getChildren(current, isVisited, wordSet);
        isVisited.add(current);
        nextQueue.addAll(childs);
      }
      queue = nextQueue;
      count++;
    }

    if(!isFound){
      count = 0;
    }
    return count;
  }

  private Set<String> getChildren(String s, Set<String> isVisited, Set<String> wordSet){
    Set<String> strSet = new HashSet<>();

    for (int i = 0; i < s.length(); i++){
      for (char c = 'a'; c <= 'z'; c++){
        if (s.charAt(i) != c){
          StringBuffer sb = new StringBuffer(s);
          sb.setCharAt(i, c);
          if(!isVisited.contains(sb.toString())){
            strSet.add(sb.toString());
          }
        }
      }
    }
    strSet.retainAll(wordSet);
    return strSet;
  }


  public static void main(String[] args){
    String beginWord = "hit";
    String endWord = "cog";
    String[] strs = new String[]{"hot","dot","dog","lot","log","cog"};
    List<String> wordList = Arrays.asList(strs);

    WordLadder w = new WordLadder();
    System.out.println(w.ladderLength(beginWord, endWord, wordList));
  }
}
