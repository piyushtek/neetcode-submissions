/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int dia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return dia-1;
    }
    int solve(TreeNode root){
        if(root==null)
            return 0;

        int l=solve(root.left);
        int r=solve(root.right);
        int ans1 = Math.max(l,r)+1;
        int ans2 = l+r+1;
        dia = Math.max(ans2,dia);
        return ans1;
    }
}
