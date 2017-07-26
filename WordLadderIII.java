// Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
//
// Only one letter can be changed at a time
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// For example,
//
// Given:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log","cog"]
// Return
//   [
//     ["hit","hot","dot","dog","cog"],
//     ["hit","hot","lot","log","cog"]
//   ]
// Note:
// Return an empty list if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.


import java.util.*;

public class WordLadderIII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        if (wordList.isEmpty()){
            return new ArrayList<>();
        }

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        //bfs to find the shortest count
        int distance = bfs(beginWord, endWord, wordSet);
        System.out.println(distance);
        // dfs to find the combinations
        List<String>       path      = new ArrayList<>();
        List<List<String>> pathes    = new ArrayList<>();
        Set<String>        isVisited = new HashSet<>();
        dfs(beginWord, endWord, distance, path, pathes, isVisited, wordSet);
        return pathes;
    }

    private void dfs(String beginWord, String endWord, int distance, List<String> path, List<List<String>> pathes, Set<String> isVisited, Set<String> wordSet){
        // base
        if ((path.size() == distance) && path.get(path.size() - 1).equals(endWord)){
            List<String> pathCopy = new ArrayList<>(path);
            pathes.add(pathCopy);
            return;
        }

        if(path.size() >= distance){
          return;
        }

        if (isVisited.contains(beginWord)){
            return;
        }

        // visit the node
        path.add(beginWord);
        isVisited.add(beginWord);

        Set<String> childNodes = getChildNodes(beginWord, isVisited, wordSet);

        for(String childNode : childNodes){
          dfs(childNode, endWord, distance, path, pathes, isVisited, wordSet);
        }

        // reset
        isVisited.remove(beginWord);
        path.remove(path.size()-1);

        return;
    }

    private int bfs(String beginWord, String endWord, Set<String> wordSet){
        // level by level
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int distance = 1;

        Set<String> isVisited = new HashSet<>();

        while (!queue.isEmpty()){
            Queue<String> nextQueue = new LinkedList<>();

            while (!queue.isEmpty()){
                String node = queue.poll();

                if (isVisited.contains(node)){
                    continue;
                }

                // visit the node
                if (node.equals(endWord)){
                    return distance;
                }

                isVisited.add(node);
                // add childNodes
                Set<String> childNodes = getChildNodes(node, isVisited, wordSet);
                nextQueue.addAll(childNodes);
            }

            // replace by the collection of next level nodes
            queue = nextQueue;
            distance++;
        }
        return -1;
    }

    private Set<String> getChildNodes(String node, Set<String> isVisited, Set<String> wordSet){
        Set<String> childNodes = new HashSet<>();

        for (int i = 0; i < node.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                StringBuffer sb = new StringBuffer(node);
                sb.setCharAt(i, c);

                if (!isVisited.contains(sb.toString()) && wordSet.contains(sb.toString())){
                    childNodes.add(sb.toString());
                }
            }
        }
        return childNodes;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord   = "cog";

        String[]     strs     = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
        List<String> wordList = Arrays.asList(strs);

        WordLadderIII       w      = new WordLadderIII();
        List<List<String>> pathes = w.findLadders(beginWord, endWord, wordList);

        for (List<String> path : pathes){
            System.out.print("[");
            for (String str : path){
                System.out.print(str + " ");
            }
            System.out.println("]");
        }
    }
}
