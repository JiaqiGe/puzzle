// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
//
//
// OJ's undirected graph serialization:
// Nodes are labeled uniquely.
//
// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.
//
// The graph has a total of three nodes, and therefore contains three parts as separated by #.
//
// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:
//
//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/

import java.util.*;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){ label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
      // clone nodes first
      // bfs

      if(node == null){
        return null;
      }

      Queue<UndirectedGraphNode> queue = new LinkedList<>();
      queue.offer(node);
      Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

      while(!queue.isEmpty()){
        UndirectedGraphNode curNode = queue.poll();
        if(!map.containsKey(curNode)){
          map.put(curNode, new UndirectedGraphNode(curNode.label));

          for(UndirectedGraphNode neighbor : curNode.neighbors){
            queue.offer(neighbor);
          }
        }
      }

      // set up connections
      for(Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()){
        UndirectedGraphNode oneNode = entry.getKey();
        UndirectedGraphNode cloneNode = entry.getValue();

        for(UndirectedGraphNode neighbor : oneNode.neighbors){
            cloneNode.neighbors.add(map.get(neighbor));
        }
      }

      return map.get(node);
    }
}
