class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    public static void makeGraph(HashMap<Integer, List<Integer>> adj, int parent, TreeNode curr){
        if(curr == null){
            return;
        }
        adj.putIfAbsent(curr.val, new ArrayList<>());

        if(parent != -1){
            adj.get(curr.val).add(parent);
            adj.get(parent).add(curr.val);
        }

        makeGraph(adj, curr.val, curr.left);
        makeGraph(adj, curr.val, curr.right);
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        makeGraph(adj, -1, root);

        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);

        int minutes = 0;

        while(!q.isEmpty()){
            int n = q.size();

            while(n-->0){
                int curr = q.poll();

                for(int ngbr : adj.get(curr)){
                    if(!visited.contains(ngbr)){
                        q.offer(ngbr);
                        visited.add(ngbr);
                    }
                }
            }

            if(!q.isEmpty()){
                    minutes++;
                }
        }

        return minutes;
    }
}
