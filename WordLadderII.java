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

public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList){
        // bfs to get the minimal length
        // dfs to build path

        if (wordList.isEmpty()){
            return new ArrayList<>();
        }

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);

        Set<String> isVisited = new HashSet<>();

        int distance = bfs(beginWord, endWord, wordSet, isVisited);

        List<List<String>> pathes = new ArrayList<>();
        List<String>       path   = new ArrayList<>();
        isVisited.clear();
        dfs2(beginWord, endWord, distance, wordSet, isVisited, path, pathes);
        return pathes;
    }

    public void dfs2(String beginWord, String endWord, int distance, Set<String> wordSet,
                     Set<String> isVisited, List<String> path, List<List<String>> pathes){
        if ((path.size() == distance) && path.get(path.size()-1).equals(endWord)){
            List<String> newPath = new ArrayList<>(path);
            pathes.add(newPath);
            return;
        }

        if (path.size() >= distance){
            return;
        }

        if (isVisited.contains(beginWord)){
            return;
        }

        // visit
        isVisited.add(beginWord);
        path.add(beginWord);

        //dfs
        Set<String> childNodes = getChildNode(beginWord, wordSet, isVisited);
        for (String node : childNodes){
            dfs(node, endWord, distance, wordSet, isVisited, path, pathes);
        }

        // reset
        isVisited.remove(beginWord);
        path.remove(path.size() - 1);
    }

    public void dfs(String beginWord, String endWord, int distance, Set<String> wordSet,
                    Set<String> isVisited, List<String> path, List<List<String>> pathes){
        if ((path.size() == distance - 1) && beginWord.equals(endWord)){
            List<String> newPath = new ArrayList<>(path);
            newPath.add(endWord);
            pathes.add(newPath);
            return;
        }

        if (path.size() >= distance){
            return;
        }

        if (isVisited.contains(beginWord)){
            return;
        }

        isVisited.add(beginWord);
        path.add(beginWord);

        //dfs
        Set<String> childNodes = getChildNode(beginWord, wordSet, isVisited);
        for (String node : childNodes){
            dfs(node, endWord, distance, wordSet, isVisited, path, pathes);
        }

        isVisited.remove(beginWord);
        path.remove(path.size() - 1);
    }

    public int bfs(String beginWord, String endWord, Set<String> wordSet, Set<String> isVisited){
        //bfs level by level
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()){
            Queue<String> nextQueue = new LinkedList<>();

            while (!queue.isEmpty()){
                String node = queue.poll();

                if (node.equals(endWord)){
                    return level;
                }

                if (isVisited.contains(node)){
                    continue;
                }

                isVisited.add(node);

                Set<String> childNodes = getChildNode(node, wordSet, isVisited);
                nextQueue.addAll(childNodes);
            }
            queue = nextQueue;
            level++;
        }

        return -1;
    }

    private Set<String> getChildNode(String node, Set<String> wordSet, Set<String> isVisited){
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

        WordLadderII       w      = new WordLadderII();
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
