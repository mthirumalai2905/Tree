import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> index = new LinkedList<>();
        q.offer(root);
        index.offer(0);
        int maxWidth = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            int start = index.peek(); 
            int end = 0;

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                int currIndex = index.poll();
                end = currIndex; 

                if (curr.left != null) {
                    q.offer(curr.left);
                    index.offer(2 * currIndex);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                    index.offer(2 * currIndex + 1);
                }
            }

            maxWidth = Math.max(maxWidth, end - start + 1);
        }

        return maxWidth;
    }
}
