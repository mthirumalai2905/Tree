import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        // Step 1: Build the graph
        Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
        buildGraph(root, null, graph);
        
        // Step 2: Perform BFS
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.offer(target);
        visited.add(target);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (level == k) {
                while (!queue.isEmpty()) {
                    result.add(queue.poll().val);
                }
                return result;
            }
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for (TreeNode neighbor : graph.get(node)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            
            level++;
        }
        
        return result;
    }
    
    private void buildGraph(TreeNode node, TreeNode parent, Map<TreeNode, List<TreeNode>> graph) {
        if (node == null) return;
        
        if (!graph.containsKey(node)) {
            graph.put(node, new ArrayList<>());
        }
        if (parent != null) {
            graph.get(node).add(parent);
            graph.get(parent).add(node);
        }
        
        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }
}
