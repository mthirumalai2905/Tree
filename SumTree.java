class Solution {
    boolean isSumTree(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        
        int leftTree = GetFunc(root.left);
        int rightTree = GetFunc(root.right);
        return (root.data == leftTree + rightTree) && isSumTree(root.left) && isSumTree(root.right);
    }
    public static int GetFunc(Node root){
        if(root == null) return 0;
        return root.data + GetFunc(root.left) + GetFunc(root.right);
    }
}
