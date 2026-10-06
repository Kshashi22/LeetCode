class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Maximum contribution from left and right subtrees
        int leftGain = Math.max(0, dfs(node.left));
        int rightGain = Math.max(0, dfs(node.right));

        // Maximum path passing through the current node
        int currentPath = node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPath);

        // Return the best single branch to the parent
        return node.val + Math.max(leftGain, rightGain);
    }
}