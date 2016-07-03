/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
     public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        Map<UndirectedGraphNode, UndirectedGraphNode> map = 
                                   new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, newHead);
 
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            List<UndirectedGraphNode> currNeighbors = curr.neighbors; 
 
            for(UndirectedGraphNode aNeighbor: currNeighbors){
                if (!map.containsKey(aNeighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    queue.add(aNeighbor);
                }
                map.get(curr).neighbors.add(map.get(aNeighbor));
            }
        }
        return newHead;
    }
}